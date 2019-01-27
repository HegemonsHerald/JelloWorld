package series11;

// package programming.set11.xyset;

/**
 * Yup dis a list set thingy bajigny.
 *
 * @param <E>	Type of dem elements
 */
public class ExcellentXYSet<E> implements XYSet<E> {

	/* And now for something extremely stupid, because apparently you didn't actually end-up making the previously created classes available to us.... ggrrrrrrr. */

	/**
	 * ZeldaList.
	 *
	 * @param <E>	A value for E
	 */
	public class ZeldaList<E> {

		// Where to put the head of this linked list.
		private ZeldaElement<E> head;

		/**
		 * Adds the given value to the end of the list.
		 *
		 * @param value
		 *            the value to add. If {@code value == null}, nothing happens.
		 */
		public void add(E value) {

			// If the value is null, nothing happens
			if (value == null) return;

			// How long is the list?
			int lastIndex = size()-1;

			// If there is nothing in the list...
			if (lastIndex == -1) {

				head = new ZeldaElement<E>();
				head.setValue(value);

				// If however there is sth in the list...
			} else {

				// ... get the last element of the list
				ZeldaElement<E> last = getElement(lastIndex);

				// make a new element to add
				ZeldaElement<E> v = new ZeldaElement<E>();
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
		public boolean remove(E value) {

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
			ZeldaElement<E> removeMe = getElement(index);

			// Get the element after the one to remove
			ZeldaElement<E> next = removeMe.getNextElement();

			// If you are to remove the first element...
			if (index == 0) {

				head = next;

				// ... Otherwise...
			} else {

				// Get the element before the one to remove
				ZeldaElement<E> prev = getElement(indexOf(value)-1);

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
		public boolean contains(E value) {

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
		public E get(int index) {

			// Is the index valid?
			if (index >= size() || index < 0) return null;

			// Get the element at index
			ZeldaElement<E> el = getElement(index);

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
		private ZeldaElement<E> getElement(int index) {

			// Is the list empty?
			if (isEmpty()) return null;

			// Is the index out of bounds?
			else if (index >= size() || index < 0) return null;

			ZeldaElement<E> curr = head;

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
		public int indexOf(E value) {

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
		private int indexOfRecurr(E value, ZeldaElement<E> el, int index) {

			// Get the value to compare against
			E val = el.getValue();

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

			ZeldaElement<E> next = head.getNextElement();

			while (next != null) {

				count++;

				next = next.getNextElement();

			}

			return count;

		}

	}

	/**
	 * A linked list element that stores a value and a link to the next element, if
	 * any.
	 *
	 * @param <E>
	 *            data type of the value that can be stored in this element.
	 */
	class ZeldaElement<E> {

		/** The vaue this element holds. */
		private E value = null;
		/** Link to the next element. */
		private ZeldaElement<E> nextElement = null;

		/**
		 * Returns the value this element holds.
		 *
		 * @return the value.
		 */
		public E getValue() {
			return value;
		}

		/**
		 * Sets the value this element holds.
		 *
		 * @param value
		 *            the new value.
		 */
		public void setValue(E value) {
			this.value = value;
		}

		/**
		 * Returns the link to the next element, if any.
		 *
		 * @return link to the next element, or {@code null} if there is no next
		 *         element.
		 */
		public ZeldaElement<E> getNextElement() {
			return nextElement;
		}

		/**
		 * Sets the next element.
		 *
		 * @param nextElement
		 *            the new next element.
		 */
		public void setNextElement(ZeldaElement<E> nextElement) {
			this.nextElement = nextElement;
		}

	}



	private ZeldaList<E> collection = new ZeldaList<E>();

	@Override
	public boolean add(E element) {

		if (element == null) throw new NullPointerException();

		if (contains(element)) return false;

		collection.add(element);

		return true;

	}

	@Override
	public boolean remove(E element) {

		if (element == null) throw new NullPointerException();

		return collection.remove(element);

	}

	@Override
	public boolean contains(E element) {

		if (element == null) throw new NullPointerException();

		return collection.contains(element);

	}

	@Override
	public void clear() {

		collection.clear();

	}

	@Override
	public int size() {

		return collection.size();

	}

}

