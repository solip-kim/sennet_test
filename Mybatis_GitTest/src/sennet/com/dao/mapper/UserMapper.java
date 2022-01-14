package sennet.com.dao.mapper;

import java.util.List;

import sennet.com.domain.User;


public interface UserMapper {
	/*
	 인터페이스의 풀네임은 StudentMapper.xml의 namespace와 일치
	 메쏘드이름은 StudentMapper.xml 파일의 id와 일치
	 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType과 일치
	 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType과 일치
	 */
	public User selectOneUser(int userId);
	
	public List<User> selectAllUser();

}
