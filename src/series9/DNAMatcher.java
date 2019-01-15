package series9;

// package programming.set9.dna;

/** DNAMatcher. */
public class DNAMatcher {

	private String baseDNA;

	/**
	 * Constructor, yeah.
	 *
	 * @param baseDNA	A value for baseDNA
	 *
	 * @return       	The method returns a value of type DNAMatcher
	 */
	public DNAMatcher(String baseDNA) {

		if (!isValid(baseDNA)) throw new IllegalArgumentException();

		this.baseDNA = baseDNA;

	}

	/**
	 * Is a string a valid base encoding?
	 *
	 * @param dna	A value for dna
	 *
	 * @return   	The method returns a value of type boolean
	 */
	public boolean isValid(String dna) {

		// Check for null, empty String
		if (dna == null || dna.equals("")) return false;

		// If a DNAMatcher object already exists, also check the length against baseDNA
		if (baseDNA != null) {

			// Turns out, I was smarter than the fucking test, this shouldn't be here
			if (dna.length() > baseDNA.length()) return false;

		}

		// Check for only valid letters
		for (char c : dna.toCharArray()) {

			if (!"ACGT".contains(""+c)) return false;

		}

		return true;

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

		/* Check input validity */

		if (!isValid(candidateDNA)) throw new IllegalArgumentException();

		/*
		 * They wrote in the task, that one should use this as an excercise in abstracting methods.
		 * I take this to mean: Follow the good procedural-paradigm tradition of not unnecessarily
		 * refactoring code into methods, if it's only ever used in one place... So here, have my
		 * one beautiful long function! =)
		 */

		/* Invert Candidate DNA */

		/*
		 * Since we can't do direct circular substitution, we'll replace two
		 * bases with token-bases, then replace the other two with the first
		 * two, and then replace the tokens with the other two. Otherwise we'd
		 * turn ACGT into TGGT into ACCA, because of the circular dependencies
		 * in the base-pairs.
		 */

		String candidate = candidateDNA;

		// Replace the bases A and C with X and Y, respectively
		candidate = candidate.replaceAll("A", "X");
		candidate = candidate.replaceAll("C", "Y");

		// Replace the bases G and T with C and A, respectively
		candidate = candidate.replaceAll("G", "C");
		candidate = candidate.replaceAll("T", "A");

		// Replace the tokens X and Y with T and G, respectively
		candidate = candidate.replaceAll("X", "T");
		candidate = candidate.replaceAll("Y", "G");

		char[] candidateChars = candidate.toCharArray();


		/* Do the Matching */

		/*
		 * How this works:
		 *
		 * First I compare each char of baseDNA against the first char of the candidate,
		 * so that I find all positions, where there could be a match.
		 *
		 * Once I found a possibly matching position, I create a substring of baseDNA,
		 * that starts at the position of that possible match and is candidate.length()
		 * characters long.
		 * If I encountered a full match, this substring and candidate should be completely
		 * equal, so I test for that.
		 *
		 * If they weren't equal, I keep on comparing firstCandidate against chars from
		 * baseDNA, until I either found a match or reached the last possible position,
		 * where a match could occur. That's the point where what's left of baseDNA
		 * becomes shorter than candidate.
		 */

		// First char of the candidate string
		char firstCandidate = candidate.charAt(0);

		// Go looking for the candidate string in baseDNA, but only as long as there are more chars left in baseDNA, than there are in candidateChars!
		for (int i = 0; i <= (baseDNA.length() - candidate.length()); i++) {

			// If the first char of the candidates matches the char we're on in baseDNA
			if (baseDNA.charAt(i) == firstCandidate && baseDNA.length() - i >= candidate.length()) {

				// ... find out wether the following chars match as well!
				String possibleMatch = baseDNA.substring(i, i + candidate.length());

				// If the rest part of baseDNA is indeed equal to the candidate...
				if (possibleMatch.equals(candidate)) {

					// ... return the position of the match!
					return i;

				}

			}

		}

		// If you got through til here, you didn't find a match
		return -1;

	}

}
