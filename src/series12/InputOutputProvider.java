package series12;

/**
 * Classes implementing this interface provide access to input and output.
 */
public interface InputOutputProvider {

	/**
	 * Reads and returns a line of input, without trailing newline characters.
	 *
	 * @return a line of input.
	 */
	String readLine();

	/**
	 * Outputs a line of output.
	 *
	 * @param line
	 *            the line to output.
	 */
	void printLine(String line);
}
