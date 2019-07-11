/**
 * ObstacleCourse: A type that represents an obstacle course from which to
 * escape. This does not find the shorted path. Because of this, we must always
 * assume there is only one exit.
 * 
 * @author Lucas Boje
 */
public class ObstacleCourse {

	// Instance variables
	protected char[][] course;
	private int sRow;
	private int sCol;
	private int foundRow;
	private int foundCol;

	// Constants (or you could use 'O' and '.' directly)
	private static final char PART_OF_PATH = 'O';
	private static final char TRIED = '.';

	/**
	 * Initializes the 2d char array course.
	 */
	public ObstacleCourse(int sRow, int sCol, char[][] course) {
		this.sRow = sRow;
		this.sCol = sCol;
		this.course = course;

		// The default values in case there is no exit.
		foundRow = -1;
		foundCol = -1;
	}

	// Returns the start column in the array
	public int getStartColumn() {
		return sCol;
	}

	// Returns the starting row in the array
	public int getStartRow() {
		return sRow;
	}

	// Return the column of the solution
	public int getExitColumn() {
		return foundCol;
	}

	// Return the row of the solution
	public int getExitRow() {
		return foundRow;
	}

	// Returns a string representation of the array
	public String toString() {
		String result = "";
		for (int i = 0; i < course.length; i++) {
			for (int j = 0; j < course[0].length; j++) {
				result += course[i][j];
			}
			result += "\n";
		}
		return result;
	}

	// This method is called by the user to begin the search for the one exit.
	public void findTheExit() {
		findExit(sRow, sCol);
	}

	/**
	 * Finds the exit from the 2-D array. This method also must record the row
	 * and col where the exit was found
	 */
	private boolean findExit(int row, int col) {

		if (!onBorder(row, col)) {
			return findExit(row, ++col);
		}

		if (course[row][col] == ' ') {
			foundRow = row;
			foundCol = col;
			return true;
		}

		// go down!
		if (col == course[0].length - 1) {
			if (isValid(row + 1, col))
				return findExit(row + 1, col);
			else
				return findExit(row, col - 1);
		}

		// go left
		if (row == course.length - 1) {
			if (isValid(row, col - 1))
				return findExit(row, col - 1);
			else
				return findExit(row - 1, col);
		}

		// go up
		if (col == 0) {
			if (isValid(row - 1, col))
				return findExit(row - 1, col);
			else
				return findExit(row, col + 1);
		}

		// go right
		if (row == 0) {
			if (isValid(row, col + 1))
				return findExit(row, col + 1);
			else
				return findExit(row + 1, col);
		}

		// sad news
		return false;
	}

	private boolean onBorder(int row, int col) {
		return (row == 0 || col == 0 || row == course.length - 1
				|| col == course[0].length - 1);
	}

	private boolean isValid(int row, int col) {
		return !(row < 0 || col < 0 || row >= course.length
				|| col >= course[0].length);
	}

}