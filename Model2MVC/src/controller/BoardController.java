package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionAnnotation;
import action.RequestMapping;
import action.RequestMapping.RequestMethod;
import repository.MybatisBoardDao;
import model.Board;

@SuppressWarnings("serial")
public class BoardController extends ActionAnnotation {

	@Override
	public void initProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String mem_id = null;
		if((String)session.getAttribute("mem_id") == null){
			mem_id = "1";
			session.setAttribute("mem_id", mem_id);
		}else{
			mem_id = (String)session.getAttribute("mem_id");
		}
		request.setAttribute("mem_id", mem_id);
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String boardid = (String) request.getParameter("boardid");
		session.setAttribute("boardid", boardid);
		if (boardid == null) {
			boardid = "1";
			session.setAttribute("boardid", boardid);
		}
		int currentPage = 0;
		try {
			currentPage = Integer.parseInt(request.getParameter("pageNum"));
			session.setAttribute("pageNum", currentPage); 
		} catch (Exception e) {
			if (session.getAttribute("pageNum") == null) {
				session.setAttribute("pageNum", 1);
			}
		}
		currentPage = (int) session.getAttribute("pageNum"); 
		String pageNum = request.getParameter("pageNum"); 
		int pageSize = 10; 
		if (pageNum == null || pageNum.equals("")) { 
			pageNum = "1";
		}
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;

		MybatisBoardDao service = MybatisBoardDao.getInstance();
		int count = service.getArticleCount(boardid); 
		List<Board> li = service.getArticles(startRow, endRow, boardid);
		int number = count - (currentPage - 1) * pageSize;

		int bottomLine = 3;// 페이지번호의 단위
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1); 
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine; 
		int endPage = startPage + bottomLine - 1; 
		if (endPage > pageCount)
			endPage = pageCount;
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", number);
		request.setAttribute("bottomLine", bottomLine);
		request.setAttribute("li", li);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);

		return "/WEB-INF/view/board/list.jsp";
	}

	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String content(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		}
		MybatisBoardDao service = MybatisBoardDao.getInstance();
		Board article = service.getArticle(board_num);
		request.setAttribute("article", article);

		return "/WEB-INF/view/board/content.jsp";
	}

	@RequestMapping(value = "deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pageNum = request.getParameter("pageNum");
		MybatisBoardDao service = MybatisBoardDao.getInstance();
		Board article = service.getUpdateArticle(board_num);

		request.setAttribute("board_num", request.getParameter("board_num"));

		return "/WEB-INF/view/board/deleteForm.jsp";

	}

	@RequestMapping(value = "deletePro", method = RequestMethod.POST)
	public String deletePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String passwd = request.getParameter("passwd");
		MybatisBoardDao service = MybatisBoardDao.getInstance();
		int check = service.deleteArticle(board_num, passwd);
		if(check == 1){
			return "redirect:/board/list?boardid=1";
		}
		request.setAttribute("check", check);

		return "/WEB-INF/view/board/deletePro.jsp";
	}

	@RequestMapping(value = "updateForm", method = RequestMethod.GET)
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pageNum = request.getParameter("pageNum");
		MybatisBoardDao service = MybatisBoardDao.getInstance();
		Board article = service.getUpdateArticle(board_num);
		
		request.setAttribute("article", article);

		return "/WEB-INF/view/board/updateForm.jsp";
	}

	@RequestMapping(value = "updatePro", method = RequestMethod.POST)
	public String updatePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MybatisBoardDao service = MybatisBoardDao.getInstance();
		Board article = new Board();
		article.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		article.setMem_id(request.getParameter("mem_id"));
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setPasswd(request.getParameter("passwd"));
		int check = service.updateArticle(article);

		request.setAttribute("check", check);

		return "/WEB-INF/view/board/updatePro.jsp";
	}

	@RequestMapping(value = "writeForm", method = RequestMethod.GET)
	public String writeForm(HttpServletRequest request, HttpServletResponse response) {
		int board_num = 0, ref = 1, re_step = 0, re_level = 0;
		if (request.getParameter("board_num") != null) {
			board_num = Integer.parseInt(request.getParameter("board_num"));
			ref = Integer.parseInt(request.getParameter("ref"));
			re_step = Integer.parseInt(request.getParameter("re_step"));
			re_level = Integer.parseInt(request.getParameter("re_level"));
		}
		request.setAttribute("board_num", board_num);
		request.setAttribute("ref", ref);
		request.setAttribute("re_step", re_step);
		request.setAttribute("re_level", re_level);

		return "/WEB-INF/view/board/writeForm.jsp";
	}

	@RequestMapping(value = "writePro", method = RequestMethod.POST)
	public String writePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		Board article = new Board();
		article.setBoardid((String) request.getSession().getAttribute("boardid"));
		article.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		article.setRef(Integer.parseInt(request.getParameter("ref")));
		article.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		article.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		article.setMem_id(request.getParameter("mem_id"));
		System.out.println(article.getBoard_num());
		System.out.println(article.getRef());
		System.out.println(article.getRe_level());
		System.out.println(article.getRe_step());
		article.setSubject(request.getParameter("subject"));
		article.setContent(request.getParameter("content"));
		article.setPasswd(request.getParameter("passwd"));
		MybatisBoardDao service = MybatisBoardDao.getInstance();
		service.insertArticle(article);
		
		return "redirect:/board/list?boardid=1";
	}

}
