package series12;

// package programming.set12.exceptions;

/**
 * ExHandler {.
 */
public class ExHandler {

	/**
	 * Calculate.
	 *
	 * @param provider	A value for provider
	 *
	 * @throws OhNoException	This method might throw a OhNoException
	 *
	 * @throws Exception	This method might throw a Exception
	 */
	public void calculate(InputOutputProvider provider) throws Exception, OhNoException {

		while (true) {

			// read and verify operator
			String op = provider.readLine();
			if (op == null) {
				break;
			} else if (!op.matches("\\+|-|\\*|/|%")) {
				throw new OhNoException(op);
			}

			// read and parse operands
			double a,b;
			try {
				a = Double.parseDouble(provider.readLine());
				b = Double.parseDouble(provider.readLine());
			} catch (NullPointerException d) {
				throw d;
			} catch (Exception d) {
				throw new Exception(d);
			}

			// operate and print
			if (false) {/* I literally only did this to make the ones below aligned, cause fuck me, no match expression */}
			else if (op.equals("+")) provider.printLine("" + (a + b));
			else if (op.equals("-")) provider.printLine("" + (a - b));
			else if (op.equals("*")) provider.printLine("" + (a * b));
			else if (op.equals("/")) provider.printLine("" + (a / b));
			else if (op.equals("%")) provider.printLine("" + (a % b));

		}

	}

}

/**
 * OhNoException extends Exception implements OperatorException {.
 * It would seem my regex for generating class things doesn't really deal well with extends AND implements AND no public and whatnot.
 */
class OhNoException extends Exception implements OperatorException {

	private String op;

	/**
	 * OhNoException.
	 *
	 * @param s	A value for s
	 */
	public OhNoException(String s) {
		op = s;
	}

	/**
	 * GetInvalidOperator.
	 *
	 * @return 	The method returns a value of type String
	 */
	public String getInvalidOperator() {
		return op;
	}

}
