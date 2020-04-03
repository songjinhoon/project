package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Schedule;
import mybatis.AbstractRepository;

public class MybatisScheduleDao extends AbstractRepository{
	private final String namespace = "mybatis.ScheduleMapper";
	private static MybatisScheduleDao instance = new MybatisScheduleDao();
	
	private MybatisScheduleDao(){}
	
	public static MybatisScheduleDao getInstance(){
		return instance;
	}
	
	public void scheduleInsert(Schedule schedule) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".scheduleInsert";
			sqlSession.insert(statement, schedule);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}

	public List<Schedule> getSchedules() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getSchedules";
			return sqlSession.selectList(statement);
		} finally {
			sqlSession.close();
		}
	}

	public int countSchedule() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int count = 0;
		try {
			String statement = namespace + ".countSchedule";
			count = sqlSession.selectOne(statement);
			return count;
		} finally {
			sqlSession.close();
		}
	}

	public List<Schedule> getSchedule(int movie_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getSchedule";
			return sqlSession.selectList(statement, movie_num);
		}finally {
			sqlSession.close();
		}
	}

	public Schedule formSchedule(int schedule_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".formSchedule";
			return sqlSession.selectOne(statement, schedule_num);
		}finally {
			sqlSession.close();
		}
	}

	public String getMovieName(int movie_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String name = null;
		try {
			String statement = namespace + ".getMovieName";
			name = sqlSession.selectOne(statement, movie_num);
			return name;
		}finally {
			sqlSession.close();
		}
	}
}
