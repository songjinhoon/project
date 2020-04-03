package model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Movie_contents implements Serializable{
	
	private int movie_num;
	private String movie_subject;
	private String movie_content;
	private String movie_actor;
	private int running_time;
	private String url;
	
	public int getMovie_num() {
		return movie_num;
	}
	public void setMovie_num(int movie_num) {
		this.movie_num = movie_num;
	}
	public String getMovie_subject() {
		return movie_subject;
	}
	public void setMovie_subject(String movie_subject) {
		this.movie_subject = movie_subject;
	}
	public String getMovie_content() {
		return movie_content;
	}
	public void setMovie_content(String movie_content) {
		this.movie_content = movie_content;
	}
	public String getMovie_actor() {
		return movie_actor;
	}
	public void setMovie_actor(String movie_actor) {
		this.movie_actor = movie_actor;
	}
	public int getRunning_time() {
		return running_time;
	}
	public void setRunning_time(int running_time) {
		this.running_time = running_time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
