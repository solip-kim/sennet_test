package sennet.com.dao;

import sennet.com.domain.User;

public class UserDaoMain {

	public static void main(String[] args) {
		
		UserDao userDao = new UserDao();
		
		// insert
		/*System.out.println("---------insertUser---------");
		User createUser1 = new User(345, "박세넷", "서울특별시");
		System.out.println("<insertUser> " + userDao.insertUser(createUser1));*/
		/*System.out.println("---------insertUser---------");
		User createUser2 = new User(654, "김솔잎", "경기도 부천시");
		System.out.println("<insertUser> " + userDao.insertUser(createUser2));*/
		/*System.out.println("---------insertUser---------");
		User createUser3 = new User(123, "김자바", "서울시 구로구");
		System.out.println("<insertUser> " + userDao.insertUser(createUser3));*/
		
		// selectOne
		/*System.out.println("---------selectOneUser---------");
		System.out.println(userDao.selectOneUser(123));*/
		
		// update
		/*System.out.println("---------updateUser---------");
		User updateUser1 = new User();
		updateUser1.setUserId(123);
		updateUser1.setUserAddr("서울시 성동구");
		System.out.println("<updateUser> " + userDao.updateUser(updateUser1));*/
		
		// selectAll
		/*System.out.println("---------selectAllUser---------");
		System.out.println(userDao.selectAllUser());*/
		
		// delete
		/*System.out.println("---------deleteUser---------");
		System.out.println("<deleteUser> " + userDao.deleteUser(121));*/
		
		// selectAll
		
		System.out.println("---------selectAllUser---------");
		System.out.println(userDao.selectAllUser());
		
	}
}
