package series11;
public interface XYSet<E> {
	boolean add(E element);
	boolean remove(E element);
	boolean contains(E element);
	void clear();
	int size();
}
