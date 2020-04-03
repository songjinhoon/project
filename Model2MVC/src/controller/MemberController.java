package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import repository.MybatisMemberDao;
import action.ActionAnnotation;
import action.RequestMapping;
import action.RequestMapping.RequestMethod;

@SuppressWarnings("serial")
public class MemberController extends ActionAnnotation {

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

	@RequestMapping(value = "inputForm", method = RequestMethod.GET)
	public String inputForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/view/member/inputForm.jsp";
	}
	
	@RequestMapping(value = "inputPro", method = RequestMethod.POST)
	public String inputPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String mem_id = request.getParameter("id");
		String gender = request.getParameter("gender");
		String mem_name = request.getParameter("name");
		String mem_passwd = request.getParameter("passwd");
		String mem_cell = request.getParameter("phone1") + request.getParameter("phone2") + request.getParameter("phone3");
		MybatisMemberDao service = MybatisMemberDao.getInstance();
		Member member = new Member();
		member.setMem_id(mem_id);
		member.setMem_name(mem_name);
		member.setMem_passwd(mem_passwd);
		member.setGender(gender);
		member.setMem_cell(mem_cell);
		service.insertMember(member);
		session.setAttribute("mem_id", mem_id);
		session.setAttribute("mem_passwd", mem_passwd);
		
		return "redirect:/main/main";
	}

	@RequestMapping(value = "loginForm", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/view/member/loginForm.jsp";
	}

	@RequestMapping(value = "loginPro", method = RequestMethod.POST)
	public String loginPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String mem_id = request.getParameter("mem_id");
		String mem_passwd = request.getParameter("mem_passwd");
		MybatisMemberDao service = MybatisMemberDao.getInstance();
		int check = service.userCheck(mem_id, mem_passwd);
		if (check == 1) {
			session.setAttribute("mem_id", mem_id);
			session.setAttribute("mem_passwd", mem_passwd);
			return "redirect:/main/main";
		}else{
			request.setAttribute("check", check);
			return "/WEB-INF/view/member/loginPro.jsp";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("mem_id");
		session.removeAttribute("mem_passwd");

		return "redirect:/main/main";
	}

	@RequestMapping(value = "modifyForm", method = RequestMethod.GET)
	public String modifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MybatisMemberDao service = MybatisMemberDao.getInstance();
		Member member = service.getMember((String) session.getAttribute("mem_id"));
		request.setAttribute("member", member);
		
		return "/WEB-INF/view/member/modifyForm.jsp";
	}

	@RequestMapping(value = "modifyPro", method = RequestMethod.POST)
	public String modifyPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String mem_id = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_cell = request.getParameter("mem_cell");
		String mem_passwd = request.getParameter("mem_passwd");
		MybatisMemberDao service = MybatisMemberDao.getInstance();
		service.updateMember(mem_id, mem_name, mem_cell, mem_passwd);
		request.setAttribute("mem_id", mem_id);
		request.setAttribute("mem_passwd", mem_passwd);
		
		return "redirect:/main/main";
	}
	
	
	@RequestMapping(value = "deleteForm", method = RequestMethod.GET)
	public String deleteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/WEB-INF/view/member/deleteForm.jsp";
	}
	
	@RequestMapping(value = "deletePro", method = RequestMethod.POST)
	public String deletePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		String mem_passwd = request.getParameter("mem_passwd");
		MybatisMemberDao service = MybatisMemberDao.getInstance();
		int check = service.deleteMember(mem_id, mem_passwd);
		request.setAttribute("check", check);
		if(check == -1){
			session.invalidate();
			return "redirect:/main/main";
		}
		
		return "/WEB-INF/view/member/deletePro.jsp";
	}
	
	@RequestMapping(value = "passwdCheckForm", method = RequestMethod.GET)
	public String passwdCheckForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/WEB-INF/view/member/passwdCheckForm.jsp";
	}
	
	@RequestMapping(value = "passwdCheckPro", method = RequestMethod.POST)
	public String passwdCheckPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_passwd = (String) session.getAttribute("mem_passwd");
		String check = request.getParameter("mem_passwd");
		request.setAttribute("mem_passwd", mem_passwd);
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/member/passwdCheckPro.jsp";
	}

}

