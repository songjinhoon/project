package model;

import java.io.Serializable;
import java.sql.Date;


@SuppressWarnings("serial")
public class Schedule implements Serializable{

	private int movie_num;
	private int loc_num;
	private Date movie_date;
	private int movie_price;
	private int schedule_num;
	private String movie_name;
	private String seat;
	private int booking_num;
	
	
	public int getBooking_num() {
		return booking_num;
	}
	public void setBooking_num(int booking_num) {
		this.booking_num = booking_num;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getSchedule_num() {
		return schedule_num;
	}
	public void setSchedule_num(int schedule_num) {
		this.schedule_num = schedule_num;
	}
	public int getMovie_num() {
		return movie_num;
	}
	public void setMovie_num(int movie_num) {
		this.movie_num = movie_num;
	}
	public int getLoc_num() {
		return loc_num;
	}
	public void setLoc_num(int loc_num) {
		this.loc_num = loc_num;
	}
	public java.sql.Date getMovie_date() {
		return movie_date;
	}
	public void setMovie_date(Date movie_date) {
		this.movie_date = movie_date;
	}
	public int getMovie_price() {
		return movie_price;
	}
	public void setMovie_price(int movie_price) {
		this.movie_price = movie_price;
	}
	@Override
	public String toString() {
		return "Schedule [movie_num=" + movie_num + ", loc_num=" + loc_num + ", movie_date=" + movie_date
				+ ", movie_price=" + movie_price + ", schedule_num=" + schedule_num + ", movie_name=" + movie_name
				+ ", seat=" + seat + ", booking_num=" + booking_num + "]";
	}
	
}
