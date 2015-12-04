package ex1.dao;

/**
 * {@link UserDao11}의 생성 책임을 맡은 팩토리 클래스
 * {@link UserDaoTest12} 와 비교 
 * @author ejlee
 *
 */
public class DaoFactory14 {
	
	public UserDao11 userDao(){
		ConnectionMaker8 connectionMaker8 = new DConnctionMaker9();
		
		UserDao11 userDao = new UserDao11(connectionMaker8);
		return userDao;
	}
}
