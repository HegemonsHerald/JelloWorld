// package series11;

public class BrownieMapPLayground {

	public static void main(String args[]) {

		BrownieMap<String, Integer> m1 = new BrownieMap<String, Integer>(10);

		m1.put("k", 42);
		m1.put("k", 34);
		m1.remove("k");

		assert m1.get("k") == null : "didn't remove the thing" + m1.get("k");

		BrownieMap<Integer, Integer> m2 = new BrownieMap<Integer, Integer>(10);

		m2.put(0,12);
		m2.put(1,12);
		m2.put(2,12);
		m2.clear();

		assert m2.get(0) == null : "didn't clear properly";

		m2.put(17,17);
		m2.remove(17);

		assert m2.get(17) == null : "didn't remove properly" + m2.get(17);

	}

}
