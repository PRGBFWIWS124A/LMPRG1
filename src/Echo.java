
public class Echo {
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("You need to provide a text");
			return;
		}
		
		System.out.println(args[0]);
	}
}
