package series3;

import acm.program.ConsoleProgram;

/**
 * AAAAAMERICAAAA F**K YEAH! We got Fahrenheit.
 */
public class TemperatureConverter extends ConsoleProgram {

	// The (epic voice) SENTINEL
	private static final int SENTINEL = -1337;

	/**
	 * Convert celsius from fahrenheid to temperature.
	 *
	 * @param celsius temperature to convert
	 * @return temperature in fahrenheit
	 */
	private double celsiusToFahrenheit(double celsius) {

		// f = (9/5 * c) + 32
		double fahrenheit = (9.0 / 5.0) * celsius + 32;

		return fahrenheit;
	}

	/**
	 * Convert temperature from fahrenheid to celsius.
	 *
	 * @param fahrenheit temperature to convert
	 * @return temperature in fahrenheit
	 */
	private double fahrenheitToCelsius(double fahrenheit) {

		// c = 5/9 * (f - 32)
		double celsius = (5.0 / 9.0) * (fahrenheit - 32);

		return celsius;
	}

	@Override
	public void run() {

		/*
		 * Are you telling me the user doesn't already know, exactly how to use this
		 * black-box of a program?!?
		 */

		// Menu.
		println("What do you want me to do?");
		println("(1) Convert Celsius to Fahrenheit");
		println("(2) Convert Fahrenheit to Celsius");

		// Mode of operations?
		int conversionMode = readInt("Mode: ");

		// If the Mode is neither 1 nor 2...
		if (conversionMode != 1 && conversionMode != 2) {
			// ... something's gone wrong so shout at the user
			println("That's not a valid Modus Operandi for converting Temperatures.\nAre you a pre-schooler?\nLearn to read!");
			return;
		}


		/* Computation cycle */

		// Initial input
		double sourceTemperature = readDouble("Temperature: ");

		// Do forever
		while (true) { // The heck? You can't do while (1)?

			// Sentinel check... I mean you could just put this in the while-condition, but no.
			if (sourceTemperature == SENTINEL) {
				break;
			}

			// Check the mode, do the appropriate thing
			switch (conversionMode) {

				case 1:
					println(celsiusToFahrenheit(sourceTemperature));
					break;
				case 2:
					println(fahrenheitToCelsius(sourceTemperature));
					break;

			}

			// Get a new temperature to convert
			sourceTemperature = readDouble("Temperature: ");
		}

		// Honk
		println("honk");

	}

}
