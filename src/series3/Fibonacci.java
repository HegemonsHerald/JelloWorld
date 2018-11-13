package series3;

import acm.program.ConsoleProgram;


/**
 * As the classname quite exquisitly implies, this is indeed an implementation of a fibonacci-sequence calculator.
 */
public class Fibonacci extends ConsoleProgram {

	/**
	 * And now for our favorite symbol from the unicode: .
	 *
	 * The actual fibonacci function
	 *
	 * @param n         number  the 0-indexed index of the to-be-calculated fibonacci number
	 * @param fibMemo           an array in which to store fibonacci numbers during calculation
	 * @return                  like an integer, dude
	 */
	private static int fib(int n, int[] fibMemo) {

		// Check, whether fibMemo[n] has been computed yet (arrays are initialized to 0)
		if (fibMemo[n] == 0) {

			// If it hasn't been computed, compute it
			fibMemo[n] = fib(n-1, fibMemo) + fib(n-2, fibMemo); // fib(n) = fib(n-1) + fib(n-2)

		}

		// Return the fib number you computed
		return fibMemo[n];
	}

	@Override
	public void run() {

		/* Input */

		// The how many-th fib number should be computed?
		int n = readInt("Give me a fib: ");

		// The task requires this error check
		if (n<1) {
			println("Error");
			return;
		}

		// The fib values are stored in an array, which means we have to use 0-indexing and adjust
		n--;


		/* Memory array */

		// Declare
		int[] fibMemo = new int[100];

		// Add base case values
		fibMemo[0] = 1;
		fibMemo[1] = 1;

		/*
		 * Using an array like this has several benefits:
		 *  - performance: you don't make a ludicrously large recursive call tree
		 *  - recursion base case checking: you don't have to do it explicitely, which means less if-statements
		 *
		 * Note: I say 'base case' for a condition, under which a recursion should terminate.
		 */


		// Output the requested fib number
		println(fib(n, fibMemo));

	}

}
