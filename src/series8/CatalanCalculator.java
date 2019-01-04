package series8;

// package programming.set8.catalan;

/** CatalanCalculator. */
public class CatalanCalculator {

	/**
	 * Calculate Catalan number C(n) and collect statistics along the way.
	 *
	 * @param n
	 *            which Catalan number to calculate.
	 * @return the calculated Catalan number.
	 * @throws IllegalArgumentException
	 *             if n < 0.
	 */
	public int catalan(int n) {

		if (n < 0) throw new IllegalArgumentException();
		
		// reset statistics
		calculatedCatalanNumbersCount = 0;
		calculatedCatalanNumberCount  = new int[n+1]; // eg: catalan(3) computes c(0) c(1) c(2) c(3), so 3+1=4 numbers
		maximumStackDepth = 0;

		return catalanCalculator(n, 1);

	}

	/**
	 * Actually does the catalan calculation.
	 *
	 * @param n         	the nth-catalan number will be returned
	 *
	 * @param stackDepth	how many calls were made to get here...
	 *
	 * @return          	the nth catalan number
	 */
	private int catalanCalculator(int n, int stackDepth) {

		// update statistics
		calculatedCatalanNumbersCount++;
		calculatedCatalanNumberCount[n]++;
		if (stackDepth > maximumStackDepth) maximumStackDepth = stackDepth;

		// Do computation

		if (n == 0) {

			return 1;

		} else {

			int sum = 0;

			for (int k = 0; k < n; k++) {

				// note: with each call to the calculator, the call stack gets one call larger
				sum += catalanCalculator(k, stackDepth+1) * catalanCalculator(n-1-k, stackDepth+1);

			}

			return sum;

		}

	}

	/**
	 * The number of calculated Catalan numbers. This is equal to the total number
	 * of calls to the calculation method.
	 */
	private int calculatedCatalanNumbersCount;

	/**
	 * The number of times each Catalan number was calculated.
	 */
	private int[] calculatedCatalanNumberCount;

	/**
	 * The longest path from the first method call to the deepest method call. This
	 * is equal to the highest number of stack frames your calculation method has
	 * on the stack during the calculations.
	 */
	private int maximumStackDepth;


	/**
	 * Returns the total number of Catalan numbers computed to compute the one
	 * requested by the user.
	 *
	 * @return number of calculated Catalan numbers.
	 * @throws IllegalStateException
	 *             if this method is called before {@link #catalan(int)} was called.
	 */
	public int getCalculatedCatalanNumbersCount() {
		if (calculatedCatalanNumbersCount == 0) {

			throw new IllegalStateException();

		} else {

			return calculatedCatalanNumbersCount;

		}
	}

	/**
	 * Returns the number of times the given Catalan number was computed to compute
	 * the one requested by the user.
	 *
	 * @param i
	 *            the Catalan number whose computation statistics to return.
	 * @return how often C(i) was computed.
	 * @throws IllegalStateException
	 *             if this method is called before {@link #catalan(int)} was called.
	 * @throws IllegalArgumentException
	 *             if the index i is invalid.
	 */
	public int getCalculatedCatalanNumberCount(int i) {

		if (calculatedCatalanNumbersCount == 0) {

			throw new IllegalStateException();

		} else {

			if (i < 0 || i >= calculatedCatalanNumberCount.length) {

				throw new IllegalArgumentException();

			} else {

				return calculatedCatalanNumberCount[i];

			}

		}

	}

	/**
	 * Returns the maximum stack depth encountered while computing the requested
	 * Catalan number.
	 *
	 * @return maximum stack depth.
	 * @throws IllegalStateException
	 *             if this method is called before {@link #catalan(int)} was called.
	 */
	public int getMaximumStackDepth() {

		if (calculatedCatalanNumbersCount == 0) {

			throw new IllegalStateException();

		} else {

			return maximumStackDepth;

		}

	}

}
