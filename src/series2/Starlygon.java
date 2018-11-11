package series2;

import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * Thing that draws thing… Ducks.
 */
public class Starlygon extends GraphicsProgram {

	public void drawStarlygon() {

		// 
		int n = readInt("number? ");
		int innerRadius = readInt("inner? ");
		int outerRadius = readInt("outer? ");
		boolean largeR = false;

		// Resize factor to make that damn thing visible
		int resizeFactor = 10;

		// If you want to draw lines from duck to duck, you need to remember, where the last duck was!
		// This is initialized with the position of the first duck of the duck-lygon
		GPoint lastDuck = new GPoint(1 * outerRadius + outerRadius, 0 * outerRadius + outerRadius);
		/* Needs more explanation
		 *
		 */

		// Loop yay, note that the loop starts with the second duck cause we already know where the first duck goes!
		for (int i = 1; i <= 2*n; i++) {

			// How far have you gotten round the duck-lygon?
			double currAngle = i * (Math.PI / n); // same as ((2*Math.PI / n) / 2); cause we have 2n points to draw!

			int radius = 0;
			if (largeR) {
				radius = outerRadius;
				largeR = false;
			} else if (!largeR) {
				radius = innerRadius;
				largeR = true;
			}

			// Calculate where the current duck is
			//
			// - sin and cos produce the point on the unit circle,
			//   that corresponds to currAngle
			// - * radius scales the vector to that point from length 1
			//   to either the innerRadius or the outerRadius
			// - + outerRadius moves the point into the visible space,
			//   because the acm can't handle negative coordinates
			double x = Math.cos(currAngle) * radius + outerRadius;
			double y = Math.sin(currAngle) * radius + outerRadius;

			GPoint currDuck = new GPoint(x, y);

			// Draw the line from the last duck to the current duck
			add(new GLine(
					lastDuck.getX() * resizeFactor,
					lastDuck.getY() * resizeFactor,
					currDuck.getX() * resizeFactor,
					currDuck.getY() * resizeFactor
			));

			println(largeR);

			// Make the last duck be the current duck
			lastDuck = currDuck;
		}
	}

	public void run() {
		add(new GLabel("Hoho, I hate both Java and the ACM, and the latter even more than the former!"), 190, 100);

		// you also still need to check, that the rotation is as they want it from the task...

		println("So you want to make a Duck-lygon....");

		// make a duck-lygon
		drawStarlygon();
	}

}
