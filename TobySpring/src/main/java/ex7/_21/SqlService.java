package ex7._21;

public interface SqlService {
	String getSql(String key) throws SqlRetrievalFailureException;
}
