package series6;

import series6.FunctionArea;

public class FunctionAreaTest {
	/** main.
	 * @param args[]	Here something useful about {@code args[]}.
	 */
	public static void main(String args[]) {
		FunctionArea obj = new FunctionArea();
		System.out.println(obj.approxFunctionArea(-1.0, 0.0, 0.2));
		System.out.println(obj.approxFunctionArea(-1.0, 0.0, 0.3));
		System.out.println(obj.approxFunctionArea(1.0, 4.0, 1.0));
		System.out.println(obj.approxFunctionArea(1.0, 4.0, 0.2));
	}
}
