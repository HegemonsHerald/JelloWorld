package series9;

// package programming.set9.zelda;

/**
 * ZeldaList.
 *
 * @param <T>	A value for T
 */
public class ZeldaList<T> {

	// Where to put the head of this linked list.
	private ZeldaElement<T> head;

	/**
	 * Adds the given value to the end of the list.
	 *
	 * @param value
	 *            the value to add. If {@code value == null}, nothing happens.
	 */
	public void add(T value) {

		// If the value is null, nothing happens
		if (value == null) return;

		// How long is the list?
		int lastIndex = size()-1;

		// If there is nothing in the list...
		if (lastIndex == -1) {

			head = new ZeldaElement<T>();
			head.setValue(value);

		// If however there is sth in the list...
		} else {

			// ... get the last element of the list
			ZeldaElement<T> last = getElement(lastIndex);

			// make a new element to add
			ZeldaElement<T> v = new ZeldaElement<T>();
			v.setValue(value);
			
			// add the new element after the last element of the list
			last.setNextElement(v);

		}
	}

	/**
	 * Removes the first occurrence of the given value from the list.
	 *
	 * @param value the value to remove. If this is {@code null}, nothing is removed.
	 * @return {@code true} if the value was found and removed, {@code false} otherwise.
	 */
	public boolean remove(T value) {

		// If there's nothing to remove, remove nothing
		if ( value == null || !contains(value) ) return false;

		// If there's only one element in the list...
		if (size() < 2) {

			// At this point the only element is the element to remove
			clear();
			return true;

		}

		// Otherwise there's stuff to do...

		// Get the index and the element to remove
		int index = indexOf(value);
		ZeldaElement<T> removeMe = getElement(index);

		// Get the element after the one to remove
		ZeldaElement<T> next = removeMe.getNextElement();

		// If you are to remove the first element...
		if (index == 0) {

			head = next;

		// ... Otherwise...
		} else {

			// Get the element before the one to remove
			ZeldaElement<T> prev = getElement(indexOf(value)-1);

			// Link the element before to the element after
			prev.setNextElement(next);

		}

		// You were successfull
		return true;

	}

	/**
	 * Checks if the given value appears anywhere in the list.
	 *
	 * @param value
	 *            the value to search for.
	 * @return {@code true} if the value appears in the list, {@code false} if it doesn't or if it
	 *         is {@code null}.
	 */
	public boolean contains(T value) {

		// From task
		if (value == null) return false;

		// Get the index
		int indexOfValue = indexOf(value);

		// If indexOf didn't find the element...
		if (indexOfValue == -1) return false;

		// ... otherwise it must be in the list
		return true;

	}

	/**
	 * Returns the value at the given index in the list.
	 *
	 * @param index
	 *            the index of the element whose value to return.
	 * @return the value at the given index, or {@code null} if the index is invalid.
	 */
	public T get(int index) {

		// Is the index valid?
		if (index >= size() || index < 0) return null;

		// Get the element at index
		ZeldaElement<T> el = getElement(index);

		// And return its value
		return el.getValue();

	}

	/**
	 * Gets the element of the list at position index.
	 *
	 * @param index	the index to count up to
	 *
	 * @return     	the element at index
	 */
	private ZeldaElement<T> getElement(int index) {

		// Is the list empty?
		if (isEmpty()) return null;

		// Is the index out of bounds?
		else if (index >= size() || index < 0) return null;

		ZeldaElement<T> curr = head;

		int i = index;
		while (i > 0) {

			curr = curr.getNextElement();
			i--;

		}

		return curr;


	}


	/**
	 * Returns the smallest index where the given value appears in the list, if it does.
	 *
	 * @param value
	 *            the value to look for.
	 * @return the value's index or -1 if {@code value == null} or if the value is not in the list.
	 */
	public int indexOf(T value) {

		// From task.
		if (value == null) return -1;

		// If there's no element
		if (isEmpty()) return -1;

		// Otherwise the element could be in the list
		return indexOfRecurr(value, head, 0);

	}

	/**
	 * Method that adds up indices, until it finds an element of the linked list
	 * that's got a value of {@code value }.
	 *
	 * @param value	the value we're looking for
	 *
	 * @param el   	the element to check
	 *
	 * @param index	the index of {@code el }
	 *
	 * @return     	-1 if {@code el } is the last element of the list,
	 *             	otherwise the index of the element (this method calls
	 *             	itself)
	 */
	private int indexOfRecurr(T value, ZeldaElement<T> el, int index) {

		// Get the value to compare against
		T val = el.getValue();

		// If this is the element, we're looking for...
		if (val.equals(value)) {

			// ... return its index
			return index;

		// If this isn't the element, we're looking for...
		} else {

			// Get the next element
			el = el.getNextElement();

			// Check, that we haven't reached the end of the list,
			// without finding the element we're looking for
			if (el == null) return -1;

			// And figure out, if the next element is the element,
			// we're looking for
			return indexOfRecurr(value, el, ++index);

		}

	}

	/**
	 * Removes all elements from the list.
	 */
	public void clear() {

		head = null;

	}

	/**
	 * Checks if the list contains any elements.
	 *
	 * @return {@code true} if the list is empty, {@code false} if it isn't.
	 */
	public boolean isEmpty() {

		if (head == null) return true;
		else return false;

	}

	/**
	 * Returns the number of elements in the list.
	 *
	 * @return number of elements.
	 */
	public int size() {

		// No elements?
		if (isEmpty()) return 0;

		// If there are elements...

		// There's at least one element, the head
		int count = 1;

		// Now count the ones after the head

		ZeldaElement<T> next = head.getNextElement();

		while (next != null) {

			count++;

			next = next.getNextElement();

		}

		return count;

	}

}
