package series6;

import java.lang.Math;

/**
 * Cause I don't like the task we were given
 */
public class IntegrationBetter {

	private static final double INTERVAL_LOWER = -1.0;
	private static final double INTERVAL_UPPER = 0.0;
	private static final double STEP_SIZE = 0.2;

	/** The function f.
	 * @param x	the parameter, the function operates on.
	 * @return	return value.
	 */
	private static double f(double x) {

		return Math.sin(x) + Math.cos(0.5 * x);

	}

	/** The main function.
	 * @param args[]	the program's command line args
	 */
	public static void main(String args[]) {

		/* Hoisting */
		double firstValue  = f(INTERVAL_LOWER);
		double secondValue = 0;

		double underRect = STEP_SIZE * firstValue;
		double overRect  = 0;
		double average = 0;

		double area = 0;

		/* Compute Integral */
		double x = INTERVAL_LOWER;
		while (x <= INTERVAL_UPPER) {

			secondValue = f(x+STEP_SIZE);

			overRect  = STEP_SIZE * secondValue;

			average = underRect + (overRect - underRect) / 2;

			System.out.print(x + "	" + underRect + "	" + overRect + "	");

			area += average;
			System.out.println(average + "	" + area);

			underRect = overRect;
			firstValue = secondValue;

			if ((x+STEP_SIZE) > INTERVAL_UPPER) {

				double remainingStep = INTERVAL_UPPER - x;
				overRect  = remainingStep * f(INTERVAL_UPPER);
				underRect = secondValue * remainingStep;
				average = underRect + (overRect - underRect) / 2;
				area += average;

				System.out.println(remainingStep + "	" + overRect + "	" + underRect);

			}

			x+=STEP_SIZE;

		}

		/* Output */
		System.out.println("The area for the interval -x: "+INTERVAL_LOWER+", +x: "+INTERVAL_UPPER+" with the stepsize: "+STEP_SIZE+" is:");
		System.out.println(area);

	}

}

