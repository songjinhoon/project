package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.Board;
import mybatis.AbstractRepository;

public class MybatisBoardDao extends AbstractRepository{
	private final String namespace = "mybatis.BoardMapper";
	private static MybatisBoardDao instance = new MybatisBoardDao();
	
	private MybatisBoardDao(){}
	
	public static MybatisBoardDao getInstance(){
		return instance;
	}
	
	public int getArticleCount(String boardid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			String statement = namespace + ".getArticleCount";
			return sqlSession.selectOne(statement, boardid);
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Board> getArticles(int startRow, int endRow, String boardid){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
        startRow = startRow - 1;
        endRow = endRow - startRow;
		Map map = new HashMap<>();
		map.put("boardid", boardid);
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		try{
			String statement = namespace + ".getArticles";
			return sqlSession.selectList(statement, map);
		}finally{
			sqlSession.close();
		}
	}
	
	public void insertArticle(Board article){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		Map map = new HashMap<>();
		int board_num = article.getBoard_num();
		int ref = article.getRef(); 
		int re_step = article.getRe_step(); 
		int re_level = article.getRe_level();
		int number = 0;
		try{
			statement = namespace + ".insert_max";
			number = sqlSession.selectOne(statement);
			if(board_num != 0){
				map.put("ref", ref);
				map.put("re_step", re_step);
				statement = namespace + ".insert_update";
				sqlSession.update(statement, map);
				re_step = re_step+1;
                re_level = re_level+1;
			}else{
				ref = number;
				re_step = 0;
				re_level = 0;
			}
            article.setBoard_num(number);
            article.setRef(ref);
            article.setRe_step(re_step);
            article.setRe_level(re_level);
			statement = namespace + ".insert";
			sqlSession.insert(statement, article);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
	
    public Board getArticle(int board_num){
    	SqlSession sqlSession = getSqlSessionFactory().openSession();
    	Board article = new Board();
    	String statement = null;
    	try{
    		statement = namespace + ".content_update";
    		sqlSession.update(statement, board_num);
    		
    		statement = namespace + ".getArticle";
    		article = sqlSession.selectOne(statement, board_num);
    		sqlSession.commit();
    		return article;
    	}finally{
    		sqlSession.close();
    	}
    }
    
    public Board getUpdateArticle(int board_num){
    	SqlSession sqlSession = getSqlSessionFactory().openSession();
    	Board article = new Board();
    	try{
    		String statement = namespace + ".getUpdateArticle";
    		article = sqlSession.selectOne(statement, board_num);
    		return article;
    	}finally{
    		sqlSession.close();
    	}
    }

    public int updateArticle(Board article) throws Exception {
    	SqlSession sqlSession = getSqlSessionFactory().openSession();
    	String statement = null;
    	int board_num = article.getBoard_num();
    	int result = 0;
    	try{
    		statement = namespace + ".getPasswd";
    		String passwd = sqlSession.selectOne(statement, board_num);
    		if(passwd.equals(article.getPasswd())){
    			statement = namespace + ".update";
    			result = sqlSession.update(statement, article);
    			sqlSession.commit();
    		}
    		return result;
    	}finally{
    		sqlSession.close();
    	}
    }
    
    public int deleteArticle(int board_num, String passwd) throws Exception {
    	SqlSession sqlSession = getSqlSessionFactory().openSession();
    	String statement = null;
        String dbpasswd = "";
        int x = -1;
        try{
    		statement = namespace + ".getPasswd";
    		dbpasswd = sqlSession.selectOne(statement, board_num);
    		if(dbpasswd.equals(passwd)){
    			statement = namespace + ".delete";
        		sqlSession.delete(statement, board_num);
        		sqlSession.commit();
        		x = 1;
    		}else{
    			x = 0;
    		}
        }finally{
        	sqlSession.close();
        }
        return x;
     }
}
