package ex5._46;

import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import ex5._26.Level;
import ex5._26.User;
import ex5._26.UserDao;

public class UserService {
	
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMEND_FOR_GOLD = 30;
	
	private PlatformTransactionManager transactionManager;
	
	UserDao userDao;
	
	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	//프토퍼티 이름은 관례를 따라 transactionManager라고 만드는 것이 편리
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}




	public void upgradeLevels(){
		//DI받은 트랜잭션 매니저를 공유해서 사용한다. 멀티스레드 환경에서도 안전하다.
		TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try{
			//트랜잭션 안에서 진행되는 작업 
			List<User> users = userDao.getAll();
			for(User user: users){
				if(canUpgradeLevel(user)){
					upgradeLevel(user);
				}
			}
			this.transactionManager.commit(status);//트랜잭션 커밋
		}catch(RuntimeException e){//예외가 발생하면 롤백한다.
			System.out.println("예외 발생 roll back ");
			this.transactionManager.rollback(status);//트랜잭션 커밋
			throw e;
		}

	}
	
	protected void upgradeLevel(User user) {
		user.upgradeLevel();
		userDao.update(user);
	}

	private boolean canUpgradeLevel(User user) {
		Level currentLevel = user.getLevel();
		switch(currentLevel){
			case BASIC: return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
			case SILVER: return (user.getRecommend() >= MIN_RECCOMEND_FOR_GOLD);
			case GOLD: return false;
			default: throw new IllegalArgumentException("Unknown level: "+ currentLevel);
		}
	}
	
	public void add(User user) {
		if(user.getLevel() == null) user.setLevel(Level.BASIC);
		userDao.add(user);
		
	}
}
