package series4;

import java.awt.*;
import acm.program.*;
import acm.graphics.*;

/**
 * Why oh just why call it methodical...?
 */
public class MethodicalPyramid extends GraphicsProgram {



	private static final int SCALE_X = 20;
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



		/* Produce relevant values */

		/*
		 * The bottom layer contains as many blocks as there are layers,
		 * because from layer to layer you remove 1 block each time.
		 * layerIndex says (because of the given stacking of layers)
		 * how many blocks you have to remove from the layer to get how
		 * many blocks there still are in the layer.
		 */
		int numberOfBlocks = numberOfLayers - layerIndex;
		println(numberOfBlocks);

		// Works because we are counting from the bottom up
		int startPosition  = layerIndex;

		int width  = 2;
		int height = 1;
		int y      = numberOfLayers - layerIndex - 1; // Just using layerIndex would draw the pyramid upside down; -1 because 0-indexing
		int x      = startPosition; // The layer's first block starts at startPosition


		print(x);



		/* I am truly impressed.
		 * This problem is actually more understandably solved using your sentinel pattern.
		 * Not many are.
		 */
		while (true) {

			// Make and draw a Block
			GRect block = new GRect(x * SCALE_X, y * SCALE_Y, 1 * SCALE_X, 1 * SCALE_Y);
			block.setFilled(true);
			block.setFillColor(layerColor);

			add(block);

			// Repeat the drawing process until x becomes larger than numberOfBlocks
			if (x <= numberOfBlocks) { x+=2; } else { break; }
			// Note: once x == numberOfBlocks there will be one more repetition, so
			// exactly numberOfBlocks blocks are drawn (we don't break directly, as
			// we would with a regular for or while loop)

			print(": ");
			print(x);
			print("\n");
		}
	}

	@Override
	public void run() {

		// Get the number of bricks for the bottom layer
		int n = readInt("How many bricks u want? ");

		for (int i = 0; i < n; i++) {
			drawLayer(i, n, layerColor(i, n));
		}

		/*
		 *
		 * position at how many blocks you deleted from the row and make each block two units by one unit
		 *
		 *
		 * 
		 *
		 *
		 */

		println("Honk");

	}

}
