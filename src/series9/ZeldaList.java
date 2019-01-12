package series9;

// programming.set9.zelda;

/**
 * ZeldaList.
 *
 * @param T	A value for T
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

		// Make the ZE to add
		ZeldaElement<T> v = new ZeldaElement<T>();
		v.setValue(value); // this is also pretty stupid, why don't you have constructors?

		// If the list doesn't yet contain any elements...
		int size = size();
		if (size == 0) {

			// ... make this the first element of it
			head = v;

		} else {

			// Get the last element
			ZeldaElement<T> last = getElement(size()-1);

			// Link the last element to a new element
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

		// Get the element before the one to remove
		ZeldaElement<T> prev = getElement(indexOf(value)-1);

		// Get the element after the one to remove
		ZeldaElement<T> next = (prev.getNextElement()).getNextElement();

		// Link the element before to the element after
		prev.setNextElement(next);

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
		if (index >= size()) return null;

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
		else if (index >= size()) return null;

		// Otherwise get the element
		return getElementRecurr(head, index);
		// ... Man I wish I could do currying in java right now.

	}

	/**
	 * A helper for getElement that assumes the index to be valid, and
	 * starts recursively walking down the list, always
	 * decrementing the index until it reaches 0.
	 *
	 * @param el   	the element to start the recursion with
	 *
	 * @param index	the index to count down from
	 *
	 * @return     	the element at index {@code index }
	 */
	private ZeldaElement<T> getElementRecurr(ZeldaElement<T> el, int index) {

		// If this is the element to get
		if (index == 0) return el;

		// Else keep looking
		return getElementRecurr(el.getNextElement(), --index);

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
