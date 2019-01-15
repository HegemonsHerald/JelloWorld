package series9;

public class ZeldaElementPlayground {

	public static void main(String args[]) {

		ZeldaList<Integer> z1 = new ZeldaList<Integer>();

		z1.add(42);	// 42
		z1.add(33);	// 42, 33
		z1.add(37);	// 42, 33, 37
		z1.add(null);	// 42, 33, 37
		z1.add(99);	// 42, 33, 37, 99

		System.out.println(z1.get(0));	// 42
		System.out.println(z1.get(1));	// 33
		System.out.println(z1.get(2));	// 37
		System.out.println(z1.get(3));	// 99

		System.out.println(z1.size());	// 4

		System.out.println(z1.remove(37));	// true; 42, 33, 99
		System.out.println(z1.remove(98877));	// false
		System.out.println(z1.remove(null));	// false

		System.out.println(z1.size());	// 3

		System.out.println(z1.get(0));	// 42
		System.out.println(z1.get(1));	// 33
		System.out.println(z1.get(2));	// 99

		System.out.println(z1.contains(42));		// true
		System.out.println(z1.contains(99));		// true
		System.out.println(z1.contains(888888));	// false
		System.out.println(z1.contains(null));		// false

		System.out.println(z1.indexOf(42));	// 0
		System.out.println(z1.indexOf(99));	// 2
		System.out.println(z1.indexOf(892374));	// -1 
		System.out.println(z1.indexOf(null));	// -1

		System.out.println(z1.isEmpty());	// false
		z1.clear();
		System.out.println(z1.isEmpty());	// true

		z1.add(420);

		System.out.println(z1.remove(420));

		z1.add(420);
		z1.add(330);	// 420, 330

		System.out.println(z1.remove(420));
		System.out.println(z1.get(0));

		z1.add(420);
		z1.add(420);

		System.out.println(z1.get(2));
		System.out.println(z1.remove(420));
		System.out.println(z1.get(0));
		System.out.println(z1.get(1));
		System.out.println(z1.size());

		z1.add(null);

	}

}
