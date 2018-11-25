package series4;


import java.awt.Color;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * This class draws a classical chessboard.
 */
public class MethodicalChessboard extends GraphicsProgram {

	/** The number of cells per row and column. */
	public static final int CELLS_PER_ROWCOL = 8;
	/** Side length of a single board cell. */
	public static final int CELL_SIZE = 52;
	/** Side length of the whole board. */
	public static final int BOARD_SIZE = CELL_SIZE * CELLS_PER_ROWCOL;
	/**
	 * How far the board area (which includes the designators) is away from the
	 * border.
	 */
	public static final int BOARD_OFFSET = 50;
	/** How far each label is away from the board. */
	public static final int DESCRIPTION_OFFSET = 5;
	/** How far the actual playing field is away from the border. */
	public static final int PLAYING_FIELD_OFFSET = BOARD_OFFSET + DESCRIPTION_OFFSET;

	/** Color. **/
	public static final Color COLOR = new Color(0.f, 0.f, 0.f, 0.4f);

	/**
	 * Draws a rectangle.
	 * 
	 * @param x x coordiante of the rect's anchor
	 * @param y y coordiante of the rect's anchor
	 * @param color color for the rect
	 */
	public void drawSquare(int x, int y, Color color) {
		GRect boardPiece = new GRect(PLAYING_FIELD_OFFSET + x * CELL_SIZE,
			PLAYING_FIELD_OFFSET + y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
		boardPiece.setColor(Color.BLACK);
		boardPiece.setFillColor(color);
		boardPiece.setFilled(true);
		add(boardPiece);
	}

	/** Label. 
	 * @param i i.
	 */
	public void drawLabelY(int i) {
		// Calculate the position for the left description.
		GLabel leftNumber = new GLabel("" + (8 - i));
		leftNumber.setLocation(BOARD_OFFSET - leftNumber.getWidth(),
				PLAYING_FIELD_OFFSET + CELL_SIZE * i + CELL_SIZE / 2 + leftNumber.getHeight() / 2);
		add(leftNumber);

		// Calculate the position for the right description.
		GLabel rightNumber = new GLabel("" + (8 - i));
		rightNumber.setLocation(PLAYING_FIELD_OFFSET + BOARD_SIZE + DESCRIPTION_OFFSET,
				PLAYING_FIELD_OFFSET + CELL_SIZE * i + CELL_SIZE / 2 + leftNumber.getHeight() / 2);
		add(rightNumber);
	}

	/** Label. 
	 * @param i j.
	 */
	public void drawLabelX(int i) {
		// Calculate the position for the top description.
		GLabel topLetter = new GLabel("" + (char) ('A' + i));
		topLetter.setLocation(PLAYING_FIELD_OFFSET + CELL_SIZE * i + CELL_SIZE / 2 - topLetter.getWidth() / 2,
				BOARD_OFFSET);
		add(topLetter);

		// Calculate the position for the bottom description.
		GLabel bottomLetter = new GLabel("" + (char) ('A' + i));
		bottomLetter.setLocation(PLAYING_FIELD_OFFSET + CELL_SIZE * i + CELL_SIZE / 2 - topLetter.getWidth() / 2,
				BOARD_OFFSET + BOARD_SIZE + DESCRIPTION_OFFSET + bottomLetter.getHeight());
		add(bottomLetter);
	}


	/**
	 * Draws a specific chess {@code piece} of a {@code player} at the
	 * position of a specific square identified by {@code x} and {@code y}.
	 *
	 * @param x
	 *            file index, between 0 and 7.
	 * @param y
	 *            rank index, between 0 and 7.
	 * @param piece
	 *            0 for a pawn, 1 for a knight, 2 for a bishop, 3 for a
	 *            rook, 4 for a queen, 5 for a king.
	 * @param player
	 *            0 for white, 1 for black.
	 */
	public void drawPiece(int x, int y, int piece, int player) {

		// Oh look, now I'm even using the unicode codes directly and the test still fucks me over.

		// Possible letters
		String[] whites = {"\u2659", "\u2658", "\u2657", "\u2656", "\u2655", "\u2654"}; // Racial undertones, yay
		String[] blacks = {"\u265F", "\u265E", "\u265D", "\u265C", "\u265B", "\u265A"}; // Just to be clear: racism bad.
		// The black pieces are as good as the white pieces, even though the whites always get to start the game!

		// Make a letter
		GLabel letter = new GLabel("");

		// Set the symbol
		if      (player == 0) letter.setLabel(whites[piece]);
		else if (player == 1) letter.setLabel(blacks[piece]);
		else return;

		letter.setFont("SansSerif-44");

		int xCood =   x * CELL_SIZE + PLAYING_FIELD_OFFSET;
		int yCood = ++y * CELL_SIZE + PLAYING_FIELD_OFFSET;

		add(letter, xCood, yCood);
	}

	@Override
	public void run() {
		// Make space for the whole board.
		setSize(PLAYING_FIELD_OFFSET * 2 + BOARD_SIZE, PLAYING_FIELD_OFFSET * 2 + BOARD_SIZE);

		for (int i = 0; i < CELLS_PER_ROWCOL; i++) {
			for (int j = 0; j < CELLS_PER_ROWCOL; j++) {
				// Only draw the dark pieces.
				if ((i + j) % 2 == 1) {
					drawSquare(i, j, COLOR);
				}

			}

			drawLabelY(i);
			drawLabelX(i);
		}

		/* I am wholly aware, I could have automated what follows, but... No. Just no.
		 * If you are adept in Vim, this is done faster, then writing a loop.
		 * And it's easier to understand.
		 * Beat that.
		 */

		// First white row
		drawPiece(0, 7, 3, 0);
		drawPiece(1, 7, 1, 0);
		drawPiece(2, 7, 2, 0);
		drawPiece(3, 7, 4, 0);
		drawPiece(4, 7, 5, 0);
		drawPiece(5, 7, 2, 0);
		drawPiece(6, 7, 1, 0);
		drawPiece(7, 7, 3, 0);

		// Second white row
		drawPiece(0, 6, 0, 0);
		drawPiece(1, 6, 0, 0);
		drawPiece(2, 6, 0, 0);
		drawPiece(3, 6, 0, 0);
		drawPiece(4, 6, 0, 0);
		drawPiece(5, 6, 0, 0);
		drawPiece(6, 6, 0, 0);
		drawPiece(7, 6, 0, 0);

		// First black row
		drawPiece(0, 0, 3, 1);
		drawPiece(1, 0, 1, 1);
		drawPiece(2, 0, 2, 1);
		drawPiece(3, 0, 4, 1);
		drawPiece(4, 0, 5, 1);
		drawPiece(5, 0, 2, 1);
		drawPiece(6, 0, 1, 1);
		drawPiece(7, 0, 3, 1);

		// Second black row
		drawPiece(0, 1, 0, 1);
		drawPiece(1, 1, 0, 1);
		drawPiece(2, 1, 0, 1);
		drawPiece(3, 1, 0, 1);
		drawPiece(4, 1, 0, 1);
		drawPiece(5, 1, 0, 1);
		drawPiece(6, 1, 0, 1);
		drawPiece(7, 1, 0, 1);

	}

}
