package ex1.testCode;

import java.sql.SQLException;

import ex1.dao.UserDao11;
import ex1.domain.User;
import ex1.factory.DaoFactory14;

/**
 *{@link DaoFactory14} 팩토리를 사용하도록 수정한 UserDaoTest15 
 *{@link UserDaoTest12} 와 비교 
 * @author ejlee
 *
 */
public class UserDaoTest15 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		UserDao11 userDao = new DaoFactory14().userDao();
		
		
		User user = userDao.get("id1");
		System.out.println(user.toString());
	}
}
