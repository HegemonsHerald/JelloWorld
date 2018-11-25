package series4;

import acm.program.ConsoleProgram;

public class PowerSet extends ConsoleProgram {

	@Override
	public void run() {

		/* Get input */

		println("This program prints the power set of the set of natural numbers [0, n].");
		int n;

		while (true) {
			n = readInt("Enter N (0 <= N <= 10): ");

			if (n < 0) {
				println("N must be >= 0.");
				continue;
			} else if (n > 10) {
				println("N must be <= 10.");
				continue;
			} else break;
		}

		print("The powerset of {");

		/* Compute Power Set */

		for (int i = 0; i <= n; i++) {
			if (i<n)	print(i + ", ");
			else if (i==n)	print(i);
		}

		println("} is: \n");

		// go through each number up to the number with n ones
		for (int i = 0; i <= ((2<<n)-1); i++) {

			// flag for commas in output
			boolean hasPrinted = false;

			// for each of those numbers go through each digit (n+1 is the number of digits)
			for (int j = 0; j <= n; j++) {

				// get the bit to check
				int masked = (i>>j)&1;

				// if it's one, you have to print
				if (masked == 1) {
					// do you have to print commas? cause no commas at line start or end
					if (!hasPrinted) hasPrinted = true;
					else print(", ");
					print(j);
				}

				// if it's the last digit, remember to add a newline
				if (j == n) print("\n");
			}
		}

	}

}
