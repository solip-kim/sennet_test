package sennet.com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sennet.com.dao.mapper.UserMapper;
import sennet.com.domain.User;


public class StudentMapperProxy implements UserMapper  {
	
	private SqlSession sqlSession;
	
	@Override
	public User selectOneUser(int userId) {
		// TODO Auto-generated method stub
		String namespace = UserMapper.class.getName();
		User selectOneUser = sqlSession.selectOne(namespace + "selectOneUser", userId);
		sqlSession.commit();
		sqlSession.close();
		
		return selectOneUser;
	}
	
	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		String namespace = UserMapper.class.getName();
		List<User> userList = sqlSession.selectList(namespace + "selectAllUser");
		sqlSession.close();
		return userList;
	}
	
}
