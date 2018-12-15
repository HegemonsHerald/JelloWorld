package series7;

import series7.Sudoku;

public class SudokuPlay {

	public static void main(String args[]) {

		// Make a sudoku
		Sudoku s1 = new Sudoku();

		// Validate it
		System.out.println(s1.isValid());

		s1.setValueAt(3, 4, 9);

		// Print it
		System.out.println(s1);

	}

}
