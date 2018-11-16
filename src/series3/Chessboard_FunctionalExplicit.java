package series3;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * I hope you realise you told us in class how to solve this problem...?
 */
public class Chessboard_FunctionalExplicit extends GraphicsProgram {

	// Because the ACM does pixels.
	private static final int SCALING_FACTOR = 100;

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
	private void drawRow(int n) {
		int offset = (n%2 == 0) ? 0 : -1; // If the row's number is even, use 0 as offset, else use -1
		drawRect(offset + 1, n);	  // odd row: 0+1=1  even row: -1+1=0
		drawRect(offset + 3, n);	  // odd row: 0+3=3  even row: -1+3=2
		drawRect(offset + 5, n);	  // ...          5  ...            4
		drawRect(offset + 7, n);	  // ...          7  ...            6
	}

	/**
	 * Draw a Chessboard.
	 */
	private void drawBoard() {
		drawRow(0);
		drawRow(1);
		drawRow(2);
		drawRow(3);
		drawRow(4);
		drawRow(5);
		drawRow(6);
		drawRow(7);
	}

	@Override
	public void run() {

		drawBoard();

	}

}
