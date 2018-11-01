package series1;

import acm.program.*;

public class Add3Integers extends ConsoleProgram {
	public void run() {

		// literally what this program does:
		println("This program adds three integers. How terribly creative.");

		// get some stuff to add
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int n3 = readInt("Enter n3: ");

		// add the stuff
		int total = n1 + n2 + n3;

		// tell the user what you came up with, cause you're such a good boy, such! a! good! boy!
		println("The total is " + total + ".");
	}
}
