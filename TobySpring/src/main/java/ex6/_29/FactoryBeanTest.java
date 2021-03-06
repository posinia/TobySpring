package ex6._29;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration // 설정파일 이름을 지정하지 않으면 클래스이름 + '-context-xml' 이 디폴트로 사용됨 
public class FactoryBeanTest {
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void getMessageFromFactoryBean() {
		Object message = context.getBean("message");
		assertThat(message, is(Message.class));
		assertThat(((Message) message).getText(), is("Factory Bean")); 
	}
	
	@Test
	public void getFactoryBean() {
		Object message = context.getBean("&message"); //'&'를 빈 이름 앞에 붙여주면 팩토리 빈 자체를 돌려줌
		assertThat(message, is(MessageFactoryBean.class));
	}
	
}
