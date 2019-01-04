package series8;

// package programming.set8.links;


/**
 * A list of Elements...
 * @param <T>	a generic type
 */
public class LinkedElement<T> {

	// The value of the current element
	private T value;

	// A reference to the next element in the List, null if there is none
	private LinkedElement<T> next;


	/**
	 * Construct a thing that's empty.
	 */
	public LinkedElement() {

		this.value = null;
		this.next = null;

	}

	/**
	 * Construct a thing that's not empty.
	 *
	 * @param val	the value to put into the newly made {@code LinkedElement<T> }
	 */
	public LinkedElement(T val) {

		this.value = val;
		this.next = null;

	}


	/**
	 * Returns the value of the i-th linked element, assuming the current element to be at
	 * index 0.
	 *
	 * @param i
	 *            0-based index of the element whose value to return.
	 * @return the i-th element's value, or {@code null} if there is no element with that index.
	 */
	public T get(int i) {

		// If you encountered the end of the list, ergo: there's no element with the asked for index...
		if (next == null && i > 0) {

			return null;

		// ... if you found the looked-for element...
		} else if (i == 0) {

			// ... return it!
			return value;

		// ... else continue the search
		} else {

			return next.get(i-1);

		}

	}

	/**
	 * Adds a new linked element holding the given value at the end of the linked elements.
	 *
	 * @param newVal
	 *            the new value.
	 */
	public void add(T newVal) {

		// Let's assume that the list only consits of the current element.
		// Adding a new element then entails adding it into this.next.
		// However, if this isn't the only or last element of the list,
		// we must recurr until we find the right one!

		// If this is the only or last element of the list...
		if (next == null) {

			// ... add the new element!
			next = new LinkedElement<T>(newVal);

		// Otherwise, try, try again
		} else {

			// One closer to the goal!
			next.add(newVal);

		}

	}

	/**
	 * Removes the i-th element from the linked elements. If {@code i == 0}, this will effectively
	 * remove the head element. Thus, this method returns the linked element that is the new head
	 * element.
	 *
	 * @param i
	 *            index of the element to remove.
	 * @return the new head element.
	 */
	public LinkedElement<T> remove(int i) {

		// If this is the element to remove...
		if (i == 0) {

			// ... return the element, that comes next!
			return next;

		}

		// Rebuild the reference chain...
		next = next.remove(i-1);

		return this;

		/*
		 * What happens here:
		 *
		 * If i is 0 the method returns the element after its current element.
		 *
		 * Otherwise it reassigns the current element's next field to the return value of
		 * remove() called on next.
		 * Then it returns the current element.
		 *
		 * Right, but what does it do?
		 * Assume the following list:
		 *
		 * ind   0      1      2      3      4      -
		 * val  142 -> 363 -> 798 -> 912 -> 366 -> null
		 *
		 * We want to remove the element with the index 2.
		 *
		 *
		 * Then you call remove():
		 *
		 * list.remove(2);
		 *  |
		 *  |  2 != 0, so no if-clause
		 *  |
		 *  |  142.next = 363.remove(1)
		 *  |   |
		 *  |   |  1 != 0, so no if-clause
		 *  |   |
		 *  |   |  363.next = 798.remove(0)
		 *  |   |   |
		 *  |   |   | 0 == 0, so if-clause!	oooh, you found the element to remove!
		 *  |   |   |
		 *  |   |   |   return 912		return the element after the one to remove
		 *  |   |   |
		 *  |   |  363.next = 912		overwrite the ref to 798 with the ref to 912, which comes after 798
		 *  |   |				in effect you skip 798 here, so it is removed from the list
		 *  |   |
		 *  |   |  return 363
		 *  |   |
		 *  |  142.next = 363			overwrite the ref to 363 with 363... so don't change anything
		 *  |					the one's not to remove you simply don't skip
		 *  |
		 *  |  return 142
		 *  |
		 * 142
		 *
		 */

	}

}
