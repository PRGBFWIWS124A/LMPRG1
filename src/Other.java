
public class Other {

	public static void main(String[] args) {
		int x = 25;
		int y = 4;
		int product = product(x, y);
		System.out.printf("%d * %d = %d%n", x, y, product);
		x = 4;
		x = 2;
		int squaresum = squaresum(x, y);
		System.out.printf("%d^2 + %d^2 = %d%n", x, y, squaresum);
		output("test");
		warning();
	}

	static int product(int x, int y) {
		return x * y;
	}

	static int squaresum(int x, int y) {
		return x * x + y * y;
	}

	static void output(String content) {
		System.out.println(content);
	}

	static void warning() {
		System.out.println("WARNUNG");
	}

	static int max(final int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException();
		}
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

}
