package series3;

import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * Well, Periods.
 * Let's make Rectangles. Yay.
 */
public class GoldenRatio extends GraphicsProgram {

	private void drawRect(double x, double y, double width, double height) {}

	private void drawGoldenRects(double n) {

		double x;
		double y;
		double width;
		double height;

		drawRect(x, y, width, height);

		drawGoldenRectsRecurr(--n, x, y, width, height);

	private void drawGoldenRectsRecurr(double n, x, y, width, height) {


		drawGoldenRectsRecurr(--n);
	}

	@Override
	public void run() {

		prdoubleln("Honk");

	}

}
