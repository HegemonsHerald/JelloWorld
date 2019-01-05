package series8;

// package programming.set8.graph;

import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.Color;

/** Draw a LineGraph. */
public class LineGraph extends GraphicsProgram {

	// How wide the GOvals for the dots should be in px.
	private static final double DOTS_DIAMETER = 10;
	private static final double DOTS_DIAMETER_HALF = DOTS_DIAMETER / 2;

	// A little offset, so we don't cut off anything
	private static final double OFFSET = DOTS_DIAMETER_HALF;

	/**
	 * This maps a data point to the number of pixels from the top edge of the drawing board at which it should be drawn.
	 * By the by, I am completely aware how terribly inefficient this solution here is...
	 *
	 * @param dataPoint	a completely bare data point
	 *
	 * @param minY     	the value that should be represented by the bottom edge of the drawing board
	 *
	 * @param maxY     	the value that should be represented by the top edge of the drawing board
	 *
	 * @return         	the y-coordinate of the px-point where the {@code @dataPoint } should be drawn
	 */
	private double getY(double dataPoint, double minY, double maxY) {

		// I say the data point is in unit space.
		// It needs to mapped to pixel space.


		// So, first: what do I know of unit space?
		// I know its upper and lower boundaries, those are minY and maxY
		// I also know how many points are in the unit space in total:
		double unitSpaceHeight = Math.abs(minY) + Math.abs(maxY);


		// Now, what do I know of pixel space?
		// I know its dimensions
		double pxHeight = getHeight();

		// I also know how many pixels represent one unit in unit space
		double pxPerUnit = pxHeight / unitSpaceHeight;


		// Next I have to compute how many pixels the GOval for the current data point
		// should be offset from the upper end of the drawing area - its y-coordinate.

		// First I map the data point onto a measure with the same scale as the unit
		// space, but that definitely always starts at 0. I call that measure `linear
		// unit space`.
		double linearPoint = dataPoint - minY;

		/*
		 * Say I have a unit space with this interval of valid values:
		 *
		 *   [ -3 , 12 ]
		 *
		 * Now I shift that space by -(-3) and get:
		 *
		 *   [  0 , 15 ]
		 *
		 * The proportions of all values in both sets are the same, but in the new
		 * set the values start at 0, not at -3.
		 *
		 * That's exactly what I do in linearPoint.
		 *
		 * That's useful, cause now I don't have to check, wether my data point is a
		 * positive or a negative number and do some weird if-statement branch bits.
		 *
		 * Notice, how in both sets there are 15 whole numbers, but in the bottom set
		 * 15 is also the largest number? That's where unitSpaceHeight comes in.
		 * After the shift to this linear unit space, unitSpaceHeight is the maximum
		 * value in that linear unit space.
		 */

		// Now let's compute the offset of that linearPoint from the upper end of its
		// linear unit space
		double offset = unitSpaceHeight - linearPoint;

		// Convert that offset to pixel space and you're done
		return offset * pxPerUnit;

	}

	/**
	 * Thing that draws a plot.
	 *
	 * @param name 	label for dataset
	 *
	 * @param color	color for plot
	 *
	 * @param data 	data
	 *
	 * @param minY 	lower bound for the drawing area
	 *
	 * @param maxY 	upper bound for the drawing area
	 */
	public void plotGraph(String name, Color color, double[] data, double minY, double maxY) {

		// figure out, how far apart to put the dots
		double stepSize = getWidth() / (data.length - 1);

		// y position of label and first point
		double firstY = getY(data[0], minY, maxY);

		// draw that label
		GLabel label = new GLabel(name, DOTS_DIAMETER + OFFSET, firstY + DOTS_DIAMETER_HALF);
		label.setColor(color);
		add(label);

		// draw the first dot
		GPoint previousPoint = drawOval(0, firstY, color);

		// draw all the other dots
		for (int i = 1; i < data.length; i++) {

			// draw a new oval
			GPoint newPoint = drawOval(stepSize * i, getY(data[i], minY, maxY), color);

			// draw line from previous oval to this oval
			GLine line = new GLine(
					OFFSET + previousPoint.getX(),
					OFFSET + previousPoint.getY(),
					OFFSET + newPoint.getX(),
					OFFSET + newPoint.getY()
					);
			line.setColor(color);
			add(line);

			// update previous oval
			previousPoint = newPoint;
		}

	}

	/**
	 * Thing that technically also draws the plot, but figures out the bounds on its own.
	 *
	 * @param name 	yup
	 *
	 * @param color	duh
	 *
	 * @param data 	mmmmm
	 */
	public void plotGraph(String name, Color color, double[] data) {

		// Figure out the max and min of the dataset
		double min = min(data);
		double max = max(data);

		// In case all values in the thing are the same...
		if (min == max) {

			max = data[0] + 100;
			min = data[0] - 100;

		}

		plotGraph(name, color, data, min, max);

	}

	/**
	 * Lil' helper to make them ovals easier.
	 *
	 * @param x	x cood
	 *
	 * @param y	y cood
	 *
	 * @param c	color
	 *
	 * @return returns the oval that was created during drawing
	 */
	private GPoint drawOval(double x, double y, Color c) {

		GPoint p = new GPoint(x, y);

		GOval o = new GOval(p.getX(), p.getY(), DOTS_DIAMETER, DOTS_DIAMETER);

		o.setFilled(true);
		o.setColor(c);

		add(o);

		return p;

	}

	/**
	 * Returns the smallest double from the array.
	 *
	 * @param a	the array
	 *
	 * @return 	the smallest double
	 */
	private static double min(double[] a) {

		double minVal = Double.POSITIVE_INFINITY;

		for (double el : a) {

			if (el < minVal) minVal = el;

		}

		return minVal;

	}

	/**
	 * Returns the largest double from the array.
	 *
	 * @param a	the array
	 *
	 * @return 	the largest double
	 */
	private static double max(double[] a) {

		double maxVal = Double.NEGATIVE_INFINITY;

		for (double el : a) {

			if (el > maxVal) maxVal = el;

		}

		return maxVal;

	}

	@Override
	public void run() {

		// Set that window size!
		setSize(600, 300);
		validate();

		GRect rect = new GRect(OFFSET, OFFSET, 600, 300);
		add(rect);

		// some test data
		double data1[] = { 42, 34, 98, -18, 12 };
		double data2[] = { 19, 19, -10, 19 };
		double data3[] = { 19, 19, 19,  19, 19 };

		plotGraph("test data 1", Color.BLUE, data1);
		plotGraph("test data 2", Color.RED, data2);
		plotGraph("test data 3", Color.GREEN, data3);

	}

}
