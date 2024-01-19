
public class Sum {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Please provide two numbers");
			return;
		}
		
		try {
			int sum = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
			System.out.println(String.valueOf(sum));
		} catch(NumberFormatException e) {
			System.err.println("Both arguments must be integers");
		}
	}

}
