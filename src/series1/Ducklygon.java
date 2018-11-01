package series1;

import acm.program.GraphicsProgram;
import acm.graphics.*;

public class Ducklygon extends GraphicsProgram {

	public void drawDucklygon() {

		// Let's put some ducks in a circle, which will now be referred to as a duck-lygon!
		int n = readInt("How many ducks do you want? ");
		System.out.println("Oooh, good choice!");

		// Resize factor to make that damn thing visible
		int resizeFactor = 100;

		// If you want to draw lines from duck to duck, you need to remember, where the last duck was!
		// This is initialized with the position of the first duck of the duck-lygon
		GPoint lastDuck = new GPoint(2.0,1.0);

		// Loop yay, note that the loop starts with the second duck cause we already know where the first duck goes!
		for (int i = 1; i <= n+1; i++) {

			// How far have you gotten round the duck-lygon?
			double currAngle = i * (2 * Math.PI / n);

			// Calculate where the current duck is
			GPoint currDuck = new GPoint(Math.cos(currAngle) + 1.0, Math.sin(currAngle) + 1.0);

			// Draw the line from the last duck to the current duck
			add(new GLine(lastDuck.getX()*resizeFactor, lastDuck.getY()*resizeFactor, currDuck.getX()*resizeFactor, currDuck.getY()*resizeFactor));

			// Make the last duck be the current duck
			lastDuck = currDuck;
		}

		// Wanna draw another duck-lygon?
		drawDucklygon();
	}

	public void run() {
		add(new GLabel("Hoho, I hate both Java and the ACM, and the latter even more than the former!"), 190, 100);

		// you also still need to check, that the rotation is as they want it from the task...

		println("So you want to make a Duck-lygon....");

		// make a duck-lygon
		drawDucklygon();
	}

	// C-F11 is eclipse's command for executing
	// F5 is eclipse's command for reloading

	// sensible nmaps for eclipse java projects
	// - <j for insert comment slashes	nnoremap <j I// <Esc>
	// - <k for remove comment slashes	nnoremap <k ^xxx
	// - re for reload
}
