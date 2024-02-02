import java.util.Scanner;

public class IfExamples {
	
	static final Scanner SCANNER = new Scanner(System.in);
	
	public static void main(String[] args) {
//		numberIsPositive();
//		numberIsEven();
//		weekday();
		month();
	}
	
	static void numberIsPositive() {
		System.out.print("Geben Sie eine ganze Zahl ein: ");
		int n = SCANNER.nextInt();
		if (n > 0) {
			System.out.println("Die Zahl ist postiv");
		}
	}
	
	static void numberIsEven() {
		System.out.print("Geben Sie eine ganze Zahl ein: ");
		int n = SCANNER.nextInt();
//		if (n % 2 == 0) {
//			System.out.println("Die Zahl ist gerade");
//		} else {
//			System.out.println("Die Zahl ist ungerade");
//		}
		System.out.println(n % 2 == 0 ? "Die Zahl ist gerade" : "Die Zahl ist ungerade");
	}
	
	static void weekday() {
		System.out.print("Geben Sie eine ganze Zahl zwischen 1 und 7 ein: ");
		int n = SCANNER.nextInt();
		if (n == 1) {
			System.out.println("Montag");
		} else if (n == 2) {
			System.out.println("Dienstag");
		} else if (n == 3) {
			System.out.println("Mittwoch");
		} else if (n == 4) {
			System.out.println("Donnerstag");
		} else if (n == 5) {
			System.out.println("Freitag");
		} else if (n == 6) {
			System.out.println("Samstag");
		} else if (n == 7) {
			System.out.println("Sonntag");
		} else {
			System.out.println("Kein valider Input.");
		}
	}
	
	static void month() {
		System.out.print("Geben Sie eine ganze Zahl zwischen 1 und 12 ein: ");
//		switch(SCANNER.nextInt()) {
//			case 1:
//				System.out.println("Januar");
//				break;
//			case 2:
//				System.out.println("Februar");
//				break;
//			case 3:
//				System.out.println("März");
//				break;
//			case 4:
//				System.out.println("April");
//				break;
//			case 5:
//				System.out.println("Mai");
//				break;
//			case 6:
//				System.out.println("Juni");
//				break;
//			case 7:
//				System.out.println("Juli");
//				break;
//			case 8:
//				System.out.println("August");
//				break;
//			case 9:
//				System.out.println("September");
//				break;
//			case 10:
//				System.out.println("Oktober");
//				break;
//			case 11:
//				System.out.println("November");
//				break;
//			case 12:
//				System.out.println("Dezember");
//				break;
//			default:
//				System.out.println("Kein valider Input.");
//		}
		switch(SCANNER.nextInt()) {
			case 1 -> System.out.println("Januar");
			case 2 -> System.out.println("Februar");
			case 3 -> System.out.println("März");
			case 4 -> System.out.println("April");
			case 5 -> System.out.println("Mai");
			case 6 -> System.out.println("Juni");
			case 7 -> System.out.println("Juli");
			case 8 -> System.out.println("August");
			case 9 -> System.out.println("September");
			case 10 -> System.out.println("Oktober");
			case 11 -> System.out.println("November");
			case 12 -> System.out.println("Dezember");
			default -> System.out.println("Kein valider Input.");
		}
	}
}
