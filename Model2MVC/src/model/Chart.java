package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Chart implements Serializable{
	
	
	public Chart(){
		
	}
	
	private int movie_num;
	private int member_num;
	private String filename;
	private String movie_theme;
	private String movie_name;
	private String gender;
	private String movie_url;
	
	public Chart(String gender, int movie_num) {
		this.gender = gender;
		this.movie_num = movie_num;
	}
	
	public String getMovie_url() {
		return movie_url;
	}
	public void setMovie_url(String movie_url) {
		this.movie_url = movie_url;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMovie_theme() {
		return movie_theme;
	}
	public void setMovie_theme(String movie_theme) {
		this.movie_theme = movie_theme;
	}
	public int getMovie_num() {
		return movie_num;
	}
	public void setMovie_num(int movie_num) {
		this.movie_num = movie_num;
	}
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Chart [movie_num=" + movie_num + ", member_num=" + member_num + ", filename=" + filename
				+ ", movie_theme=" + movie_theme + ", movie_name=" + movie_name + ", gender=" + gender + "]";
	}
}
