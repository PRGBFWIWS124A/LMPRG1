import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Battleship {
	
	static final int SIZE = 10;
	static final String SEPARATOR = "   +-+-+-+-+-+-+-+-+-+-+      +-+-+-+-+-+-+-+-+-+-+";
	static final String ENTER_SHIP_COORDINATE_PROMPT = "Geben Sie die %skoordinaten für ein Schiff der Länge %d ein: ";

	public static void main(String[] args) {
//		Coordinate coo = null;
//		try {
//			coo = toCoordinate("dddd J10");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(coo);
//		System.out.println(toCoordinate("J8"));
		System.out.println(getStartCoordinatePrompt(5));
	}
	
	static int distance(final Coordinate start, final Coordinate end) {
		return Math.abs(start.column() - end.column()) + Math.abs(start.row() - end.row());
	}

	static Coordinate getRandomCoordinate() {
		return new Coordinate(Utility.getRandomInt(SIZE), Utility.getRandomInt(SIZE));
	}
	
	static boolean onOneLine(final Coordinate start, final Coordinate end) {
		return start.column() == end.column() || start.row() == end.row();
	}
	
	static void showSeparatorLine () {
		System.out.println(SEPARATOR);
	}
	
	static int getMaxSurroundingColumn(final Coordinate start, final Coordinate end) {
		return Math.min(Math.max(start.column(), end.column()) + 1, SIZE - 1);
	}
	
	static int getMinSurroundingColumn(final Coordinate start, final Coordinate end) {
		return Math.max(Math.min(start.column(), end.column()) - 1, 0);
	}
	
	static int getMaxSurroundingRow(final Coordinate start, final Coordinate end) {
		return Math.min(Math.max(start.row(), end.row()) + 1, SIZE - 1);
	}
	
	static int getMinSurroundingRow(final Coordinate start, final Coordinate end) {
		return Math.max(Math.min(start.row(), end.row()) - 1, 0);
	}
	
//	static Coordinate toCoordinate(final String input) throws InputMismatchException {
//		Matcher matcher = Pattern.compile("[A-J](10|[1-9])").matcher(input.toUpperCase());
//		
//		if (!matcher.find()) {
//			throw new InputMismatchException("Invalid coordinates, provide one letter (A-J) followed by a number (1-10)");
//		}
//		
//		int letter = matcher.group().charAt(0) - 'A';
//		int number = Integer.parseInt(matcher.group(1));
//		
//		return new Coordinate(letter, number);
//	}
	
	static Coordinate toCoordinate(final String input) {
		int column = input.toUpperCase().charAt(0) - 'A';
		int row = Integer.parseInt(input.substring(1)) - 1;
		
		return new Coordinate(column, row);
	}
	
	static boolean isValidCoordinate(final String input) {
		return input.toUpperCase().matches("[A-J](10|[1-9])");
	}
	
	static String getStartCoordinatePrompt(final int length) {
		return String.format(ENTER_SHIP_COORDINATE_PROMPT, "Start", length);
	}
	
	static String getEndCoordinatePrompt(final int length) {
		return String.format(ENTER_SHIP_COORDINATE_PROMPT, "End", length);
	}
	
}
