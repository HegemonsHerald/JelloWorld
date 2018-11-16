package series3;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * I hope you realise you told us in class how to solve this problem...?
 */
public class Chessboard_Imperative extends GraphicsProgram {

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

	@Override
	public void run() {

		// Loop over the rows (y-coordinates)
		for (int y = 0; y < 8; y++) {

			// Loop over the columns (x-coordiantes)
			for (int x = 0; x < 8; x++) { // loop the columns

				// Learn whether y and x are even or odd
				int moduloY = y%2;
				int moduloX = x%2;

				// If you are on an even row, draw a rect for all the even x's
				if (moduloY==0 && moduloX==0)
					drawRect(x+1, y); // x+1 offset of chessboards: row 0 starts with a white rect, not a black one

				// If you are on an odd row, draw a rect for all the odd x's
				else if (moduloY!=0 && moduloX!=0)
					drawRect(x-1, y); // x-1 offset of chessboards: row 1 starts with a black rect, not a white one

				// Because even and odd numbers alternate, this will produce a checker pattern
			}
		}
	}

}
