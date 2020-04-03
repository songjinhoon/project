package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import action.ActionAnnotation;
import action.RequestMapping;
import action.RequestMapping.RequestMethod;
import model.MovieModel;

@SuppressWarnings("serial")
public class DataChartController extends ActionAnnotation {

	@Override
	public void initProcess(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "dataChart", method = RequestMethod.GET)
	public String dataChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url1 = "http://www.cgv.co.kr/movies/";
		String title = "div.box-contents strong.title";
		String percent = "strong.percent span";
		String postLink = "span.thumb-image img";
		String movieLink = "div.box-image a";
		Document doc = null;
		try {
			doc = Jsoup.connect(url1).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements titles = doc.select(title);
		Elements percents = doc.select(percent);
		Elements postLinks = doc.select(postLink);
		Elements movieLinks = doc.select(movieLink);

		MovieModel movieModel = null;
		List<String> titleList = new ArrayList<>();
		List<String> percentList = new ArrayList<>();
		List<String> postLinkList = new ArrayList<>();
		List<String> movieLinkList = new ArrayList<>();
		List<MovieModel> movieList = new ArrayList<>();

		for (Element element : titles) { // -- 3. Elemntes 길이만큼 반복한다.
			String str = element.text();
			titleList.add(str);
		}
		for (Element element : percents) { // -- 3. Elemntes 길이만큼 반복한다.
			String percent1 = element.text();
			percentList.add(percent1);
		}
		for (Element element : postLinks) { // -- 3. Elemntes 길이만큼 반복한다.
			String str = element.attr("src");
			postLinkList.add(str);
		}
		for (Element element : movieLinks) {
			String str = element.attr("href");
			if (str.equals("#")) {
				continue;
			}
			movieLinkList.add(str);
		}
		for (int k = 0; k < percentList.size(); k++) {
			movieModel = new MovieModel();
			movieModel.setTitle(titleList.get(k));
			movieModel.setPercent(percentList.get(k));
			movieModel.setPost(postLinkList.get(k));
			movieModel.setMovieLink(movieLinkList.get(k));
			System.out.println(movieModel.getMovieLink());
			movieList.add(movieModel);
		}
		request.setAttribute("size", movieList.size());
		request.setAttribute("movieList", movieList);

		return "/WEB-INF/view/datachart/dataChart.jsp";
	}
	
	@RequestMapping(value = "dataChartArthouse", method = RequestMethod.GET)
	public String dataChartArthouse(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url1 = "http://www.cgv.co.kr/arthouse/movies.aspx";
		String title = "div.box-contents strong.title";//영화제목 틀
		String percent = "strong.percent span"; //퍼센트 
		String postLink = "span.thumb-image img"; //이미지감싸는 틀
		String movieLink = "div.box-image a"; //이미지랑전체감싸고 a링크
		Document doc = null;
		try {
			doc = Jsoup.connect(url1).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements titles = doc.select(title);
		Elements percents = doc.select(percent);
		Elements postLinks = doc.select(postLink);
		Elements movieLinks = doc.select(movieLink);

		MovieModel movieModel = null;
		List<String> titleList = new ArrayList<>();
		List<String> percentList = new ArrayList<>();
		List<String> postLinkList = new ArrayList<>();
		List<String> movieLinkList = new ArrayList<>();
		List<MovieModel> movieList = new ArrayList<>();

		for (Element element : titles) { // -- 3. Elemntes 길이만큼 반복한다.
			String str = element.text();
			titleList.add(str);
		}
		for (Element element : percents) { // -- 3. Elemntes 길이만큼 반복한다.
			String percent1 = element.text();
			percentList.add(percent1);
		}
		for (Element element : postLinks) { // -- 3. Elemntes 길이만큼 반복한다.
			String str = element.attr("src");
			postLinkList.add(str);
		}
		for (Element element : movieLinks) {
			String str = element.attr("href");
			if (str.equals("#")) {
				continue;
			}
			movieLinkList.add(str);
		}
		for (int k = 0; k < percentList.size(); k++) {
			movieModel = new MovieModel();
			movieModel.setTitle(titleList.get(k));
			movieModel.setPercent(percentList.get(k));
			movieModel.setPost(postLinkList.get(k));
			movieModel.setMovieLink(movieLinkList.get(k));
			System.out.println(movieModel.getMovieLink());
			movieList.add(movieModel);
		}
		request.setAttribute("size", movieList.size());
		request.setAttribute("movieList", movieList);

		return "/WEB-INF/view/datachart/dataChartArthouse.jsp";
	}
	

	@RequestMapping(value = "dataChartSeoulcinema", method = RequestMethod.GET)
	   public String dataChartMegabox(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      String url1 = "http://m.seoulcinema.com/movie/2101_boxoffice_list.php";
	      String title = "div.wrp_holder p.tit span.subject";
	      String percent = "div.wrp_holder ul li dl dd:nth-child(4)";
	      String postLink = "div.wrp_holder ul li a:nth-child(2) div.thumbs ";
	      String movieLink = "div.wrp_holder ul li a:nth-child(2)";

	      Document doc = null;
	      try {
	         doc = Jsoup.connect(url1).get();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      Elements titles = doc.select(title);
	      System.out.println("titles: " + titles);

	      Elements percents = doc.select(percent);
	      System.out.println("percents: " + percents);

	      Elements postLinks = doc.select(postLink);
	      System.out.println("postLinks: " + postLinks);

	      Elements movieLinks = doc.select(movieLink);
	      System.out.println("movieLinks: " + movieLinks);

	      MovieModel movieModel = null;
	      List<String> titleList = new ArrayList<>();
	      List<String> percentList = new ArrayList<>();
	      List<String> postLinkList = new ArrayList<>();
	      List<String> movieLinkList = new ArrayList<>();
	      List<MovieModel> movieList = new ArrayList<>();

	      for (Element element : titles) { // -- 3. Elemntes 길이만큼 반복한다.
	         String str = element.text();
	         titleList.add(str);
	      }
	      for (Element element : percents) { // -- 3. Elemntes 길이만큼 반복한다.
	         String percent1 = element.text();
	         percentList.add(percent1);
	      }
	      for (Element element : postLinks) { // -- 3. Elemntes 길이만큼 반복한다.
	         String str = element.attr("style");
	         postLinkList.add(str);
	      }
	      for (Element element : movieLinks) {
	         String str = element.attr("href");
	         if (str.equals("#")) {
	            continue;
	         }
	         movieLinkList.add(str);
	      }
	      for (int k = 0; k < percentList.size(); k++) {
	         movieModel = new MovieModel();
	         movieModel.setTitle(titleList.get(k));
	         movieModel.setPercent(percentList.get(k));
	         String line = postLinkList.get(k);
	         line = line.substring(line.indexOf('\'') + 1);
	         line = line.substring(0, line.indexOf('\''));
	         line = "http:" + line;
	         movieModel.setPost(line);
	         movieModel.setMovieLink(movieLinkList.get(k));
	         movieList.add(movieModel);
	      }
	      request.setAttribute("size", movieList.size());
	      request.setAttribute("movieList", movieList);

	      return "/WEB-INF/view/datachart/dataChartSeoulcinema.jsp";
	   }

}
