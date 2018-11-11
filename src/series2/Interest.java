package series2;

import acm.program.ConsoleProgram;

/**
 * Are these enough periods: ........ ?
 *
 * A program that calculates an account balance after one and two years for a
 * given balance and annual interest rate.
 */
public class Interest extends ConsoleProgram {

	/** run... */
	public void run() {

		// Get input
		double startingBalance = readDouble("How many Breadcrumbs does the little Ducky have? ");
		double interestRate    = readDouble("How much should the little Ducky's Breadcrumbs grow? ");

		// Compute new balances
		double firstYearBalance = startingBalance + ( startingBalance * interestRate / 100.0);
		double secondYearBalance = firstYearBalance + ( firstYearBalance * interestRate / 100.0);
		/*
		 * This is basic percent math:
		 *  - Prozentwert/Grundwert = p/100
		 *  - Prozentwert = p/100 * Grundwert
		 *  - firstYear   = 5/100 * startingBalance → for a 5% growth
		 */

		// Output

		// Cause I want my ducky plot:
		println("In the first year the Ducky has: " + firstYearBalance);
		println("In the second year the Ducky has: " + secondYearBalance);

		// Cause the tests don't want ducky plot:
		println("The balance after the first year is " + firstYearBalance);
		println("The balance after the second year is " + secondYearBalance);

	}

}
