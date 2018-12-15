package series7;
import series7.NumberBoard;
// package programming.set7.sudoku;

import java.util.ArrayList;

/**
 * Why oh why are we doing this to ourselves?...
 */
public class Sudoku extends NumberBoard {

	/**
	 * makes a sudoku.
	 */
	public Sudoku() {
		super(9, 9);
	}

	/**
	 * Sets the value of the given cell.
	 *
	 * @param row
	 *            the cell's row, starting at 0.
	 * @param col
	 *            the cell's column, starting at 0.
	 * @param value
	 *            the cell's value. Must be {@code >= 1} and {@code <= 9} or {@link #EMPTY}.
	 */
	public void setValueAt(int row, int col, int value) {
		if ((value >= 1 && value <= 9) || value == EMPTY) {
			super.setValueAt(row, col, value);
		}
	}

	/**
	 * validates an arraylist of values.
	 * the point of this is to pass the values in a row, col or block to this function to validate them.
	 * @param v the list to validate
	 * @return true if the list is valid, false if it isn't
	 */
	private boolean validate(ArrayList<Integer> v) {

		/* 
		 * Basic idea:
		 * If a thing doesn't exist in an ArrayList, indexOf returns -1
		 * If a thing exists, indexOf returns the index of it.
		 * If a thing exists, lastIndexOf returns the index of the last occurrence of it.
		 * If a thing exists once, indexOf and lastIndexOf will return the same index, else they won't.
		 */

		for (int j = 1; j <= 9; j++) {

			int iFirst = v.indexOf(j);
			int iLast  = v.lastIndexOf(j);

			// If the current number is in v...
			if (iFirst != -1) {

				// ... and it's there more than one time, return false
				if (iFirst != iLast) return false;

			}

		}

		// If you got til here, v's valid
		return true;

	}

	/**
	 * check for validity of the board.
	 * @return validity
	 */
	public boolean isValid() {

		/* Check rows */
		for (int i = 0; i < 9; i++) {

			// Make the rows we need for the checker...
			// Sidenote: I thought I could use board directly, when I made this plan...
			// Turns out, I can't simply copy the rows out of it, cause of fucking stupid
			// Encapsulation. This is why OOP sucks.
			ArrayList<Integer> row = new ArrayList<Integer>();

			for (int j = 0; j < 9; j++) {
				row.add(getValueAt(i, j));
			}

			if (!validate(row)) return false;

		}

		/* Check columns */
		for (int i = 0; i < 9; i++) {

			// Active column
			ArrayList<Integer> col = new ArrayList<Integer>();

			// I have to use getValueAt in a fucking subclass... I hate OOP and this is why!
			for (int j = 0; j < 9; j++) {
				col.add(getValueAt(j, i));
			}

			if (!validate(col)) return false;

		}

		/* Check 3x3 blocks */

		// Iterate the blocks in vertical direction
		for (int bv = 0; bv < 3; bv++) {

			// Iterate the blocks in horizontal direction
			for (int bh = 0; bh < 3; bh++) {

				ArrayList<Integer> block = new ArrayList<Integer>();

				// Iterate the rows (vertical) in the current block
				for (int i = 0+bv*3; i < 3+bv*3; i++) {

					// Iterate the cols (horizontal) in the current block
					for (int j = 0+bh*3; j < 3+bh*3; j++) {

						block.add(getValueAt(i, j));

					}

				}

				if (!validate(block)) return false;

			}

		}

		return true;
	}

	@Override
	public String toString() {

		String output = "";

		// Iterate the rows
		for (int i = 0; i < 9; i++) {

			// Iterate the cols
			for (int j = 0; j < 9; j++) {

				// Get the value at the current field
				int v = getValueAt(i, j);

				// If the value's empty, add a space, else add the value
				if (v != EMPTY) output = output + v;
				else output += " ";

				// Add the formatting space
				output += " ";
			}

			output += "\n";
		}
		
		return output;

	}

}
