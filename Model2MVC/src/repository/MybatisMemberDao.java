package repository;

import org.apache.ibatis.session.SqlSession;

import model.Member;
import mybatis.AbstractRepository;

public class MybatisMemberDao extends AbstractRepository{
	private final String namespace = "mybatis.MemberMapper";
	private static MybatisMemberDao instance = new MybatisMemberDao();
	
	private MybatisMemberDao(){}
	
	public static MybatisMemberDao getInstance(){
		return instance;
	}
	
	public void insertMember(Member member){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		int mem_num = 0;
		try{
			statement = namespace + ".getMemberNumber";
			mem_num = sqlSession.selectOne(statement);
			member.setMem_num(mem_num);
			
			statement = namespace + ".insertMember";
			sqlSession.insert(statement, member);
			sqlSession.commit();
		}finally{
			sqlSession.close();
		}
	}
	
	public int userCheck(String mem_id, String mem_passwd) throws Exception{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		String dbpasswd = "";
		int x = -1;
		try{
			statement = namespace + ".getMemberPasswd";
			dbpasswd = sqlSession.selectOne(statement, mem_id);
			if(dbpasswd.equals(mem_passwd)){
				x = 1;
			}else{
				x = 0;
			}
		}finally{
			sqlSession.close();
		}
		return x;
	}
	
	public Member getMember(String mem_id){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Member member = new Member();
		try{
			String statement = namespace + ".getMember";
			member = sqlSession.selectOne(statement, mem_id);
			return member;
		}finally{
			sqlSession.close();
		}
	}
	
	public int updateMember(String mem_id, String mem_name, String mem_cell, String mem_passwd){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int x = -1;
		Member member = new Member();
		member.setMem_id(mem_id);
		member.setMem_name(mem_name);
		member.setMem_cell(mem_cell);
		member.setMem_passwd(mem_passwd);
		try{
			String statement = namespace + ".updateMember";
			x = sqlSession.update(statement, member);
			sqlSession.commit();
			return x;
		}finally{
			sqlSession.close();
		}
	}
	
	public int deleteMember(String mem_id, String mem_passwd) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = null;
		String dbpasswd = "";
		int x = -2;
		try {
			statement = namespace + ".getMemberPasswd";
			dbpasswd = sqlSession.selectOne(statement, mem_id);
			if(dbpasswd.equals(mem_passwd)){
				statement = namespace + ".delete";
				sqlSession.delete(statement, mem_id);
				sqlSession.commit();
				x = -1;
			}else{
				x = 0;
			}
			return x;
		}finally{
			sqlSession.close();
		}
	}
}
