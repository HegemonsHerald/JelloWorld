package series5;

import java.awt.Color;
import java.lang.Math;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * Draws an almond bread.
 */
public class Mandelbrot extends GraphicsProgram {

	/* Constants */

	private static final Color IN_COLOR  = new Color(100, 100, 100);
	private static final Color OUT_COLOR = new Color(255, 255, 255);

	@Override
	public void run() {

		/* Get Input */
		int squareSize = readInt("How wide should the square's edges be? ");
		int width  = readInt("How many squares should the drawing be wide? ");
		int height = readInt("How many squares should the drawing be tall? ");


		/* Run through the squares */

		// Rows
		for (int i = 0; i < height; i++) {

			// Columns
			for (int j = 0; j < width; j++) {

				// Compute the complex number represented by the current square
				ComplexNumber c = new ComplexNumber(
						(3.d * (double) j) / (double) width - 2,
						(2.d * (double) i) / (double) height - 1
				);


				/* Decide whether Mandelbrot sequence approaches infinity */

				boolean isInSet = true;

				// Element to start with and always the previous element
				ComplexNumber z = new ComplexNumber();

				// Do the next part 400 times
				for (int a = 0; a < 400; a++) {

					// Compute next element in the sequence
					double newReal = Math.pow(z.getReal(), 2) - Math.pow(z.getImaginary(), 2) + c.getReal();
					double newImag = 2 * z.getReal() * z.getImaginary() + c.getImaginary();

					ComplexNumber zNext = new ComplexNumber(newReal, newImag);


					// Check for INIFINITY!
					double checker = Math.pow(zNext.getReal(), 2) + Math.pow(zNext.getImaginary(), 2);

					if (checker > 4) {
						isInSet = false;
						break;
					}

					// Set the new previous element
					z = zNext;

				}

				/* Draw the square */

				GRect square = new GRect(j * squareSize, i * squareSize, squareSize, squareSize);

				// Set color depending on what the result of the infinite series test was
				if (isInSet) square.setColor(IN_COLOR);
				else square.setColor(OUT_COLOR);

				square.setFilled(true);
				add(square);

			}

		}

	}

}
