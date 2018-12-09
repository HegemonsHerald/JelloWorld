package series6;

import acm.program.ConsoleProgram;

/**
 * Was is Sieben mal Sieben? Feiner Sand.
 */
public class SieveOfEratosthenes extends ConsoleProgram {

	/** Checks whether a number is a prime or not
	 * @param a a number to check for primety
	 * @return whether it's a prime or not
	 */
	private static boolean isPrime(int a) {
		for (int i = 2; i<a; i++) {
			if (a%i==0) return false;
		}
		return true;
	}

	// @Override
	public void run() {

		/* Get Input */

		int n = 0;

		do {
			n = readInt("Give me an Integer that's larger or at least equal to 2: ");
		} while (n < 2);

		/* Init Computation Array */

		// Init numbers array
		int numbers[] = new int[n-1];

		// Fill array with appropriate values
		int count = 2;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = count++;
		}


		/* Execute Eratosthenes' algorithm */

		// Loop!
		for (int i = 0; i < numbers.length; i++) {

			int a = numbers[i];

			// If the number is set to 0, there's nothing to do...
			if (a == 0) continue;

			// ... else if the number is prime
			else if (isPrime(a)) {

				// ... output it...
				println(a);

				// ... set all multiples of the number to 0...
				for (int j = 1; j*a < numbers.length; j++) {
					numbers[(j*a) -2] = 0;
				}

				// ... else there's nothing to do
			} else continue;

		}

	}
}
