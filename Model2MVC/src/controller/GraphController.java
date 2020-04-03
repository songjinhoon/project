package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ActionAnnotation;
import action.RequestMapping;
import action.RequestMapping.RequestMethod;
import chart.JSONObject;
import chart.WordCloud;
import model.Chart;
import repository.MybatisChartDao;

@SuppressWarnings("serial")
public class GraphController extends ActionAnnotation {

	@Override
	public void initProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "chart_main_WordCloud_Seccess", method = RequestMethod.GET)
	public String chart_main(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		MybatisChartDao service = MybatisChartDao.getInstance();
		int pageSize = 5; 
		int currentPage = 0; 
		String pageNum = request.getParameter("pageNum");
		try {
			currentPage = Integer.parseInt(request.getParameter("pageNum")); 
			session.setAttribute("pageNum", currentPage); 
		} catch (Exception e) {
			if (session.getAttribute("pageNum") == null) {
				session.setAttribute("pageNum", 1);
			}
		}
		currentPage = (int) session.getAttribute("pageNum");
		int startRow = (currentPage - 1) * pageSize + 1; 
		int endRow = startRow + pageSize - 1; 
		int count = service.selectCount();
		int number = count - (currentPage - 1) * pageSize; 
		List<Chart> list = service.getList(startRow, endRow);
		System.out.println("List" + list);
		List<Set<Map.Entry<String, Long>>> list2 = new ArrayList<>();
		String url1 = null;
		String selector = "div[class~=score_result]";
		int size = 25;
		if (request.getParameter("url1") != null && !request.getParameter("url1").equals("")) {
			url1 = request.getParameter("url1");
		}
		if (url1 == null){
			url1 = "https://movie.naver.com/movie/bi/mi/point.nhn?code=180025";
		}
		Map<String, Long> map = null;
		Set<Map.Entry<String, Long>> set = null;
		int cnt = 0;
		List<String> wordcloudID = new ArrayList<>();
		List<Map<String, Long>> test = new ArrayList<>();
		for(int i=0; i<list.size(); i++){
			Chart content = (Chart) list.get(i);
			url1 = content.getMovie_url();
			System.out.println(url1);
			map = WordCloud.map(url1, selector, 30);
			System.out.println(map);
			set = map.entrySet();
			cnt = set.size();
			wordcloudID.add("wordcloud2" + i);
			test.add(map);
		}
		int bottomLine = 5;
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		if (endPage > pageCount) {
			endPage = pageCount;
		}
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("bottomLine", bottomLine);
		request.setAttribute("list", list);
		request.setAttribute("test", test);
		request.setAttribute("wordcloudID", wordcloudID);
		request.setAttribute("size", size);
		

		return "/WEB-INF/view/graph/chart_main_WordCloud_Seccess.jsp";
	}
	
	@RequestMapping(value = "bar_sample_success", method = RequestMethod.GET)
	public String bar_sample_success(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MybatisChartDao service = MybatisChartDao.getInstance();
		List<Chart> numlist = service.getName(); 
		
	  	String[] names = new String[numlist.size()];

		
	 	Integer[] values = new Integer[numlist.size()];
		
		
	 	for(int i=0; i<numlist.size(); i++){
	 		Chart c = numlist.get(i);
			names[i]=c.getMovie_name();
			values[i]=c.getMovie_num();

		}
	 	JSONObject json = new JSONObject();
		json.setName("sample");
	 	json.putKey(names);

		Integer[] num = values;
		json.putValue(num);
		
		request.setAttribute("json", json);
		
		return "/WEB-INF/view/graph/bar_sample_success.jsp";
	}
}
