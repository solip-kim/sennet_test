package sennet.com.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sennet.com.domain.User;

public class MyBatisMain {

	public static void main(String[] args) throws Exception{
		// mybatis-config.xml --> InputStream
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		File file = new File("mybatis-config.xml"); // classpath 의 의미와 설정 방법을 알아야 함
	    FileInputStream fileInputStream = new FileInputStream(file);
		
		// SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder ssfBuilder = new SqlSessionFactoryBuilder();
		// SqlSessionFactory 
		SqlSessionFactory ssFactory = ssfBuilder.build(inputStream);
		// SqlSession(내부적으로 Connection, Statement, ResultSet을 가지고있음)
		SqlSession sqlSession = ssFactory.openSession();
		
		// CRUD
		//System.out.println("SqlSession객체: " + sqlSession);
		
		// select 
		User selectOneUser = sqlSession.selectOne("sennet.com.dao.mapper.UserMapper.selectOneUser",1);
		System.out.println("<selectOneUser>result : " + selectOneUser);
		
		List<User> userList = sqlSession.selectList("sennet.com.dao.mapper.UserMapper.selectAllUser");
		System.out.println("<userList>result : " + userList);
		
		
		
		/*List<User> userLists = null;
		UserMapper userList = sqlSession.getMapper(UserMapper.class);
		userLists = userList.selectAllUser();
				//.selectList("sennet.com.dao.mapper.UserMapper.selectAllUser");
		
		System.out.println(userLists);*/
	}

}
