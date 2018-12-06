package series6;

//package programming.set6.date;

/**
 * Date. Yup.
 */
public class Date {

	/** The Months of the Gregorian Calendar as Strings. */
	private static final String MONTHS[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

	// The required fields to represent a date
	private int year;
	private int month;
	private int day;

	/** getYear.
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/** getMonth.
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/** getDay.
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/** Is a year a leap year?
	 * @param year the year to test
	 * @return true if the year is a leap year
	 */
	//private static boolean isLeapYear(int year) {
	public static boolean isLeapYear(int year) {

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

		// Either the month is out of the range of a year...
		if (month < 1 || month > 12) return false;

		// ... or the day is out of the range of possible days in that month...
		else if (day < 1 || day > getDaysInMonth(year, month)) return false;

		// ... or it's valid
		else return true;

	}

	/** Construct a Date Instance.
	 * @param year year.
	 * @param month month.
	 * @param day day.
	 * @return a Date.
	 */
	public Date(int year, int month, int day) {

		// Check validity
		if (!validate(year, month, day)) {
			throw new IllegalArgumentException("This is not a valid date.");
		}

		// Make Date
		this.year  = year;
		this.month = month;
		this.day   = day;

	}

	/** Gets how many days there are in a month in a year.
	 * @param year year.
	 * @param month month.
	 * @return whatcha asked.
	 */
	public static int getDaysInMonth(int year, int month) {

		// Wenn Monat kleiner-gleich 7 und ungerade ist 31 Tage,
		// wenn grőßer als 7 und gerade ist 31 Tage
		// If the month is february...
		if (month == 2) {

			if (isLeapYear(year)) return 29;
			else return 28;

		// ... if month between January and July...
		} else if (month <= 7) {

			// ... return 30 if even and 31 if odd...
			if (month%2==0) return 30;
			else return 31;

		// ... if month between August and December...
		} else if (month > 7) {

			// ... return 31 if even and 30 if odd
			if (month%2==0) return 31;
			else return 30;

		} else return 0;

	}

	/** Returns the absolute day count of the date, in reference to 365/366 days in a whole year.
	 * @return
	 */
	public int dayOfYear() {
		return 0;
	}

	/** Returns the difference between two dates, provided both are in the same year.
	 * If the dates aren't in the same year the method returns 0.
	 * @param other
	 * @return
	 */
	public int sameYearDiff(Date other) {
		return 0;
	}

	@Override
	public String toString() {
		return MONTHS[this.month + 1] + " " + this.day + ", " + this.year;
	}

}
