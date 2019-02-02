package series12;
import java.util.Iterator;

public class ZEPL {

	public static void main(String args[]) {

		ZeldaList<String> zz = new ZeldaList<String>();

		zz.add("Honkers");
		zz.add("Bonkers");
		zz.add("Lemon");
		zz.add("Squonkers");

		Iterator<String> ll = zz.iterator();

		System.out.println(ll.next() + " " + ll.hasNext());
		System.out.println(ll.next() + " " + ll.hasNext());
		System.out.println(ll.next() + " " + ll.hasNext());
		System.out.println(ll.next() + " " + ll.hasNext());

		Iterator<String> i = zz.iterator();
		while (i.hasNext()) {

			System.out.println(i.next());

		}

	}

}
