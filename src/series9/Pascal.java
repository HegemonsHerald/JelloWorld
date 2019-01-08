import java.util.Stack;
import java.util.*;

public class Pascal {

	/**
	 * Returns the layer of pascal's triangle, that comes after the layer, that's provided.
	 *
	 * @param lastLayer	the layer for which to compute the following layer
	 *
	 * @return         	the layer that follows lastLayer
	 */
	private static Stack<Integer> nextLayer(Stack<Integer> lastLayer) {

		// Stack that will hold the new layer
		Stack<Integer> newLayer = new Stack<Integer>();

		// The always top values of the source stack
		int pop;
		int secondPop;

		// The last layer might be empty...
		try {

			pop = lastLayer.pop();

		} catch (EmptyStackException e) {

			// ... in which case I opt to provide the first layer of the triangle
			newLayer.push(1);
			return newLayer;

		}

		// The first value on the new layer is always the last value of the previous -- 1
		newLayer.push(pop);

		// Do this until there's nothing left on the last layer stack
		while (true) {

			try {

				// If this fails, the lastLayer stack is empty...
				secondPop = lastLayer.pop();

			} catch (EmptyStackException e) {

				// Then just add the bottom value from lastLayer to the new layer -- 1 -- and return
				newLayer.push(pop);
				return newLayer;

			}

			// ... If it wasn't the last value:

			// Add the new number to the layer
			newLayer.push(pop + secondPop);

			// Update the pop cause we need it for the next number
			pop = secondPop;

		}

		/*
		 * What happens in here:
		 *
		 *  []		if it's empty, the first try-catch returns [1]
		 *  [1]		pop=1; push(pop); reach the second catch-block: push(pop) and return
		 *  [1,1]	pop=1; push(pop); secondPop=1; push(1+1); pop=1; reach second catch: push(1) and return
		 *  [1,2,1]	pop=1; push(pop); secondPop=2; push(1+2); pop=2; secondPop=1; push(2+1); pop=1; reach second catch: push(1) and return
		 *  [1,3,3,1]	...
		 *  ...
		 */

	}

	public static void main(String args[]) {

		Stack<Integer> major = new Stack<Integer>();

		int c = 0;

		while (c < 10) {

			System.out.println(major);
			major = nextLayer(major);

			c++;

		}

	}

}
