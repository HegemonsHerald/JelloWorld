package series4;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * I hope you realise you told us in class how to solve this problem...?
 */
public class MethodicalChessboard extends GraphicsProgram {

	// Because the ACM does pixels.
	private static final int SCALING_FACTOR = 100;
	private static final int BOARD_X_OFFSET = 40;
	private static final int BOARD_Y_OFFSET = 40;
	private static final Color GREY_PIECE   = new Color(0.f, 0.f, 0.f, 0.4f);

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

		// Draw 8 labels
		for (int i=0; i<8; i++) {

			// Make a label with the current letter
			GLabel label = new GLabel("" + (char) ('A'+i) );

			// Where exactly do you put it?
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

		// Draw 8 labels
		for (int i=8; i>0; i--) {
			// make a label with the current number
			GLabel label = new GLabel("" + i);

			// Where exactly do you put it?
			// construction analogous to drawLabelsX
			// (8-i) because we draw the numbers in decreasing order, but with increasing coordinates
			double y = (8-i) * SCALING_FACTOR - (label.getHeight() / 2) + startY;
			double x = startX - (label.getWidth() / 2);

			// Draw label
			add(label, x, y);
		}
	}

	/**
	 * Draws a specific chess {@code piece} of a {@code player} at the
	 * position of a specific square identified by {@code x} and {@code y}.
	 *
	 * @param xCood
	 *            file index, between 0 and 7.
	 * @param yCood
	 *            rank index, between 0 and 7.
	 * @param piece
	 *            0 for a pawn, 1 for a knight, 2 for a bishop, 3 for a
	 *            rook, 4 for a queen, 5 for a king.
	 * @param player
	 *            0 for white, 1 for black.
	 */
	public void drawPiece(int xCood, int yCood, int piece, int player) {

		// Possible letters
		char[] whites = {'♙', '♘', '♗', '♖', '♕', '♔'}; // Racial undertones, yay
		char[] blacks = {'♟', '♞', '♝', '♜', '♛', '♚'}; // Just to be clear: racism bad.
		// The black pieces are as good as the white pieces, even though the whites always get to start the game!

		// Make a letter
		GLabel letter;

		// Set the symbol
		if      (player == 0) letter = new GLabel("" + whites[piece]);
		else if (player == 1) letter = new GLabel("" + blacks[piece]);
		else return;

		letter.setFont("SansSerif-109");

		// Set block-level position
		// 7 - coordinate, cause for some reason the board is indexed upside down... damn you chess!
		int x =  (7 - xCood)     * SCALING_FACTOR + BOARD_X_OFFSET;
		int y = ((7 - yCood) +1) * SCALING_FACTOR + BOARD_Y_OFFSET; // yCood + 1 cause of the anchor position of GLabels

		int blockDimension = SCALING_FACTOR; // how wide a chessboard block is

		// Adjust for letter dimensions
		//x += (blockDimension - letter.getWidth())  / 2;
		//y += (blockDimension - letter.getHeight()) / 2;
		// Or maybe no adjusting... cause them f**king tests.		

		add(letter, x, y);

	}

	/**
	 * Draws a rectangle.
	 * @param xCood	x coordiante of the rect's anchor
	 * @param yCood	y coordiante of the rect's anchor
	 * @param color	color for the rect
	 */
	public void drawSquare(int xCood, int yCood, Color color) {

		// Produce values from which to make the rectangles
		int width  = 1 * SCALING_FACTOR;
		int height = 1 * SCALING_FACTOR;

		int x = xCood * SCALING_FACTOR + BOARD_X_OFFSET;
		int y = yCood * SCALING_FACTOR + BOARD_Y_OFFSET;

		// Create the background rectanlge and draw it
		GRect rect = new GRect(x, y, width, height);

		rect.setColor(new Color(0.f, 0.f, 0.f));
		rect.setFillColor(color);
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
		drawSquare(offset + 1, n, GREY_PIECE);	  // odd row: 0+1=1  even row: -1+1=0
		drawSquare(offset + 3, n, GREY_PIECE);	  // odd row: 0+3=3  even row: -1+3=2
		drawSquare(offset + 5, n, GREY_PIECE);	  // ...          5  ...            4
		drawSquare(offset + 7, n, GREY_PIECE);	  // ...          7  ...            6
	}

	/**
	 * Draw a Chessboard.
	 */
	public void drawChessboard() {
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

		drawChessboard();
		drawLabels();

		/* I am wholly aware, I could have automated what follows, but... No. Just no.
		 * If you are adept in Vim, this is done faster, then writing a loop.
		 * And it's easier to understand.
		 * Beat that.
		 */

		// First white row
		drawPiece(0, 0, 3, 0);
		drawPiece(1, 0, 1, 0);
		drawPiece(2, 0, 2, 0);
		drawPiece(3, 0, 5, 0);
		drawPiece(4, 0, 4, 0);
		drawPiece(5, 0, 2, 0);
		drawPiece(6, 0, 1, 0);
		drawPiece(7, 0, 3, 0);

		// Second white row
		drawPiece(0, 1, 0, 0);
		drawPiece(1, 1, 0, 0);
		drawPiece(2, 1, 0, 0);
		drawPiece(3, 1, 0, 0);
		drawPiece(4, 1, 0, 0);
		drawPiece(5, 1, 0, 0);
		drawPiece(6, 1, 0, 0);
		drawPiece(7, 1, 0, 0);

		// First black row
		drawPiece(0, 7, 3, 1);
		drawPiece(1, 7, 1, 1);
		drawPiece(2, 7, 2, 1);
		drawPiece(3, 7, 5, 1);
		drawPiece(4, 7, 4, 1);
		drawPiece(5, 7, 2, 1);
		drawPiece(6, 7, 1, 1);
		drawPiece(7, 7, 3, 1);

		// Second black row
		drawPiece(0, 6, 0, 1);
		drawPiece(1, 6, 0, 1);
		drawPiece(2, 6, 0, 1);
		drawPiece(3, 6, 0, 1);
		drawPiece(4, 6, 0, 1);
		drawPiece(5, 6, 0, 1);
		drawPiece(6, 6, 0, 1);
		drawPiece(7, 6, 0, 1);

	}

}
