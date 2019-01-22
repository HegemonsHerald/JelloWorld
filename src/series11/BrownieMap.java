//  package series11;

// package programming.set11.brownies;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Vector;

/**
 * A hash baked tray of cookies.
 *
 * @param <K>	Ok ok oh K.
 *
 * @param <V>	voooooodoooooooo
 */
public class BrownieMap<K, V> {

	// Used for modulo operation, also the number of buckets to use
	private int Divisor;

	// These boots are made for walking, an one day, these boots are gonna -- BUUUCKEET!
	private ArrayList<Vector<Pair>> Buckets;

	/**
	 * Lil' helper, cause having pseudo tuples is still better than having no tuples at all.
	 */
	private class Pair {

		/**
		 * Hmmmmm.
		 *
		 * @param a	First component
		 *
		 * @param b	Second component
		 */
		public Pair(K a, V b) {
			this.a = a;
			this.b = b;
		}

		public K a;
		public V b;

	}

	/**
	 * BrownieMap.
	 *
	 * @param numberOfBuckets	A value for numberOfBuckets
	 *
	 * @throws IllegalArgumentException	This method might throw an IllegalArgumentException, if the {@code numberOfBuckets } is smaller than 1.
	 */
	public BrownieMap(int numberOfBuckets) {

		// Yup.
		if (numberOfBuckets < 1) throw new IllegalArgumentException();

		Divisor = numberOfBuckets;

		// Initialize all the buckets
		Buckets = new ArrayList<Vector<Pair>>();
		for (int i = 0; i < Divisor; i++) {
			Buckets.add(new Vector<Pair>());
		}

	}

	/**
	 * Put a thing into the hashmap.
	 *
	 * @param key  	the key for the thing
	 *
	 * @param value	the thing
	 *
	 * @throws IllegalArgumentException	if you confuse keys and values with null pointers you shall be scalded
	 */
	public void put(K key, V value) {

		// Hmmm yes.
		if (key == null || value == null) throw new IllegalArgumentException();

		// The object to put in the bucket
		Pair p = new Pair(key, value);

		// First try to get the thing to put, and kick it out, if it's already there
		V k = get(key);
		if (k != null) remove(key);

		// Get the bucket to put it in
		int hash = key.hashCode();
		int modh = Math.abs(hash) % Divisor;
		Vector<Pair> bucket = Buckets.get(modh);

		// Put it in the bucket
		bucket.add(p);

	}

	/**
	 * Gets you a thing from a key.
	 *
	 * @param key	the key for hte thing
	 *
	 * @throws IllegalArgumentException	what happens when you're dumb
	 *
	 * @return   	the value
	 */
	public V get(K key) {

		// Hmmmm.
		if (key == null) throw new IllegalArgumentException();

		// Get the bucket the key's Pair should be in
		int hash = key.hashCode();
		int modh = Math.abs(hash) % Divisor;
		Vector<Pair> bucket = Buckets.get(modh);

		// Find the actual Pair
		Pair p = null;
		for (Pair pp : bucket) {
			if (pp.a.equals(key)) p = pp; 
		}

		// If you didn't find it...
		if (p == null) return null;

		// If you found it, return the value field
		return p.b;

	}

	/**
	 * Get rid of that sh*t.
	 *
	 * @param key	id that bastard
	 *
	 * @throws IllegalArgumentException	don't screwy my id-ewy
	 */
	public void remove(K key) {

		// Duh.
		if (key == null) throw new IllegalArgumentException();

		V value = get(key);

		// If there's no value, then the key wasn't in any of the
		// Buckets, so there's nothing to remove
		if (value == null) return;

		// Rebuild the Object to remove...
		Pair p = new Pair(key, value);

		for (int i = 0; i < Divisor; i++) {

			Vector<Pair> v = Buckets.get(i);

			for (int j = 0; j < v.size(); j++) {

				Pair pp = v.get(j);
				if (pp.a.equals(key)) v.remove(pp);

			}

		}

		assert get(key) == null : "didn't remove";

	}

	/**
	 * Get rid of all the sh*t.
	 */
	public void clear() {

		for (Vector<Pair> v : Buckets) {

			v.removeAllElements();

		}

	}

}
