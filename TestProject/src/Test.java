
public class Test {

	public static void main(String[] args) {
		//demo();
		System.out.println("Git is fun!");
	}

	public static void demo() {
		// testing try catch
		try {
			System.out.println("Hello World!");
			int i = 1/0;
			System.out.println("Completed");
		}
		catch(Exception exp) {
			System.out.println("I am inside the catch block");
			System.out.println("Message is: "+exp.getMessage());
			System.out.println("Cause is " +exp.getCause());
			exp.printStackTrace();
		}
		finally {
			System.out.println("I am inside the finally block");
		}
	}
	
}
