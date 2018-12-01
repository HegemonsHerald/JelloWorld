package series5;

import java.awt.Color;
import java.lang.Math;

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
import acm.graphics.*;

/** Bake Pie. */
public class PiApproximator extends GraphicsProgram {

	// Variables, YAY
	
	/** How many Points to generate. */
	private static final int RESOLUTION        = 10_000;

	/** Radius of the Circle, from which we approximate. */
	private static final int RADIUS            = 1;

	private static final int SCALING           = 100;
	private static final int RENDER_DIAMETER   = 1;
	private static final Color COLOR_STD       = new Color(0.7f, 0.7f, 0.7f);

	//private static final Color COLOR_IN_CIRCLE = new Color(1.f, 0.f, 1.f);
	// Cause apparently pink is too fancy
	private static final Color COLOR_IN_CIRCLE = new Color(0.f, 0.f, 1.f);

	/**
	 * Randomly generates a new point whose x and y coordinates lie between -1
	 * and 1.
	 *
	 * @return random point.
	 */
	public GPoint randomPoint() {

		// Get the random generator
		RandomGenerator rand = RandomGenerator.getInstance();

		// Generate the coordinates for the next point
		double x = rand.nextDouble(-RADIUS, RADIUS);
		double y = rand.nextDouble(-RADIUS, RADIUS);

		// Make the next point
		GPoint p = new GPoint (x,y);

		// Return it
		return p;
	}

	/**
	 * Checks if the point with the given coordinates is inside the circle with
	 * radius 1 centered at the coordinate system's origin.
	 *
	 * @param unitPoint
	 *            the point to check.
	 * @return {@code true} if the point is inside the circle, {@code false} if
	 *         it's not.
	 */
	public boolean isInCircle(GPoint unitPoint) {

		// Calculate how far the unitPoint is away from 0,0
		// This uses the formula for the length of a vector
		double distanceToCenter = 
			Math.sqrt(
				Math.pow(unitPoint.getX(), 2) + Math.pow(unitPoint.getY(), 2)
			);

		// If the point is further away from center, than the circle's diameter points, it's outside
		if (distanceToCenter > RADIUS) return false;
		else return true;

	}

	@Override
	public void run() {

		// Count the points in the circle
		int pointsInCircle = 0;

		// Draw the bounding box
		add(new GRect(
			0,
			0,
			2 * RADIUS * SCALING,
			2 * RADIUS * SCALING
		));

		// Make points, like lots of 'em
		for (int i=0; i<RESOLUTION; i++) {

			// Make a new random point
			GPoint currPoint = randomPoint();

			// Create the GOval that shall represent the point
			GOval currCirc = new GOval(

					// Get where the point goes and move it into visible space,
					// then move center it on the actual point (cause anchors and acm is meh)
					((currPoint.getX() + RADIUS) * SCALING) - RENDER_DIAMETER / 2,
					((currPoint.getY() + RADIUS) * SCALING) - RENDER_DIAMETER / 2,

					// No good without size
					RENDER_DIAMETER,
					RENDER_DIAMETER
					);

			// If the point's in the circle...
			if (isInCircle(currPoint)) {
				// ... write that down...
				pointsInCircle++;
				// ... and make it colorful...
				currCirc.setColor(COLOR_IN_CIRCLE);

			// ... else make it boring
			} else  currCirc.setColor(COLOR_STD);

			// Show the point
			currCirc.setFilled(true);
			add(currCirc);

		}

		// Approximate Pi using the equation from the task specification
		double approximatelyPi = (double) pointsInCircle / (double) RESOLUTION * 4.d;

		// Output
		println(approximatelyPi);

		// Should print a pie emoji here.

	}

}
