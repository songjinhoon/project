package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;

import model.Board;
import model.Booking;
import mybatis.AbstractRepository;

public class MybatisBookingDao extends AbstractRepository{
	private final String namespace = "mybatis.BookingMapper";
	private static MybatisBookingDao instance = new MybatisBookingDao();
	
	private MybatisBookingDao(){}
	
	public static MybatisBookingDao getInstance(){
		return instance;
	}
	
	public void insertBooking(Booking booking, String mem_id, int schedule_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		Map map = new HashMap<>();
		try {
			statement = namespace + ".getMemNum";
			int mem_num = sqlSession.selectOne(statement, mem_id);
			
			statement = namespace + ".getMovieNum";
			int movie_num = sqlSession.selectOne(statement, schedule_num);
			
			map.put("movie_num", movie_num);
			map.put("mem_num", mem_num);
			map.put("seat", booking.getSeat());
			map.put("schedule_num", schedule_num);
			
			statement = namespace + ".insert";
			sqlSession.insert(statement, map);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	
	
}
