package series6;

// package programming.set6.area;

import acm.program.ConsoleProgram;

import java.lang.Math;


/**
 * Approximates an integral.
 */
public class FunctionArea extends ConsoleProgram {
	/**
	 * The function whose area to calculate.
	 *
	 * @param x
	 *            the x coordinate.
	 * @return the value of f at the x coordinate.
	 */
	public double f(double x) {
		// This is the function whose area we want to calculate. Hardcoding
		// it here is a bit unfortunate; we can improve the design once we
		// know more about classes and interfaces
		return Math.sin(x) + Math.cos(0.5 * x);
	}

	/**
	 * Calculates the height of a rectangle at the given x coordinate and with
	 * the given width. The height of the rectangle is the function value at its
	 * left and right side that is nearer to the x axis. If the function value
	 * is negative, the height is negative.
	 *
	 * @param x
	 *            the rectangle's x coordinate (left boundary).
	 * @param width
	 *            the rectangle's width.
	 * @return the rectangle's height, which may actually be negative.
	 */
	public double minRectHeight(double x, double width) {

		// Handle edge cases
		if (width < 0) return 0;
		else if (width == 0) return f(1);

		// Compute height options
		double opt1 = f(x);
		double opt2 = f(x+width);

		// Choose an option
		if (Math.abs(opt1) <= Math.abs(opt2)) return opt1;
		else return opt2;

	}

	/**
	 * Calculates the height of a rectangle at the given x coordinate and with
	 * the given width. The height of the rectangle is the function value at its
	 * left and right side that is further from the x axis. If the function value
	 * is negative, the height is negative.
	 *
	 * @param x
	 *            the rectangle's x coordinate (left boundary).
	 * @param width
	 *            the rectangle's width.
	 * @return the rectangle's height, which may actually be negative.
	 */
	public double maxRectHeight(double x, double width) {

		// Handle edge cases
		if (width < 0) return 0;
		else if (width == 0) return f(1);

		// Compute height options
		double opt1 = f(x);
		double opt2 = f(x+width);

		// Choose an option
		if (Math.abs(opt1) >= Math.abs(opt2)) return opt1;
		else return opt2;

	}

	/**
	 * Approximates the area enclosed by the x axis, {@link #f(double)}, and two
	 * vertical lines at {@code left} and {@code right}. The approximation
	 * divides the x axis section into different parts of width
	 * {@code rectWidth} (the rightmost part may have to be smaller to keep it
	 * from extending beyond the right boundary). For each part, the function
	 * computes the min and max rectangle and uses the min rectangle's area plus
	 * half the difference of the two rectangle areas as the approximate area
	 * for that part.
	 *
	 * @param left
	 *            left boundary.
	 * @param right
	 *            right boundary.
	 * @param rectWidth
	 *            width of the rectangles used to approximate the area.
	 * @return the approximate area. If the left boundary is right of the right
	 *         boundary, the result is 0.
	 */
	public double approxFunctionArea(double left, double right, double rectWidth) {

		// Handle edge cases
		if (left > right) return 0;
		if (rectWidth <= 0) return 0;

		// Init data holders
		double width = rectWidth;
		double area = 0;

		for (double x = left; x <= right; x+=rectWidth) {

			// Handle the case, that there may not be another full step possible
			if (right < x+rectWidth) {

				width = right - x;

			}

			// Compute areas
			double minArea = minRectHeight(x, width) * width;
			double maxArea = maxRectHeight(x, width) * width;

			// Update complete area
			area += minArea + (maxArea - minArea) / 2;

		}

		// Return appoximated area
		return area;

	}

	
	/* Test code below */

	private static final double TERMINATOR = -42;

	@Override
	public void run() {

		double left      = 0;
		double right     = 0;
		double rectWidth = 0;

		println("To terminate execution, enter -42 as the value for 'left'.");

		while (true) {

			left = readDouble("Enter the value for left: ");

			if (left == TERMINATOR) break;

			right = readDouble("Enter the value for right: ");
			rectWidth = readDouble("Enter the value for rectWidth: ");

			FunctionArea josh = new FunctionArea();
			println(josh.approxFunctionArea(left, right, rectWidth));

		}

		println("Over And Out.");

	}


}
