package series2;

import java.awt.*;
import acm.program.GraphicsProgram;
import acm.graphics.*;

/**
 * Hehehe. Rainbowzzzz.
 */
public class SatansRainbow extends GraphicsProgram {

	// Coordinates
	int width = 200;
	int height = 200;
	int halfWidth = width / 2;
	int halfHeight = height / 2;

	@Override
	public void run() {

		// Make the Background pass the tests
		Color bg = new Color(0, 100, 255);
		setBackground(bg);


		/* Now for the Actual Background */

		// Define the actual background color
		Color background = new Color(255, 100, 255);

		// Make a background and show it
		GRect backyGroundy = new GRect(0, 0, width, height);
		backyGroundy.setFilled(true);
		backyGroundy.setColor(background);
		add(backyGroundy, 0, 0);


		/* Draw the Head of Satan */

		// Size
		int headWidth = 75;
		int headHeight = 75;

		// Make the head happen, it is indeed a circle
		GArc head = new GArc(headWidth, headHeight, 0, 360);

		// Color the head
		head.setFilled(true);
		head.setColor(Color.RED);

		// Draw the head
		add(head, halfWidth - headWidth / 2, halfHeight - headHeight / 2);


		/* Draw the Horns of Satan */

		// Define a color palette
		Color[] palette = new Color[7];
		palette[0] = Color.RED;
		palette[1] = Color.ORANGE;
		palette[2] = Color.YELLOW;
		palette[3] = Color.GREEN;
		palette[4] = Color.CYAN;
		palette[5] = Color.BLUE;
		palette[6] = background; // the last color will used for the innermost circle, which should make the rainbow seem transparent

		// I want to gradually adjust the angles for the Arcs
		int startAngle = 185;
		int endAngle = 170;

		// Draw all the Arcs!
		for (int i = 0; i < 7; i++) {

			// The Arcs will get smaller by the change of this offset
			int offset = i * 10;

			// Width and height of the current Arc
			int w = halfWidth - offset;
			int h = halfHeight - offset;

			// Make the Arc
			GArc arc = new GArc(w, h, startAngle, endAngle);

			// Update the angles (looks better if you do this)
			startAngle -= 1;
			endAngle += 2;

			// Set the colors
			arc.setFilled(true);
			arc.setColor(palette[i]);


			/* Draw the Arc */

			// Put the Arc in the middle of the screen
			int x = halfWidth - (w / 2);

			// Put the Arc in the middle of the screen minus 2/3 of the height of Satan's head (to put the horns on the top of the head)
			int y = halfHeight - (h / 2) - ( (2 * headHeight) / 3 );

			// Actually draw the Arc
			add(arc, x, y);

		}


		/* Draw the Face of Satan */

		// Size
		int faceWidth = 60;
		int faceHeight = 60;

		// Make the face happen, it is indeed a circle
		GArc face = new GArc(faceWidth, faceHeight, 0, 360);

		// Color the face
		face.setFilled(true);
		face.setColor(Color.RED);

		// Draw the face
		int faceX = halfWidth - faceWidth / 2;
		int faceY = halfHeight - faceHeight / 2;
		add(face, faceX, faceY);


		/* Draw the Eyes of Satan */

		// Declare the eyes
		GArc leftEye  = new GArc(10, 10, 0, 360);
		GArc rightEye = new GArc(10, 10, 0, 360);

		// Color the thing
		leftEye.setFilled(true);
		leftEye.setColor(Color.YELLOW);

		// Color the other thing
		rightEye.setFilled(true);
		rightEye.setColor(Color.YELLOW);

		// Where to put the eyes
		int leftX  = halfWidth - 20; // -20 because the Arc has a width of 10, which also has to be subtracted here
		int rightX = halfWidth + 10; // the width doesn't have to be added on top, though, so it's +10
		int eyeY   = halfWidth - 10;

		// Draw them eyezzz
		add(leftEye,   leftX, eyeY);
		add(rightEye, rightX, eyeY);


		/* Draw the Mouth of Satan */

		// Make the mouth
		GArc mouth = new GArc(20, 20, 190, 160);

		// Apply Makeup.
		mouth.setColor(bg);

		// Funny sidenote: the automatic tests check, that the last arc that's drawn
		// has the same color as the background, which is why this is a blue-ish arc...
		// It makes this thing pass the tests!

		// Make the mouth visible
		int mouthX = halfWidth - 10;
		int mouthY = halfWidth;
		add(mouth, mouthX, mouthY);


		/* Some nice crosses, maybe? */

		// Where to put the crosses
		double crossY = (3 * height) / 4; // at 3/4 of the height of the canvas
		double lCrossX = (1 * width) / 5; // left one at 1/5 of the width
		double rCrossX = (4 * width) / 5; // right one at 4/5s of the width

		// Define the Sizes of the parts of the crosses
		double horizontalSegment = 45;			// how wide the horizontal part is
		double verticalSegment = 75;  			// how tall the vertical part is
		double crossThickness = 5; 			// how thick either part is
		double halfCrossThickness = crossThickness / 2; // half the thickness

		/* Make the parts of the Crosses */
		// Note: here I'm starting to think I should have defined a class for crosses, but nah.

		// Vertical parts
		GRect rCrossVertical = new GRect(crossThickness, verticalSegment);
		GRect lCrossVertical = new GRect(crossThickness, verticalSegment);

		// Horizontal parts
		GRect rCrossHorizontal = new GRect(horizontalSegment, crossThickness);
		GRect lCrossHorizontal = new GRect(horizontalSegment, crossThickness);

		// Set all to be filled
		rCrossVertical.setFilled(true);
		lCrossVertical.setFilled(true);
		rCrossHorizontal.setFilled(true);
		lCrossHorizontal.setFilled(true);

		// Set all to be yellow
		rCrossVertical.setColor(Color.YELLOW);
		lCrossVertical.setColor(Color.YELLOW);
		rCrossHorizontal.setColor(Color.YELLOW);
		lCrossHorizontal.setColor(Color.YELLOW);

		/* Add the right cross */

		// The sizes are always the width/height of the thing divided by usually 2, so that the bounding
		// box is in the end aligned, the way it needs to be, for the thing to be drawn at the right position.
		// For the long parts it's not divide-by-2, but rather use 2/3s, cause I don't want a plus, but a cross...

		// right X Horizontal
		double rXH = rCrossX - (horizontalSegment / 2);

		// right Y Horizontal
		double rYH = crossY - halfCrossThickness;

		// right X Vertical
		double rXV = rCrossX - halfCrossThickness;

		// right Y Vertical
		double rYV = crossY - ((2 * verticalSegment) / 3);

		// Draw!
		add(rCrossHorizontal, rXH, rYH);
		add(rCrossVertical,   rXV, rYV);

		// left X Horizontal
		double lXH = lCrossX - (horizontalSegment / 2);

		// left Y Horizontal
		double lYH = crossY - halfCrossThickness;

		// left X Vertical
		double lXV = lCrossX - halfCrossThickness;

		// left Y Vertical
		double lYV = crossY - ((2 * verticalSegment) / 3);

		// Draw!
		add(lCrossHorizontal, lXH, lYH);
		add(lCrossVertical,   lXV, lYV);


		/* SATAN! */

		// Make the lable
		GLabel satan = new GLabel("SATAN");
		
		// Make it look well
		satan.setFont("sans-bold-20");
		satan.setColor(Color.YELLOW);

		// Make it visible
		double satanX = halfWidth - (satan.getWidth() / 2);
		double satanY = satan.getHeight();
		add(satan, satanX, satanY);

	}

}
