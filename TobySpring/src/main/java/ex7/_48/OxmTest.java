package ex7._48;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ex7._46.jaxb.SqlType;
import ex7._46.jaxb.Sqlmap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class OxmTest {
	@Autowired
	Unmarshaller unmarshaller;
	
	@Test 
	public void unmarshallSqlMap() throws XmlMappingException, IOException  {
		Source xmlSource = new StreamSource(getClass().getResourceAsStream("sqlmap.xml"));
			Sqlmap sqlmap = (Sqlmap)this.unmarshaller.unmarshal(xmlSource);
		
		List<SqlType> sqlList = sqlmap.getSql();
		
		assertThat(sqlList.size(), is(6));
		assertThat(sqlList.get(0).getKey(), is("userAdd"));
	}
}
