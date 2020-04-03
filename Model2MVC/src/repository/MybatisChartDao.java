package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Chart;
import mybatis.AbstractRepository;

public class MybatisChartDao extends AbstractRepository{
	private final String namespace = "mybatis.ChartMapper";
	private static MybatisChartDao instance = new MybatisChartDao();
	
	private MybatisChartDao(){}
	
	public static MybatisChartDao getInstance(){
		return instance;
	}
	
	public List<Chart> getList(int startRow, int endRow) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Map map = new HashMap<>();
		startRow = startRow-1;
		endRow = endRow-startRow;
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		try {
			String statement = namespace + ".getList";
			return sqlSession.selectList(statement, map);
		}finally{
			sqlSession.close();
		}
	}
	
	public int selectCount() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int count=0;
		try {
			String statement = namespace + ".selectCount";
			count = sqlSession.selectOne(statement);
			return count;
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Chart> getName() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".getName";
			return sqlSession.selectList(statement);			
		} finally {
			sqlSession.close();
		}
	}
}
