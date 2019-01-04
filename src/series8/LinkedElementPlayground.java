package series8;

public class LinkedElementPlayground {

	public static void main(String args[]) {

		// An unrealistic example
		LinkedElement<String> headElement = new LinkedElement<String>("Yo!");
		headElement.add("Kiel");
		headElement.add("is");
		headElement.add("about");
		headElement.add("to");
		headElement.add("witness");
		headElement.add("another");
		headElement.add("sunny");
		headElement.add("day!");

		System.out.println(headElement.get(7));	// prints "sunny"
		headElement = headElement.remove(6);	// removes "another"
		headElement = headElement.remove(0);	// removes "Yo!"
		System.out.println(headElement.get(5));	// prints "sunny"

	}

}
