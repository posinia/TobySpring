package ex1.dao;

import ex1.db.ConnectionMaker8;

public class AccountDao {
	@SuppressWarnings("unused")
	private ConnectionMaker8 connectionMaker8;
	
	public AccountDao(ConnectionMaker8 connectionMaker8) {
		this.connectionMaker8 = connectionMaker8;
	}
	
	
}
