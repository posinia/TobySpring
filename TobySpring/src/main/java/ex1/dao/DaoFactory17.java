package ex1.dao;

/**
 * {@link DaoFactory16 } 생성 오브젝트 코드 수정
 * @author ejlee
 *
 */
public class DaoFactory17 {
	public UserDao11 userDao(){
		UserDao11 userDao = new UserDao11(getConnectionMaker());
		return userDao;
	}
	
	public AccountDao accountDao(){
		AccountDao accountDao = new AccountDao(getConnectionMaker());
		return accountDao;
	}
	
	public MessageDao messageDao(){
		MessageDao messageDao = new MessageDao(getConnectionMaker());
		return messageDao;
	}
	
	public ConnectionMaker8 getConnectionMaker(){
		return new DConnctionMaker9();
	}
}
