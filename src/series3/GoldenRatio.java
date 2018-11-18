package series3;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * Well, Periods.
 * Let's make Rectangles. Yay.
 */
public class GoldenRatio extends GraphicsProgram {

	private static final int SCALING_FACTOR  = 10;
	private static final double GOLDEN_RATIO = 1.618;

	/**
	 * Draws a rectangle.
	 * @param x	x coordiante of the rect's anchor
	 * @param y	y coordiante of the rect's anchor
	 * @param width	the rect's width
	 * @param height	the rect's height
	 */
	private void drawRect(double x, double y, double width, double height) {

		GRect rect = new GRect(
				SCALING_FACTOR * x,
				SCALING_FACTOR * y,
				SCALING_FACTOR * width,
				SCALING_FACTOR * height
		);

		rect.setColor(     new Color(0.f, 0.f, 0.f));
		rect.setFillColor( new Color(0.f, 0.f, 0.f, 0.3f));
		rect.setFilled(true);

		add(rect);
	}

	@Override
	public void run() {

		// Get Input and initialize variables and stuff
		double width  = readDouble("How wide should the starting rectanlge be? ");
		double height = width / GOLDEN_RATIO;
		double x      = 0;
		double y      = 0;

		int n = readInt("How many rectangle's do you want? ");

		// Draw the first rectangle
		drawRect(x, y, width, height);

		/* Well. Turns out Java don't do tuple returns.
		 * It don't do anonymous types at all.
		 * In short it don't do anything properly functional.
		 * So my neat recursive version of this thing can't be implemented.
		 * And this imperative version may actually be more understandable,
		 * but I wanted to do the recursive version.
		 * Out of protest I shan't comment this bollocks and
		 * waste more time on it.
		 *
		 * Also, If you look closely at the loop you see I say the first
		 * rectangle has the index 1 and then all the operations come
		 * quite naturally based on division-tests... It's not complicated
		 * at any rate.
		 */

		for (int i=2; i<=n; i++) {
			if (i%2 == 0) {
				width = width - height;
				if (i%4 != 0) { x += height; }
				drawRect(x, y, width, height);
			} else {
				height = height - width;
				if (i%3 == 0) { y += width; }
				drawRect(x, y, width, height);
			}
		}
	}

}
