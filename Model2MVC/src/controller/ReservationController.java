package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionAnnotation;
import action.RequestMapping;
import action.RequestMapping.RequestMethod;
import dao.BookingDao;
import model.Booking;
import model.Movie;
import model.Schedule;
import repository.MybatisMovieDao;
import repository.MybatisScheduleDao;

@SuppressWarnings("serial")
public class ReservationController extends ActionAnnotation {

	@Override
	public void initProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "reservationForm", method = RequestMethod.GET)
	public String reservationForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MybatisScheduleDao service = MybatisScheduleDao.getInstance();
		List<Movie> listMovie = null;
		int count = service.countSchedule(); 

		if (session.getAttribute("mem_id").equals("1")) { // �α����� �Ǿ������ʴٸ� �α����������� �̵�
			return "redirect:/member/loginForm";
		}

		List<Schedule> check = new ArrayList<>();
		List<Movie> movieList = new ArrayList<Movie>();
		for (int i = 1; i <= count; i++) {
			MybatisMovieDao movieService = MybatisMovieDao.getInstance();
			Movie movie = movieService.getMovie(i);

			if (movie != null) {
				List<Schedule> li = service.getSchedule(movie.getMovie_num());
				if (!li.isEmpty()) {
					System.out.println(1);
					movie.setLi(li);
				} else {
					System.out.println(2);
					movie.setLi(new ArrayList<Schedule>());
				}
				System.out.println(movie + "=======");

				movieList.add(movie);
			}
		}

		request.setAttribute("movieList", movieList);
		request.setAttribute("count", count);
		request.setAttribute("check", check);

		return "/WEB-INF/view/reservation/reservationForm.jsp";
	}

	@RequestMapping(value = "reservationForm2", method = RequestMethod.POST)
	public String reservationForm2(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MybatisScheduleDao scheduleDao = MybatisScheduleDao.getInstance();

		int schedule_num = Integer.parseInt(request.getParameter("schedule_num"));
		Schedule schedule = scheduleDao.formSchedule(schedule_num);
		int movie_num = Integer.parseInt(request.getParameter("movie_num"));
		String movie_name = scheduleDao.getMovieName(movie_num);
		BookingDao bookingDao = BookingDao.getInstance();
		String checkedSeats = bookingDao.getCheckedSeats(schedule_num);
		System.out.println(schedule_num + ":" + movie_num);

		request.setAttribute("schedule_num", schedule_num);
		request.setAttribute("movie_num", movie_num);
		request.setAttribute("movie_name", movie_name);
		request.setAttribute("schedule", schedule);
		request.setAttribute("checkedSeats", checkedSeats);

		return "/WEB-INF/view/reservation/reservationForm2.jsp";
	}

	@RequestMapping(value = "reservationForm2", method = RequestMethod.GET)
	public String reservationForm22(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		MybatisScheduleDao scheduleDao = MybatisScheduleDao.getInstance();

		int schedule_num = Integer.parseInt(request.getParameter("schedule_num"));
		Schedule schedule = scheduleDao.formSchedule(schedule_num);
		int movie_num = Integer.parseInt(request.getParameter("movie_num"));
		String movie_name = scheduleDao.getMovieName(movie_num);
		BookingDao bookingDao = BookingDao.getInstance();
		String checkedSeats = bookingDao.getCheckedSeats(schedule_num);
		System.out.println(schedule_num + ":" + movie_num);

		request.setAttribute("schedule_num", schedule_num);
		request.setAttribute("movie_num", movie_num);
		request.setAttribute("movie_name", movie_name);
		request.setAttribute("schedule", schedule);
		request.setAttribute("checkedSeats", checkedSeats);

		return "/WEB-INF/view/reservation/reservationForm2.jsp";
	}

	
	@RequestMapping(value = "reservationPro", method = RequestMethod.POST)
	public String reservationPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		int schedule_num = Integer.parseInt(request.getParameter("schedule_num"));
		String mem_id = (String) session.getAttribute("mem_id"); // ���ǿ� ����� ���� �����´�
		String[] seats = request.getParameterValues("seat");

		Schedule schedule = new Schedule();

		try {
			for (int i = 0; i < seats.length; i++) {
				Booking booking = new Booking();
				booking.setMovie_num(schedule.getMovie_num());

				booking.setSchedule_num(schedule.getSchedule_num());
				booking.setSeat(seats[i]);

				BookingDao service = BookingDao.getInstance();
				service.insertBooking(booking, mem_id, schedule_num);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("mem_id", mem_id);
		request.setAttribute("seat", seats);
		request.setAttribute("schedule_num", schedule_num);
		
		return "/WEB-INF/view/reservation/reservationPro.jsp";
	}
	
	
	@RequestMapping(value = "bookingList", method = RequestMethod.GET)
	public String bookingList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String mem_id = (String) session.getAttribute("mem_id");
		BookingDao bookingDao = BookingDao.getInstance();
		Map<String, List<Schedule>> map = bookingDao.getBooking(mem_id);
		//String movie_name
		
	
			
		
		
		
		request.setAttribute("map", map);
		
		return "/WEB-INF/view/reservation/bookingList.jsp";
	}

	
	@RequestMapping(value = "bookingCancel", method = RequestMethod.GET)
	public String bookingCancel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		 String booking_nums = request.getParameter("booking_nums");
		 System.out.println(booking_nums);
		   String[] booking_numsArray = booking_nums.split(",");
		   
		      try {
		         for (int i = 0; i < booking_numsArray.length; i++) {
		        	 int a = Integer.parseInt(booking_numsArray[i]);
		        	 
		            BookingDao service = BookingDao.getInstance();

		            service.deleteBooking(a);
		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      
		return "/WEB-INF/view/reservation/bookingCancel.jsp";
	}
}
