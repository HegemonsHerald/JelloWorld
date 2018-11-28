package series5;

/**
 * NAME.
 */
public class honk {

	/** is this javadoc? */
	public class TonyHawk {}

	public static void main(String[] args) {


		// Ok, so this yields NaN, but you really shouldn't use that!
		float flonk = (float) 0 / (float) 0;
		System.out.println(flonk);
		System.out.println(42 * flonk);


		// Example of a local class
		honk tonk = new honk(); // you need an instance the enclosing class of TonyHawk...
		TonyHawk timmy = tonk.new TonyHawk(); // ... to make an instance of TonyHawk

	}

}
