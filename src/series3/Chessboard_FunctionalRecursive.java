package series3;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * I hope you realise you told us in class how to solve this problem...?
 */
public class Chessboard_FunctionalRecursive extends GraphicsProgram {

	// Because the ACM does pixels.
	private static final int SCALING_FACTOR = 100;

	private static final int ROWS    = 8;
	private static final int COLUMNS = 8;

	/**
	 * Draw the Lettering
	 */
	private void drawLettering() {
		drawLetteringX(10, 10); 	// Draw the letters above the board
		drawLetteringX(10, 100);	// Draw the letters below the board
		drawLetteringY(10, 10); 	// Draw the lettering left of the board
		drawLetteringY(100, 10);	// Draw the lettering right of the board
	}

	/**
	 * Draw Lettering in X direction
	 * @param xOffset	how far to offset the row in x direction
	 * @param yOffset	how far to offset the row in y direction
	 */
	private void drawLetteringX(int xOffset, int yOffset) {
		String letters[8] = ["A", "B", "C", "D", "E", "F", "G", "H"];
		for (int i = 0; i < 8; i++) {
			GLabel letter = new GLabel(letters[i]);
			add(letter, x, y);
		}
	}

	/**
	 * Draw Lettering in Y direction
	 * @param xOffset	how far to offset the column in x direction
	 * @param yOffset	how far to offset the row in y direction
	 */
	private void drawLetteringY(int xOffset, int yOffset) {
		String letters[8] = ["1", "2", "3", "4", "5", "6", "7", "8"];
		for (int i = 0; i < 8; i++) {
			GLabel letter = new GLabel(letters[i]);
			add(letter, x, y);
		}
	}

	/**
	 * Draws a rectangle.
	 * @param xCood	x coordiante of the rect's anchor
	 * @param yCood	y coordiante of the rect's anchor
	 */
	private void drawRect(int xCood, int yCood) {

		// Produce values from which to make the rectangles
		int width  = 1 * SCALING_FACTOR;
		int height = 1 * SCALING_FACTOR;

		int x = xCood * SCALING_FACTOR;
		int y = yCood * SCALING_FACTOR;

		// Create the background rectanlge and draw it
		GRect bgRect = new GRect(x, y, width, height);

		bgRect.setColor(new Color(200, 200, 200));
		bgRect.setFilled(true);

		add(bgRect);

		// Create the foreground rectanlge and draw it (for the border)
		GRect fgRect = new GRect(x, y, width, height);

		fgRect.setColor(new Color(0, 0, 0));
		fgRect.setFilled(false);

		add(fgRect);
	}


	/**
	 * Draw a row of the Chessboard.
	 * If the row's number is even, it draws the first rect at position 1,
	 * else at position 0. It creates a checker pattern, if used repeatedly.
	 *
	 * @param width	how wide the rows are (for drawing termination)
	 * @param x	the x coordinate of the to-be-drawn rect
	 * @param y	the row's number, starts at 1 = the y coordinate of the to-be-drawn rect
	 */
	private void drawRow(int width, int x, int y) {

		// As long as you haven't reached the end of the row...
		if (x < width) {

			// ... draw a rectangle at the current position...
			drawRect(x, y);

			// ... and do the same with the next position
			drawRow(width, x+2, y);
		}
	}

	/**
	 * Draw a Chessboard.
	 * Technically this is a recursion setup function
	 *
	 * @param width		how wide the board should be
	 * @param height	how tall the board should be
	 */
	private void drawBoard(int width, int height) {

		// Set up the internal line-counter for drawBoardRecurr
		int y = 0;

		// Call the recurring drawer
		drawBoardRecurr(width, height, y);
	}

	/**
	 * You don't need to know about this.
	 * This function does the actual drawing
	 * @param y	the current column's number
	 */
	private void drawBoardRecurr(int width, int height, int y) {

		// As long as you haven't reached the last row...
		if (y < height) {
			
			// ... draw another row...
			drawRow( width, (y%2 == 0) ? 1 : 0, y );
			// Ternary: If the row is even, start drawing rects at 1, else at 0 → checker pattern

			// ... and repeat that with the next row
			drawBoardRecurr(width, height, ++y);
		}
	}

	@Override
	public void run() {

		// Draw an 8 by 8 chess board
		drawBoard(8, 8);

	}

}
