package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionAnnotation;
import action.RequestMapping;
import action.RequestMapping.RequestMethod;

@SuppressWarnings("serial")
public class MainController extends ActionAnnotation {

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
		request.setAttribute("main", "main");
	}

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String list(HttpServletRequest request, HttpServletResponse response) {

		return "/WEB-INF/view/main/main.jsp";
	}
}
