import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
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
		showRowNumber(5);
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

	//	static void showRowNumber(final int row) {
	//		int rowNumber = row + 1;
	//		if (rowNumber < 10) {
	//			System.out.print(" ");
	//		}
	//		System.out.print(rowNumber);
	//	}

	static void showRowNumber(final int row) {
		System.out.printf("% 2d", row + 1);
	}

	static void showField(final Field field, final boolean showShips) {

		switch (field) {
		case SHIP:
			System.out.print(showShips == true ? "O" : " ");
			break;
		case FREE:
			System.out.print(" ");
			break;
		case WATER_HIT:
			System.out.print("X");
			break;
		case SHIP_HIT:
			System.out.print("*");
			break;
		}
	}

	// erster Index -> Zeile, zweiter Index -> Spalte
	static void showRow(final int row, final Field[][] ownField, final Field[][] otherField) {
		showRowNumber(row);
		System.out.print(" |");
		for (Field currentField : ownField[0]) {
			showField(currentField, true);
			System.out.print("|");
		}
		System.out.print("   ");
		showRowNumber(row);
		System.out.print(" |");
		for (Field currentField : otherField[0]) {
			showField(currentField, false);
			System.out.println();
		}
	}

	static void showFields(final Field[][] ownField, final Field[][] otherField) {
		System.out.println("    A B C D E F G H I J        A B C D E F G H I J");
		showSeparatorLine();
		for (int i = 0; i < SIZE; i++) {
			showRow(i, ownField, otherField);
			showSeparatorLine();
		}
		System.out.println();
	}

	static boolean shipSunk(final Coordinate shot, final Field[][] field) {
		for (int i = 1; i < 5; i++) {
			if (shot.column() + 1 < SIZE) {
				break;
			}
			Field currentField = field[shot.row()][shot.column() + i];
			if (currentField == Field.SHIP) {
				return false;
			} else if (currentField == Field.WATER_HIT || currentField == Field.FREE) {
				break;
			}
		}
		for (int i = 1; i < 5; i++) {
			if (shot.column() - 1 > 0) {
				break;
			}
			Field currentField = field[shot.row()][shot.column() - i];
			if (currentField == Field.SHIP) {
				return false;
			} else if (currentField == Field.WATER_HIT || currentField == Field.FREE) {
				break;
			}
		}
		for (int i = 1; i < 5; i++) {
			if (shot.row() + 1 < SIZE) {
				break;
			}
			Field currentField = field[shot.row() + 1][shot.column()];
			if (currentField == Field.SHIP) {
				return false;
			} else if (currentField == Field.WATER_HIT || currentField == Field.FREE) {
				break;
			}
		}
		for (int i = 1; i < 5; i++) {
			if (shot.row() - 1 > 0) {
				break;
			}
			Field currentField = field[shot.row() - 1][shot.column()];
			if (currentField == Field.SHIP) {
				return false;
			} else if (currentField == Field.WATER_HIT || currentField == Field.FREE) {
				break;
			}
		}

		return true;
	}

	static int countHits(final Field[][] field) {
		int count = 0;
		for (Field[] row : field) {
			for (Field currentField : row) {
				if (currentField == Field.SHIP_HIT) {
					count++;
				}
			}
		}
		return count;
	}

	static void setAllFree(final Field[][] field) {
		for (int row = 0; row < SIZE; row++) {
			for (int column = 0; column < SIZE; column++) {
				field[row][column] = Field.FREE;
			}
		}
	}

	static void fillWaterHits(final Coordinate shot, final Field [] [] field) {
		int row = shot.row();
		int column = shot.column();
		while(row > 0 && field[row][column] == Field.SHIP_HIT) {
			row--;
		}
		int minRow = row;
		row = shot.row();
		while(row < SIZE - 1 && field[row][column] == Field.SHIP_HIT) {
			row++;
		}
		int maxRow = row;
		row = shot.row();
		while(column < SIZE - 1 && field[row][column] == Field.SHIP_HIT) {
			column++;
		}
		int maxColumn = column;
		column = shot.column();
		while(column > 0 && field[row][column] ==  Field.SHIP_HIT) {
			column--;
		}
		int minColumn = column;
		for(row = minRow; row <= maxRow; row++) {
			for(column = minColumn; column <= maxColumn; column++){
				if (field[row][column] == Field.FREE) {
					field[row][column] = Field.WATER_HIT;
				}
			}
		}
	}

	static boolean noConflict(final Coordinate start, final Coordinate end, Field[][] field) {
		int minRow = getMinSurroundingRow(start, end);
		int maxRow = getMaxSurroundingRow(start, end);
		int minColumn = getMinSurroundingColumn(start, end);
		int maxColumn = getMaxSurroundingColumn(start, end);

		for(int row = minRow; row <= maxRow; row++) {
			for(int column = minColumn; column <= maxColumn; column++) {
				if (field[row][column] == Field.SHIP) {
					return false;
				}
			}
		}

		return true;
	}
}
