package series6;

//package programming.set6.date;

/**
 * Date. Yup.
 */
public class Date {

	/** The Months of the Gregorian Calendar as Strings. */
	private static final String MONTHS[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

	private int year;
	private int month;
	private int day;

	/** Is a year a leap year?
	 * @param year the year to test
	 * @return true if the year is a leap year
	 */
	private static boolean isLeapYear(int year) {

		/* A year is a leap year if it is divisible by 4
		 * and not divisible by 100, unless it is divisible
		 * by 400
		 */

		if ((year%4 == 0) && ( year%400==0 || year%100!=0 )) return true;
		else return false;
	}

	/** Validates whether a year is a year or not.
	 * @param year year.
	 * @param month month.
	 * @param day day.
	 * @return true if the year is valid
	 */
	public static boolean validate(int year, int month, int day) {
	}

	/** Construct a Date Instance.
	 * @param year year.
	 * @param month month.
	 * @param day day.
	 * @return a Date.
	 */
	public Date(int year, int month, int day) {
	}

	public static int getDaysInMonth(int year, int month) {
	}

}
