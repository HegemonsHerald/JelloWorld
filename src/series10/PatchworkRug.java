package series10;

// package programming.set10.dude;

import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.Color;

import java.util.ArrayList;
import java.lang.Math;

/** PatchworkRug. */
public class PatchworkRug extends GraphicsProgram {

	/* How to render */

	private static final int SIDES_PX = 100;

	/* Colors for the different tiles */

	private static final Color COLOR_1 = new Color(255, 0, 0);
	private static final Color COLOR_2 = new Color(200, 0, 50);
	private static final Color COLOR_3 = new Color(150, 0, 100);
	private static final Color COLOR_4 = new Color(100, 0, 150);
	private static final Color COLOR_5 = new Color(50, 0, 200);
	private static final Color COLOR_6 = new Color(000, 0, 255);

	/* How to make GCompounds */

	/** Tile1. */
	private class Tile1 extends GCompound {
		/**
		 * Tile1.
		 */
		public Tile1() {
			super();

			Color color = COLOR_1;
			Color color2 = COLOR_2;
			int fractRate = 2;
			double sides = (double) SIDES_PX / fractRate;

			// make the little squares
			for (int x = 0; x < fractRate; x++) {

				for (int y = 0; y < fractRate; y++) {

					GRect square = new GRect(x * sides, y * sides, sides, sides);
					square.setFilled(true);
					square.setFillColor(color);
					square.setColor(color2);

					add(square);

				}

			}
		}
	}

	/** Tile2. */
	private class Tile2 extends GCompound {
		/**
		 * Tile2.
		 */
		public Tile2() {
			super();

			Color color = COLOR_2;
			Color color2 = COLOR_3;
			int fractRate = 3;
			double sides = (double) SIDES_PX / fractRate;

			// make the little squares
			for (int x = 0; x < fractRate; x++) {

				for (int y = 0; y < fractRate; y++) {

					GRect square = new GRect(x * sides, y * sides, sides, sides);
					square.setFilled(true);
					square.setFillColor(color);
					square.setColor(color2);

					add(square);

				}

			}
		}
	}

	/** Tile3. */
	private class Tile3 extends GCompound {
		/**
		 * Tile3.
		 */
		public Tile3() {
			super();

			Color color = COLOR_3;
			Color color2 = COLOR_4;
			int fractRate = 4;
			double sides = (double) SIDES_PX / fractRate;

			// make the little squares
			for (int x = 0; x < fractRate; x++) {

				for (int y = 0; y < fractRate; y++) {

					GRect square = new GRect(x * sides, y * sides, sides, sides);
					square.setFilled(true);
					square.setFillColor(color);
					square.setColor(color2);

					add(square);

				}

			}
		}
	}

	/** Tile4. */
	private class Tile4 extends GCompound {
		/**
		 * Tile4.
		 */
		public Tile4() {
			super();

			Color color = COLOR_4;
			Color color2 = COLOR_3;
			int fractRate = 5;
			double sides = (double) SIDES_PX / fractRate;

			// make the little squares
			for (int x = 0; x < fractRate; x++) {

				for (int y = 0; y < fractRate; y++) {

					GRect square = new GRect(x * sides, y * sides, sides, sides);
					square.setFilled(true);
					square.setFillColor(color);
					square.setColor(color2);

					add(square);

				}

			}
		}
	}

	/** Tile5. */
	private class Tile5 extends GCompound {
		/**
		 * Tile5.
		 */
		public Tile5() {
			super();

			Color color = COLOR_5;
			Color color2 = COLOR_2;
			int fractRate = 6;
			double sides = (double) SIDES_PX / fractRate;

			// make the little squares
			for (int x = 0; x < fractRate; x++) {

				for (int y = 0; y < fractRate; y++) {

					GRect square = new GRect(x * sides, y * sides, sides, sides);
					square.setFilled(true);
					square.setFillColor(color);
					square.setColor(color2);

					add(square);

				}

			}
		}
	}

	/** Tile6. */
	private class Tile6 extends GCompound {
		/**
		 * Tile6.
		 */
		public Tile6() {
			super();

			Color color = COLOR_6;
			Color color2 = COLOR_5;
			int fractRate = 7;
			double sides = (double) SIDES_PX / fractRate;

			// make the little squares
			for (int x = 0; x < fractRate; x++) {

				for (int y = 0; y < fractRate; y++) {

					GRect square = new GRect(x * sides, y * sides, sides, sides);
					square.setFilled(true);
					square.setFillColor(color);
					square.setColor(color2);

					add(square);

				}

			}
		}
	}

	@Override
	public void run() {

		// Get input
		int height = readInt("Enter height: ");
		int width = readInt("Enter width: ");
		// int width = 15;
		// int height = 15;

		// Compute MY coordinate system
		int centerX = width / 2;
		int centerY = height / 2;

		/* Make the tiles happen */

		for (int x = 0; x < width; x++) {

			for (int y = 0; y < height; y++) {

				// The coods of the tile in MY coordinate system
				int coodX = x - centerX;
				int coodY = y - centerY;

				// Which type of tile to use
				int tileSum = Math.abs(coodX) + Math.abs(coodY);
				int tileType = tileSum % 6 + 1;

				// The tileType should always be between 1 and 6
				assert tileType <= 6 && tileType > 0 : "Somehow the modulo operation has stopped working... wut?";

				switch (tileType) {

				case 1:
					add(new Tile1(), x * SIDES_PX, y * SIDES_PX);
					break;
				case 2:
					add(new Tile2(), x * SIDES_PX, y * SIDES_PX);
					break;
				case 3:
					add(new Tile3(), x * SIDES_PX, y * SIDES_PX);
					break;
				case 4:
					add(new Tile4(), x * SIDES_PX, y * SIDES_PX);
					break;
				case 5:
					add(new Tile5(), x * SIDES_PX, y * SIDES_PX);
					break;
				case 6:
					add(new Tile6(), x * SIDES_PX, y * SIDES_PX);
					break;

				}

			}

		}

	}

}
