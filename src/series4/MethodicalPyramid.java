package series4;

import java.awt.*;
import acm.program.*;
import acm.graphics.*;

/**
 * Why oh just why call it methodical...?
 */
public class MethodicalPyramid extends GraphicsProgram {



	private static final int SCALE_X = 10;
	private static final int SCALE_Y = 10;



	/**
	 * Returns the color to be used for bricks in the given layer.
	 *
	 * @param layerIndex
	 *            index of the layer whose color to return. {@code 0} is the
	 *            bottom layer, {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @return the color to be used for the given layer, or {@code null} if
	 *         {@code layerIndex} is invalid.
	 */
	public Color layerColor(int layerIndex, int numberOfLayers) {

		// This has to be a float to make sure we get decimal places, without having to count remainders...
		float fraction = (float) layerIndex / (float) (numberOfLayers - 1);

		// Have to return to integers, cause task specs it
		return new Color(255, (int) (fraction * 220), (int) (fraction * 220));

	}

	/**
	 * Draws the given layer with bricks filled with the given color. If
	 * {@code layerIndex} is invalid, no bricks at all should be drawn.
	 *
	 * @param layerIndex
	 *            index of the layer to draw. {@code 0} is the bottom layer,
	 *            {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @param layerColor
	 *            color the layer's bricks should be filled with.
	 */
	public void drawLayer(int layerIndex, int numberOfLayers, Color layerColor) {

		/* So here's an explanation of how this function works
		 *
		 */ 


		/* First produce necessary variables */

		int startPosition  = layerIndex;
		int numberOfBlocks = numberOfLayers - layerIndex;

		int y = numberOfLayers - layerIndex -1;
		int x = 0;


		/* Then draw the actual bricks of the wall */

		for (; x < (numberOfBlocks*2); x+=2) {

			// Make the current block
			GRect block = new GRect(
					(startPosition + x) * SCALE_X,	// Brick at position x + the row's offset
					y * SCALE_Y,
					2 * SCALE_X,	// Bricks are 2 units wide
					1 * SCALE_Y);	// Bricks are 1 unit tall

			// Style the current block
			block.setFilled(true);
			block.setFillColor(layerColor);

			// Draw the current block
			add(block);
		}
	}

	@Override
	public void run() {

		// Get the number of bricks for the bottom layer
		int n = readInt("How many bricks u want? ");

		// Draw a row of blocks for each number leading up to the number of bricks the user entered. =)
		for (int i = 0; i < n; i++) {
			drawLayer(i, n, layerColor(i, n));
		}

	}

}
