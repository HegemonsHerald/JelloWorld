package series3;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * I hope you realise you told us in class how to solve this problem...?
 */
public class Chessboard extends GraphicsProgram {

	// Because the ACM does pixels.
	private static final int SCALING_FACTOR = 100;
	private static final int BOARD_X_OFFSET = 40;
	private static final int BOARD_Y_OFFSET = 40;

	/**
	 * Draw the labels.
	 */
	private void drawLabels() {
		// 50 is half the width of one field in px
		// 800 is the height of the board in px
		// honestly, I just smart-guessed these values
		drawLabelsX(40+50,  30);
		drawLabelsX(40+50,  800+70);
		drawLabelsY(20,     50+50);
		drawLabelsY(800+60, 50+50);
	}

	/**
	 * Draw horizontal labels.
	 * @param startX	where the line of letters starts in X direction
	 * @param startY	where the line of letters starts in Y direction
	 */
	private void drawLabelsX(double startX, double startY) {

		// Values to go from
		String letters[] = {"A", "B", "C", "D", "E", "F", "G", "H"};

		// Draw 8 labels
		for (int i=0; i<8; i++) {
			// Make a label with the current letter
			GLabel label = new GLabel(letters[i]);

			// Where exactly do yo put it?
			// i*SCALING_FACTOR		= position of the field
			// ... + startX			= position offset from borders
			// ... - label.getWidth() / 2	= position of the label, centered
			double x = i * SCALING_FACTOR - (label.getWidth() / 2) + startX;
			double y = startY - (label.getHeight() / 2);

			// Draw label
			add(label, x, y);
		}
	}

	/**
	 * Draw vertical labels.
	 * @param startX	where the line of letters starts in X direction
	 * @param startY	where the line of letters starts in Y direction
	 */
	private void drawLabelsY(double startX, double startY) {

		// Values to pick from
		String letters[] = {"1", "2", "3", "4", "5", "6", "7", "8"}; 

		// Draw 8 labels
		for (int i=0; i<8; i++) {
			// make a label with the current number
			GLabel label = new GLabel(letters[i]);

			// Where exactly do yo put it?
			// construction analogous to drawLabelsX
			double y = i * SCALING_FACTOR - (label.getHeight() / 2) + startY;
			double x = startX - (label.getWidth() / 2);

			// Draw label
			add(label, x, y);
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

		int x = xCood * SCALING_FACTOR + BOARD_X_OFFSET;
		int y = yCood * SCALING_FACTOR + BOARD_Y_OFFSET;

		// Create the background rectanlge and draw it
		GRect rect = new GRect(x, y, width, height);

		rect.setColor(     new Color(0.f, 0.f, 0.f));
		rect.setFillColor( new Color(0.f, 0.f, 0.f, 0.3f));
		rect.setFilled(true);

		add(rect);
	}

	
	// And down here comes the beautiful part of this program:
	// the functionally explicit part.


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
		drawLabels();

	}

}
