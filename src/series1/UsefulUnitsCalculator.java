package series1;

import acm.program.ConsoleProgram;

public class UsefulUnitsCalculator extends ConsoleProgram {

	public void run() {

		// conversion factor between meters and 'horse lengths'
		double conversionFactor = 2.4;

		// without input, nothing will happen here
		double input = readDouble("Enter a measurement: ");

		// assume horse lengths and turn into meters:
		println(input / conversionFactor);

		// assume meters and turn into horse lengths:
		println(input * conversionFactor);

	}

}
