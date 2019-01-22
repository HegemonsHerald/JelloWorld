package series11;

import series9.ZeldaList;
// import programming.set9.zelda.ZeldaList;

/**
 * Yup dis a list set thingy bajigny.
 *
 * @param <E>	Type of dem elements
 */
public class ExcellentXYSet<E> implements XYSet<E> {

	private ZeldaList<E> collection = new ZeldaList<E>();

	@Override
	public boolean add(E element) {

		if (element == null) throw new IllegalArgumentException();

		if (contains(element)) return false;

		collection.add(element);

		return true;

	}

	@Override
	public boolean remove(E element) {

		if (element == null) throw new IllegalArgumentException();

		return collection.remove(element);

	}

	@Override
	public boolean contains(E element) {

		if (element == null) throw new IllegalArgumentException();

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

