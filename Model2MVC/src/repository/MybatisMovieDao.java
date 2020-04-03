package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Movie;
import model.Movie_contents;
import model.Review;
import model.Schedule;
import mybatis.AbstractRepository;

public class MybatisMovieDao extends AbstractRepository {
	private final String namespace = "mybatis.MovieMapper";
	private static MybatisMovieDao instance = new MybatisMovieDao();
	
	private MybatisMovieDao(){}
	
	public static MybatisMovieDao getInstance(){
		return instance;
	}
	
	public void movieInsert(Movie movie) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		int movie_num = 0;
		try {
			statement = namespace + ".getMovieNum";
			movie_num = sqlSession.selectOne(statement);
			movie.setMovie_num(movie_num);
			
			statement = namespace + ".insert";
			sqlSession.insert(statement, movie);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Movie> getMovies2() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getMovies2";
			return sqlSession.selectList(statement);
		}finally{
			sqlSession.close();
		}
	}
	
	public String getMovie_name(int movie_num){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String movieName = null;
		try {
			String statement = namespace + ".getMovieName";
			movieName = sqlSession.selectOne(statement, movie_num);
			return movieName;
		}finally {
			sqlSession.close();
		}
	}
	
	public Movie getMovie(int movie_num){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getMovie";
			return sqlSession.selectOne(statement, movie_num);
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Movie> getNextMovies() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getNextMovies";
			return sqlSession.selectList(statement);
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Movie_contents> getMovieList(int movie_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getMovieList";
			return sqlSession.selectList(statement, movie_num);
		}finally {
			sqlSession.close();
		}
	}
	
	public void insertMovieContents(Movie_contents contents) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		try {
			statement = namespace + ".insertMovieContents";
			sqlSession.insert(statement, contents);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	public void insertReview(Review review) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String statement = namespace + ".insertReview";
			sqlSession.insert(statement, review);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
	public List<Review> getReview(int movie_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getReview";
			return sqlSession.selectList(statement, movie_num);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Schedule> getSchedules(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String statement = namespace + ".getSchedules";
			return sqlSession.selectList(statement);
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Schedule> getScheduleMovieList(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String statement = namespace + ".getScheduleMovieList";
			return sqlSession.selectList(statement);
		}finally{
			sqlSession.close();
		}
	}
}
