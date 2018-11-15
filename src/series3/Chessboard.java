package series3;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * I hope you realise you told us in class how to solve this problem...?
 */
public class Chessboard extends GraphicsProgram {

	// Because the ACM does pixels.
	private static final int SCALING_FACTOR = 10;

	private static final int ROWS    = 8;
	private static final int COLUMNS = 8;

	/**
	 * Draws a rectangle.
	 * @param x	x coordiante of the rect's anchor
	 * @param y	y coordiante of the rect's anchor
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
	 * @param n	the row's number, starts at 1
	 */
	private void drawRow(int x, int y) {
		if (x < COLUMNS) {
			drawRect(x, y);
			drawRow(x+2, y);
		}
	}

	/**
	 * Draw a Chessboard.
	 * Technically this is a recursion setup function
	 */
	private void drawBoard() {
		int y = 0;
		drawBoardRecurr(y);
	}

	/**
	 * You don't need to know about this.
	 * @param y	the current column's number
	 */
	private void drawBoardRecurr(int y) {
		if (y < ROWS) {
			drawRow( (y%2 == 0) ? 1 : 0, y );
			drawBoardRecurr(++y);
		}
	}

	@Override
	public void run() {

		drawBoard();

	}

}
