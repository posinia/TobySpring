package ex6._59;

public class Target implements TargetInterface {

	@Override
	public void hello() {}

	@Override
	public void hello(String a) {}

	@Override
	public int plus(int a, int b) { return 0; }

	@Override
	public int minus(int a, int b) throws RuntimeException { return 0; }
	
	public void method() {}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		System.out.println(Target.class.getMethod("minus", int.class, int.class));
		// public int ex6._59.Target.minus(int,int) throws java.lang.RuntimeException
	}

}
