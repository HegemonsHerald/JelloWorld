package series6;

import series6.*;

/**
 * NAME.
 */
public class DateTestground {

	public static void main(String args[]) {

		// create a date
		Date d1 = new Date(2016, 3, 26);
		Date d2 = new Date(2016, 12, 15);
		Date d3 = new Date(2016, 1, 24);
		Date d4 = new Date(12, 1, 24);
		Date d5 = new Date(2008, 1, 4);

		// check toString
		System.out.println("check println");
		System.out.println(d1);
		System.out.println(d5);
		System.out.println();

		// check for leap years
		System.out.println("is leap year with 2016 and 2017");
		System.out.println(Date.isLeapYear(2016));
		System.out.println(Date.isLeapYear(2017));
		System.out.println();

		// check for days in month
		System.out.println("how many days in month with february 2016, feb 2017, march, january, december, november");
		System.out.println(Date.getDaysInMonth(2016, 2));
		System.out.println(Date.getDaysInMonth(2017, 2));
		System.out.println(Date.getDaysInMonth(2016, 3));
		System.out.println(Date.getDaysInMonth(2016, 1));
		System.out.println(Date.getDaysInMonth(2016, 12));
		System.out.println(Date.getDaysInMonth(2016, 11));
		System.out.println();

		// check validation
		System.out.println("date validation");
		System.out.println(Date.validate(2017, 2, 33));
		System.out.println(Date.validate(2018, 12, 17));
		System.out.println();

		// check dayOfYear
		System.out.println("day of year");
		System.out.println(d1.dayOfYear());
		System.out.println();

		// check sameYearDiff
		System.out.println("sameYearDiff first with self, future, past, outOfBounds");
		System.out.println(d1.sameYearDiff(d1));
		System.out.println(d1.sameYearDiff(d2));
		System.out.println(d1.sameYearDiff(d3));
		System.out.println(d1.sameYearDiff(d4));
		System.out.println();

	}

}

/*
 *
 * in substitute:
 *   \=VARNAME
 * to use variables
 *
 * vimscript
 *   setline(number, text)	sets line number number to be text
 *   append(number, lines)	appends lines after line number
 *   line(".")			gets current line number
 *   getline(number)		gets line from buffer
 *   paste option
 *
 *   exec "norm ..." allows you to use escape characters while
 *   calling up :norm, see :h expr-quote for a list of valid escapes
 */
