package series9;
public class DNAMatcherMini {
	public static boolean isValid(String dna) {
		if (dna == null || dna.equals("")) return false;
		for (char c : dna.toCharArray()) {
			if (!"ACGT".contains(""+c)) return false;
		}
		return true;
	}
	public static int findFirstBindingPosition(String baseDNA, String candidateDNA) {
		if (!isValid(candidateDNA) || !isValid(baseDNA) || candidateDNA.length() > baseDNA.length()) throw new IllegalArgumentException();
		String candidate = candidateDNA;
		candidate = candidate.replaceAll("A", "X");
		candidate = candidate.replaceAll("C", "Y");
		candidate = candidate.replaceAll("G", "C");
		candidate = candidate.replaceAll("T", "A");
		candidate = candidate.replaceAll("X", "T");
		candidate = candidate.replaceAll("Y", "G");
		candidate = candidate.replaceAll("Y", "G");
		char[] candidateChars = candidate.toCharArray();
		char firstCandidate = candidate.charAt(0);
		for (int i = 0; i <= (baseDNA.length() - candidate.length()); i++) {
			if (baseDNA.charAt(i) == firstCandidate && baseDNA.length() - i >= candidate.length()) {
				String possibleMatch = baseDNA.substring(i, i + candidate.length());
				if (possibleMatch.equals(candidate)) {
					return i;
				} } }
		return -1;
	}
}
