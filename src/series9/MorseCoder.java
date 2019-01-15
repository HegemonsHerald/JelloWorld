package series9;

// package programming.set9.morses;

import java.util.ArrayList;
import java.util.Arrays;

/** MorseCode. */
public class MorseCoder {

	/* The Morse Code Regular CHARACTERS. */
	private static final String REGULARS_ARRAY[]    = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private static final ArrayList<String> REGULARS = new ArrayList<String>( Arrays.asList(REGULARS_ARRAY) );

	/* The Morse Code CODEs. */
	private static final String CODES_ARRAY[]       = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };
	private static final ArrayList<String> CODE     = new ArrayList<String>( Arrays.asList(CODES_ARRAY) );


	/**
	 * Returns a new string which is the Morse code version of the input string.
	 * Each word in the output will be on a separate line. The Morse representation
	 * of each character of the input string is separated from the next by a space
	 * character in the output string.
	 *
	 * @param input the input string.
	 * @return the Morse code version of the input string, ignoring all characters
	 *         in the input string that cannot be represented in international Morse
	 *         code.
	 */
	public static String encode(String input) {

		// Split into words, split on spaces
		String words[] = input.split(" ");

		// Where to accumulate the encoding to
		String output = "";

		// For each word...
		for (String word : words) {

			// Get just the letters
			char wordChars[] = word.toUpperCase().toCharArray();

			// ... encode each letter...
			for (char l : wordChars) {

				// Lookup the right code
				int indexOfCode = REGULARS.indexOf(""+l);

				// If the lookup was successfull...
				if (indexOfCode > -1) {

					// ... add the code to the encoded string and add a space to delimit the codes
					output = output + CODE.get(indexOfCode) + " ";

				}

			}

			// Add a newline to delimit the words
			output = output + "\n";

		}

		return output;
	}

	/**
	 * Returns a new string which is the natural-language version of the input
	 * string, which is assumed to be in Morse code format as produced by the encode
	 * method.
	 *
	 * @param input morse code input string.
	 * @return natural language version or {@code null} if the input string could
	 *         not be properly parsed.
	 */
	public static String decode(String input) {

		// Split into words, split on newlines
		String words[] = input.split("\n");

		// Where to put the decoded business
		String decoded = "";

		// For each word...
		for (String word : words) {

			// ... split into morse code code elements
			String codes[] = word.split(" +");

			// Decode each morse code element
			for (String code : codes) {

				// Lookup the right regular string
				int indexOfRegular = CODE.indexOf(code);

				// If the lookup was successfull...
				if (indexOfRegular > -1) {

					// ... add it to the decoded string
					decoded = decoded + REGULARS.get(indexOfRegular);

				// Otherwise the input couldn't be properly decoded
				} else {

					return null;

				}

			}

			// Add a space to delimit the words
			decoded = decoded + " ";

		}

		return decoded;
	}

}
