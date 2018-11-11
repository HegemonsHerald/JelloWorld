package series2;

import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * Thing that draws thing… Ducks.
 */
public class Starlygon extends GraphicsProgram {

	// 'Star' is boring.
	// I will call it Starlygon. That's objectively better.

	@Override
	public void run() {

		// Resize factor to make that damn thing visible
		int resizeFactor = 10;

		// hmmmmmm....
		println("So you want to make a Star-lygon....");

		// Get Input
		int n = readInt("Well, then. How many pointy bits? ");
		int outerRadius = readInt("How about an outer radius? ");
		int innerRadius = readInt("And an inner radius, please? ");

		if (innerRadius > outerRadius) {
			println("You do know the Starlygon won't be completely visible, if you enter an outer Radius that's larger than the inner Radius, right?");
			println("Just asking to be sure, I mean, I take it you know what you're doing... Cause whey the ████ else would you be playing with computers, right? Right? ... RIGHT 😅 ?");
		}


		// Now for making the thing

		/* Bit of an explanation
		 *
		 * The Starlygon is drawn using a loop. On each iteration a new point is computed.
		 *
		 * That new point is either innerRadius or outerRadius away from the Starlygon's center,
		 * which is determined by the largeR flag variable. If the last point had outerRadius,
		 * the new point needs to have innerRadius and vice versa, cause the star goes zick-zack.
		 *
		 * A line is then drawn from the last point to the newly made point. To make that possible
		 * I use lastPoint to store the last-ly computed point. This means I get around recomputing
		 * points I already computed, which is always good. It also means I have to initialize
		 * lastPoint with the position of the first point of the Starlygon and start the loop with
		 * computing the second point of the Starlygon.
		 *
		 * The loop goes round 2*n-1 times, in accordance with the task's description and the use
		 * of lastPoint.
		 *
		 */

		// Flag variable to tell you wether to use the large outer radius,
		// or the smaller inner radius
		boolean largeR = false; // largeR as in large Radius

		// Variable to hold the last point, of the drawing
		// Initialized with the first point, so the the GLine can be drawn in the loop
		GPoint lastPoint = new GPoint(1 * outerRadius + outerRadius, 0 * outerRadius + outerRadius);
		// note: this is explained in detail below, where the point-making process is outlined in detail...

		// Loop yay, note that the loop starts with the second point cause we already know where the first point goes!
		// 2n cause we have 2n points to draw
		for (int i = 1; i <= 2*n; i++) {

			// Radius will be used to scale the point from unit circle to Starlygon
			int radius = 0;

			// Check the state of largeR
			if (largeR) {

				// largeR == true? Use the larger radius!
				radius = outerRadius;

				// The next point should use the innerRadius
				largeR = false;

			} else if (!largeR) {

				// largeR == false? Use the smaller radius!
				radius = innerRadius;


				// The next point should use the outerRadius!
				largeR = true;
			}


			// Now let's make a point!

			// How far have you gotten round the Starlygon?
			double currAngle = i * (Math.PI / n); // same as (2*Math.PI / 2n) 

			// Calculate a new point... the current point.
			double x = Math.cos(currAngle) * radius + outerRadius;
			double y = Math.sin(currAngle) * radius + outerRadius;

			GPoint currPoint = new GPoint(x, y);

			/*
			 * First calculate the point's position on the unit circle using cos() or sin() for x and y
			 * respectively.
			 *
			 * The unit circle position is then scaled with radius, to make the point either be innerRadius
			 * or outerRadius away from the Starlygon's center.
			 *
			 * In the end they get outerRadius added onto them, as an offset to make sure all Starlygon
			 * points are in the positive space of the coordinate grid (cause acm don't do negative numbers).
			 * I use outerRadius cause it's the smallest number that would move the Starlygon into visible space,
			 * since a point can maximally be outerRadius far away of the Starlygon's center.
		 	 *
			 * The initial point is computed the same way: since largeR is set to false and takes
			 * effect only on the first point the loop computes, the intial point, which comes before that,
			 * needs to be computed with a largeR set to true.
			 * I then simply declare that the Starlygon starts at x=1 and y=0, which is plugged into
			 * the formula described above to create the coordinates.
			 */

			// Draw the line from the last point to the current duck
			add(new GLine(
					lastPoint.getX() * resizeFactor, // Scale the crap to make it visible, eh!
					lastPoint.getY() * resizeFactor,
					currPoint.getX() * resizeFactor,
					currPoint.getY() * resizeFactor
			));

			// Make the last point be the current point
			lastPoint = currPoint;
		}

	}
}
