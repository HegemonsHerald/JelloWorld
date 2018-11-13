package series3;

import acm.program.ConsoleProgram;

/**
 * I mean, it really is kinda obvious to everyone involved in these shenanigans, what this class does! Oh, and: .
 */
public class DigitalRoot extends ConsoleProgram {

	// Sidenote: extracting crossSum from digitalRoot is pretty pointless in the scope of this task,
	// but it makes both functions more readable.

	/**
	 * A calculator for a sum that's been in the oven for just the right amount. Or it's potentially annoyed. IDK.
	 *
	 * @param number	compute the cross sum of this
	 * @return		return the cross sum of number... duh.
	 */
	private int crossSum(int number) {

		// Let's start at 0, I'll wager that'll work
		int sum = 0;

		// As long as there are still digits to sum up...
		while ( number != 0 ) {

			// ... add the last digit of the number to the cross sum...
			sum += number % 10;

			// ... and shift the number by a digit
			number /= 10;
		}

		return sum;
	}

	/**
	 * Honk. Function that computes the digital root.
	 *
	 * @param number	number, of which you calculate the digital root
	 * @return 		the digital root of number
	 */
	private int digitalRoot(int number) {

		int numberSum = crossSum(number);

		// If the cross sum has more than one digit...
		if ((numberSum / 10) != 0) {

			// ... return the value of the cross sum of the cross sum,
			// by calling digitalRoot because we want to do this recursively
			return digitalRoot(numberSum);

		// If it only has one digit...
		} else {

			// ... we have found the value we are looking for!
			return numberSum;

		}
	}

	@Override
	public void run() {

		// Prompt for input
		int number = readInt("Yo, gimme a number: ");

		// Required error check
		if (number < 0) {
			println("Error");
			return;
		}

		// Do the digitalRoot bit
		println(digitalRoot(number));

	}
}
