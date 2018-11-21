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

		// If the layer index ain't valid, don't do no more shit
		if (layerIndex < 0 || layerIndex >= numberOfLayers) {
			return null;
		}

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

		/* So here's an explanation of how this function works...
		 *
		 * Each block has a width.
		 *
		 * To find out the x coordinate of a block (the y coordinate
		 * is fixed by the layerIndex), we walk along the row in the
		 * x-direction with a stepsize equal to the width.
		 *
		 * Basically: to get to the fifth block in a row, we have to
		 * make five steps. If the blocks aren't exactly 1 unit wide,
		 * we have to walk steps, that are as wide as the blocks are.
		 *
		 * Say the blocks are 2 units wide.
		 * These are the positions of the blocks up to block five.
		 *
		 * Block | Position
		 * 0     | 0
		 * 1     | 2
		 * 2     | 4
		 * 3     | 6
		 * 4     | 8
		 * 5     | 10
		 *
		 * To get from block 0 to block 5 we have to walk 5 steps,
		 * each 2 units wide. If the blocks were 3 units wide, we'd
		 * have to walk 5 steps of 3 units each, and so on.
		 *
		 * To turn all of this into a pyramid, we still have to offset each
		 * row by a value proportionate to the layerIndex. Which is why I'm
		 * using just plainly the layerIndex.
		 *
		 */


		/* First produce necessary variables */

		// Block dimensions
		int height = 1;
		int width  = 2;
		int y = numberOfLayers - layerIndex -1; // Subtract layerIndex or you'd draw the pyramid upside down; -1 cause 0-indexing
		int x = 0;

		int startPosition  = layerIndex; // Row start offset for pyramid-ization
		int numberOfBlocks = numberOfLayers - layerIndex;

		// We walk steps of stepsize=width in x direction,
		// if we want to draw numberOfBlocks blocks, this
		// is up-to-but-excluding how many steps we have
		// to take (max-steps + 1)
		int numberOfSteps  = numberOfBlocks * width;


		/* Then draw the actual bricks of the wall */

		// Loop over the x coordinates with a stepsize of width
		for (; x < numberOfSteps; x+=width) {
		//   |   ^ walk up-to-but-excluding numberOfSteps steps
		//   ^ x is already initialized

			// Make the current block
			GRect block = new GRect(
					(startPosition + x) * SCALE_X,	// Brick at position x + the row's offset
					y * SCALE_Y,
					width  * SCALE_X,	// Bricks are 2 units wide
					height * SCALE_Y);	// Bricks are 1 unit tall

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
