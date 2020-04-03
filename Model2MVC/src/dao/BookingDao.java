package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Board;
import model.Booking;
import model.Movie;
import model.Schedule;

public class BookingDao {

	private BookingDao() {
	}

	private static BookingDao instance = new BookingDao();

	public static BookingDao getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Connection conn = null;
		String jdbcUrl = "jdbc:mysql://localhost:3306/teamprj?"
				+ "useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String dbID = "scott";
		String dbPass = "1111";
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(jdbcUrl, dbID, dbPass);
		return conn;
	}

	 

	public void insertBooking(Booking booking, String mem_id, int schedule_num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int mem_num = 0;
		int movie_num = 0;

		try {
			conn = getConnection();

			String sql = "select mem_num from member1 where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mem_num = rs.getInt(1);
			}

			sql = "select movie_num from schedule where schedule_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, schedule_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				movie_num = rs.getInt(1);
			}

			// movie_num | mem_num | seat | schedule_num |
			sql = "insert into booking (movie_num, mem_num, seat, schedule_num) values(?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movie_num);
			pstmt.setInt(2, mem_num);
			pstmt.setString(3, booking.getSeat());
			pstmt.setInt(4, schedule_num);

			pstmt.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

	// 예약 조회
	public Map<String, List<Schedule>> getBooking(String mem_id) throws Exception {
		Map<String, List<Schedule>> bookingList1 = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int mem_num = 0;

		try {
			conn = getConnection();

			String sql = "select mem_num from member1 where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mem_num = rs.getInt(1);
			}
			System.out.println(mem_num);

			sql = "select b.booking_num,m.movie_name, s.movie_date, s.loc_num, b.seat from booking b, movie m,  schedule s "
					+ "  where m.movie_num = s.movie_num and s.schedule_num= b.schedule_num and b.mem_num=? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// | movie_name | movie_date | loc_num | seat |
				bookingList1 = new HashMap<String, List<Schedule>>();

				do {
					Schedule schedule = new Schedule();

					schedule.setMovie_name(rs.getString("movie_name"));
					schedule.setMovie_date(rs.getDate("movie_date"));
					schedule.setLoc_num(rs.getInt("loc_num"));
					schedule.setSeat(rs.getString("seat"));
					schedule.setBooking_num(rs.getInt("booking_num"));
					String key = schedule.getMovie_name() + " " + schedule.getMovie_date() + " "
							+ schedule.getLoc_num();
					if (bookingList1.containsKey(key)) {
						List<Schedule> scli = bookingList1.get(key);
						scli.add(schedule);

					} else {

						List<Schedule> scli = new ArrayList<Schedule>();
						bookingList1.put(key, scli);
						scli.add(schedule);
					}

				} while (rs.next());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return bookingList1;
	}
	
	public void deleteBooking(int booking_num) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql="";
        try{
           conn = getConnection();
           sql = "delete from BOOKING where booking_num=?";
           pstmt = conn.prepareStatement(sql);
           pstmt.setInt(1, booking_num);
           pstmt.executeUpdate();
           
              
        }catch(Exception ex){
           ex.printStackTrace();
        }finally{
           if(pstmt != null)
              try{
                 pstmt.close();
              }catch(SQLException ex){}
           
           if(conn != null)
              try{
                 conn.close();
              }catch(SQLException ex){}
           
        }
	}
	
	public String getCheckedSeats(int schedule_num){
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      Board article = new Board();
	      String seats= "";
	      
	      try{
	         conn = getConnection();
	         
	            String sql = " select seat from booking where schedule_num = ? ";
	            
	            pstmt = conn.prepareStatement(sql); 
	            pstmt.setInt(1, schedule_num);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()){
	            
	        	 do {
	        		 seats += rs.getString(1)+",";
	        	 }while (rs.next());
	               
	         }
	         
	      }catch(Exception ex){
	         ex.printStackTrace();
	      }finally{
	         if(pstmt != null)
	            try{
	               pstmt.close();
	            }catch(SQLException ex) {}
	         
	         if(conn != null)
	            try{
	               conn.close();
	            }catch(SQLException ex) {}
	      }
	      
	      return seats;
	   }
}
