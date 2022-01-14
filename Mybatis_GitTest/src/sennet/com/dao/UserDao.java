package sennet.com.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sennet.com.domain.User;


public class UserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public static final String NAMESPACE="sennet.com.dao.mapper.UserMapper.";
	
	public UserDao() {
		
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactoryBuilder ssfBuilder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = ssfBuilder.build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//insert
	public int insertUser(User user) {
		/*
		 * <<sqlSessionFactory.openSession(true)>>
		 * true	:	autocommit ture
		 * 			sqlSession.close() 하면 자동으로 commit
		 * false:	autocommit ture
		 * 			sqlSession.commit()
		 * 			sqlSession.close() commit후 close
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession(true); 
		int insertRowCount = sqlSession.insert(NAMESPACE + "insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	
	//delete
	public int deleteUser(int userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int deleteRowCount = sqlSession.delete(NAMESPACE + "deleteUser", userId);
		sqlSession.close();
		return deleteRowCount;
	}
	
	// update
	public int updateUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/* 1. openSession()
		 * default --> auto commit false
		 * 반드시 commit을 호출해야함
		 * 
		 * 2.openSession(true)
		 * auto commit true
		 * close()시 자동 commit
		 */
		int updateRowCount = sqlSession.update(NAMESPACE + "updateUser", user);
//		sqlSession.commit();
		sqlSession.close();
		return updateRowCount;
	}


	// select
	public User selectOneUser(int userId) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User oneUser = sqlSession.selectOne(NAMESPACE + "selectOneUser",userId);
		sqlSession.commit();
		sqlSession.close();
		return oneUser;
	}
	
	public List<User> selectAllUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> UserList = sqlSession.selectList(NAMESPACE + "selectAllUser");
		sqlSession.close();
		return UserList;
	} 
	
}












