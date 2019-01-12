package series9;

/** DNAMatcher. */
public class DNAMatcher {

	private static final String BASE = "ACGT";

	private String baseDNA;

	/**
	 * Constructor, yeah.
	 *
	 * @param baseDNA	A value for baseDNA
	 *
	 * @return       	The method returns a value of type DNAMatcher
	 */
	public DNAMatcher(String baseDNA) {

		this.baseDNA = baseDNA;

	}


	/**
	 * Returns the index of the first position in the base DNA string where
	 * candidateDNA can bind, if any.
	 *
	 * @param candidateDNA
	 *            the DNA string to try to bind to the base DNA.
	 * @return index of the first binding position or {@code -1} if the candidate
	 *         DNA string cannot bind to the base string.
	 * @throws IllegalArgumentException
	 *             if {@code candidateDNA} is {@code null}, empty, or contains
	 *             characters other than A, C, G, and T.
	 */
	public int findFirstBindingPosition(String candidateDNA) {

		/*
		 * They wrote in the task, that one should use this as an excercise in abstracting methods.
		 * I take this to mean: Follow the good procedural-paradigm tradition of not unnecessarily
		 * refactoring code into methods, if it's only ever used in one place... So here, have my
		 * one beautiful long function! =)
		 */

		/* Check input validity */

		// Check for null, empty String and length
		if (candidateDNA == null || candidateDNA.equals("") || candidateDNA.length() > baseDNA.length()) throw new IllegalArgumentException();

		// Check for only valid letters
		for (char c : candidateDNA.toCharArray()) {

			// If the BASE doesn't contain a character from candidateDNA, it's invalid!
			if (!BASE.contains(""+c)) return -1;

		}


		/* Invert Candidate DNA */

		/*
		 * Since we can't do direct circular substitution, we'll replace two
		 * bases with token-bases, then replace the other two with the first
		 * two, and then replace the tokens with the other two. Otherwise we'd
		 * turn ACGT into TGGT into ACCA, because of the circular dependencies
		 * in the base-pairs.
		 */

		String matchCandidate = candidateDNA;

		// Replace the bases A and C with X and Y, respectively
		matchCandidate = matchCandidate.replaceAll("A", "X");
		matchCandidate = matchCandidate.replaceAll("C", "Y");

		// Replace the bases G and T with C and A, respectively
		matchCandidate = matchCandidate.replaceAll("G", "C");
		matchCandidate = matchCandidate.replaceAll("T", "A");

		// Replace the tokens X and Y with T and G, respectively
		matchCandidate = matchCandidate.replaceAll("X", "T");
		matchCandidate = matchCandidate.replaceAll("Y", "G");

		char[] matchChars = matchCandidate.toCharArray();


		/* Do the Matching */

		// Position of first match
		int position = -1;

		// Flag, whether the candidate matches or not
		boolean matches = false;

		// Current candidate char to match against baseDNA and the how many-th char of candidate that is
		int  matchCharCounter = 0;
		char matchChar        = matchChars[matchCharCounter];



		for (int i = 0; i < baseDNA.length(); i++) {

			// If there are less remaining chars in baseDNA, than there are in the candidate, the candidate can't match
			if ((baseDNA.length() - i) < (matchChars.length - matchCharCounter)) break;

			// If you found a match...
			if (baseDNA.charAt(i) == matchChar) {

				// If this is the first char, that matches
				if (!matches) {

					// Make position be the beginning of the match
					position = i;

					matches = true;

				}

				// Get the next char from the candidate to match against baseDNA, if there still are more
				if (++matchCharCounter < matchChars.length)
					matchChar = matchChars[matchCharCounter];
				// If you reached the end of the candidate, it matches completely!
				else return position;

				// Move on
				continue;

			} else {

				// There still is the possibility of a full match somewhere further in baseDNA

				// If you found a partial match, you need to...
				if (matches) {

					// ... reset
					matches          = false;
					position         = -1;
					matchCharCounter =  0;
					matchChar        = matchChars[matchCharCounter];


					// Also reset i... I know this looks bad, but it's necessary!
					--i;

					/*
					 * If you found a partial match, that's now broken, you need to double check the previous
					 * character, because patterns might overlap:
					 *
					 * Say you have
					 *
					 *   A T C C T T G
					 *
					 * as your baseDNA and you want to match
					 *
					 *   C T T G
					 *
					 * to it. Well, you start matching and you don't find a match for the A and the T from
					 * baseDNA, but then there's a C, and a match starts!
					 *
					 *   A T C C T T G
					 *   - - C ∙ ∙ ∙ ∙
					 *
					 * That match then immediately is stopped again, because the next matchChar is T and
					 * T doesn't match the second C of baseDNA.
					 *
					 *   A T C C T T G
					 *   - - C T ∙ ∙ ∙	✗
					 *
					 * So now you have to start matching baseDNA chars against C again, but you absolutely
					 * positively have to stay on the same i for a cycle, or you're going to restart matching
					 * C against the next letter of baseDNA, which is T. You'd skip the match.
					 *
					 * Skipping without resetting i:
					 *
					 *   A T C C T T G
					 *   - - - - C ∙ ∙
					 *
					 * You start matching like this, because the for-loop increases i by one and you skip
					 * matching the C against the C from baseDNA...
					 *
					 * With resetting i:
					 *
					 *   A T C C T T G
					 *   - - - C ∙ ∙ ∙
					 *
					 * And that's just what we want, another match begins!
					 */

				}

				// Move on
				continue;

			}
		}

		// If you got here, you didn't fully match the candidate
		return -1;
	}
}
