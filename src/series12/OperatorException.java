package series12;
/**
 * Interface implemented by an exception thrown if the user fails to enter a
 * valid operator.
 */
public interface OperatorException {

	/**
	 * The invalid operator entered instead of a valid one.
	 *
	 * @return the invalid operator.
	 */
	String getInvalidOperator();

}
