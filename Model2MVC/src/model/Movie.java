package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Movie implements Serializable {
	private int movie_num;
	private String movie_name;
	private String movie_theme;
	private String filename;
	private String movie_url;
	private List<Schedule> li = new ArrayList<Schedule>();
	
	public int getMovie_num() {
		return movie_num;
	}
	public void setMovie_num(int movie_num) {
		this.movie_num = movie_num;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_theme() {
		return movie_theme;
	}
	public void setMovie_theme(String movie_theme) {
		this.movie_theme = movie_theme;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMovie_url() {
		return movie_url;
	}
	public void setMovie_url(String movie_url) {
		this.movie_url = movie_url;	
	}
	public List<Schedule> getLi() {
		return li;
	}
	public void setLi(List<Schedule> li) {
		this.li = li;
	}
	@Override
	public String toString() {
		return "Movie [movie_num=" + movie_num + ", movie_name=" + movie_name + ", movie_theme=" + movie_theme
				+ ", filename=" + filename + ", movie_url=" + movie_url + ", li=" + li + "]";
	}
	
	
	
	
}
