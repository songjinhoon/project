package controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.ActionAnnotation;
import action.RequestMapping;
import action.RequestMapping.RequestMethod;
import model.Movie;
import model.Movie_contents;
import model.Review;
import model.Schedule;
import repository.MybatisMovieDao;
import repository.MybatisScheduleDao;

@SuppressWarnings("serial")
public class MovieController extends ActionAnnotation {

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
	
	@RequestMapping(value = "movieInputForm", method = RequestMethod.GET)
	public String movieInputForm(HttpServletRequest request, HttpServletResponse response){
		
		return "/WEB-INF/view/movie/movieInputForm.jsp";
	}
	
	@RequestMapping(value = "movieInputPro", method = RequestMethod.POST)
	public String movieInputPro(HttpServletRequest request, HttpServletResponse response){
		String realFolder = "";
		String saveFolder = "uploadFile";
		String encType = "UTF-8";
		int maxSize = 10 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		try {
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			Movie movie = new Movie();
			Enumeration files = multi.getFileNames(); 
			if (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				File file = multi.getFile(name);
				if (file != null) {
					movie.setFilename(file.getName());
				} else {
					movie.setFilename("");
				}
			}
			movie.setMovie_name(multi.getParameter("movie_name"));
			movie.setMovie_theme(multi.getParameter("movie_theme"));
			movie.setMovie_url(multi.getParameter("movie_url"));
			MybatisMovieDao service = MybatisMovieDao.getInstance();
			service.movieInsert(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/WEB-INF/view/movie/movieInputForm.jsp";
	}

	@RequestMapping(value = "movie_info", method = RequestMethod.GET)
	public String movie_info(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int movie_num = Integer.parseInt(request.getParameter("movie_num"));
		MybatisMovieDao service = MybatisMovieDao.getInstance();
		List<Movie_contents> li = service.getMovieList(movie_num);
		Movie subContent = service.getMovie(movie_num);
		request.setAttribute("li", li);
		request.setAttribute("subContent", subContent);

		return "/WEB-INF/view/movie/movie_info.jsp";
	}

	@RequestMapping(value = "movie_list", method = RequestMethod.GET)
	public String movie_list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MybatisMovieDao service = MybatisMovieDao.getInstance();
		List<Schedule> listSchedule = service.getScheduleMovieList();
		System.out.println(listSchedule.size());
		List<Movie> listMovie = new ArrayList<>();
		Movie movie = null;
		if (listSchedule != null) {
			for (int i = 0; i < listSchedule.size(); i++) {
				int movie_num = listSchedule.get(i).getMovie_num();
				movie = service.getMovie(movie_num);
				listMovie.add(movie);
			}
		}
		request.setAttribute("listSchedule", listSchedule);
		request.setAttribute("listMovie", listMovie);

		return "/WEB-INF/view/movie/movie_list.jsp";
	}

	@RequestMapping(value = "movieContentInputForm", method = RequestMethod.GET)
	public String movieContentInputForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MybatisMovieDao service = MybatisMovieDao.getInstance();
		List<Movie> li = service.getMovies2();
		request.setAttribute("li", li);

		return "/WEB-INF/view/movie/movieContentInputForm.jsp";
	}

	@RequestMapping(value = "movieContentInputPro", method = RequestMethod.POST)
	public String movieContentInputPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MybatisMovieDao service = MybatisMovieDao.getInstance();
		Movie_contents contents = new Movie_contents();
		int movie_num = Integer.parseInt(request.getParameter("movie_num"));
		Movie movie = service.getMovie(movie_num);
		contents.setMovie_num(movie_num);
		contents.setMovie_subject(movie.getMovie_name());
		contents.setMovie_content(request.getParameter("movie_content"));
		contents.setMovie_actor(request.getParameter("movie_actor"));
		contents.setRunning_time(Integer.parseInt(request.getParameter("running_time")));
		contents.setUrl(request.getParameter("url"));
		service.insertMovieContents(contents);
		
		return "redirect:/main/main";
	}

	 @RequestMapping(value = "review_list", method = RequestMethod.GET)
	   public String review_list(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      MybatisMovieDao service = MybatisMovieDao.getInstance();
	      HttpSession session = request.getSession();
	      String mem_id = (String) session.getAttribute("mem_id");
	      int movie_num = Integer.parseInt(request.getParameter("movie_num"));
	      Movie subContent = service.getMovie(movie_num);
	      request.setAttribute("subContent", subContent);
	      
	      List<Review> li = service.getReview(movie_num);
	      request.setAttribute("li", li);
	      request.setAttribute("movie_num", movie_num);
	      request.setAttribute("mem_id", mem_id);
	      
	      return "/WEB-INF/view/movie/review_list.jsp";
	   }

	@RequestMapping(value = "reviewPro", method = RequestMethod.POST)
	public String reviewPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MybatisMovieDao service = MybatisMovieDao.getInstance();
		Review review = new Review();
		review.setContent(request.getParameter("content"));
		review.setMem_id(request.getParameter("mem_id"));
		review.setMovie_num(Integer.parseInt(request.getParameter("movie_num")));
		service.insertReview(review);
		
		return "redirect:/movie/review_list?movie_num=" + review.getMovie_num() + "&mem_id=" + review.getMem_id();
	}

	@RequestMapping(value = "scheduleInputForm", method = RequestMethod.GET)
	public String scheduleInputForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MybatisMovieDao service = MybatisMovieDao.getInstance();
		List<Movie> list = service.getMovies2();
		request.setAttribute("list", list);

		return "/WEB-INF/view/movie/scheduleInputForm.jsp";
	}

	@RequestMapping(value = "scheduleInputPro", method = RequestMethod.POST)
	public String scheduleInputPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Schedule schedule = new Schedule();
		schedule.setMovie_num(Integer.parseInt(request.getParameter("movie_num")));
		schedule.setMovie_price(Integer.parseInt(request.getParameter("movie_price")));
		schedule.setLoc_num(Integer.parseInt(request.getParameter("loc_num")));
		String movie_date = request.getParameter("movie_date");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm");
		java.util.Date change = sdf.parse(movie_date);
		Date date = new Date(change.getTime());
		schedule.setMovie_date(date);
	    
	    
	    MybatisScheduleDao service = MybatisScheduleDao.getInstance();
	    service.scheduleInsert(schedule);

		return "redirect:/main/main";
	}
}
