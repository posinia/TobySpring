package ex5._13;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ex5._3.Level;
import ex5._3.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/ex5/_13/applicationContext.xml")
public class UserDaoTest {
	
	@Autowired
	UserDao dao;
	
	User user1;
	User user2;
	User user3;
	
	@Before
	public void setUp() {
		this.user1 = new User("gyumee", "박성철", "springno1", Level.BASIC, 1, 0);
		this.user2 = new User("leegw700", "이길원", "springno1", Level.SILVER, 55, 10);
		this.user3 = new User("bumjin", "박범진", "springno3", Level.GOLD, 100, 40);
	}
	
	
	@Test
	public void addAndGet() {

		
		dao.deleteAll();
		
		
		dao.add(this.user1);
		User userget1 = dao.get(user1.getId());
		checkSameUser(userget1, user1);
		
		
		dao.add(this.user2);
		User userget2 = dao.get(user2.getId());
		checkSameUser(userget2, user2);
		
		
	}
	
	@Test
	public void update() {
		dao.deleteAll();
		
		dao.add(user1); //수정할 사용자
		dao.add(user2); //수정하지 않을 사용자
		
		user1.setName("오민규");
		user1.setPassword("springno6");
		user1.setLevel(Level.GOLD);
		user1.setLogin(1000);
		user1.setRecommend(999);
		
		
		dao.update(user1);
		
		User user1update = dao.get(user1.getId());
		checkSameUser(user1, user1update);
		
		User user2same = dao.get(user2.getId());
		checkSameUser(user2, user2same);
	}


	private void checkSameUser(User user1, User user2) {
		assertThat(user1.getId(), is(user2.getId()));
		assertThat(user1.getName(), is(user2.getName()));
		assertThat(user1.getPassword(), is(user2.getPassword()));
		assertThat(user1.getLevel(), is(user2.getLevel()));
		assertThat(user1.getLogin(), is(user2.getLogin()));
		assertThat(user1.getRecommend(), is(user2.getRecommend()));
		
	}
}
