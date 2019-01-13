package series9;

public class DNAMatcherPlayground {

	public static void main(String args[]) {

		DNAMatcher d1 = new DNAMatcher("ATTCCTAATGTCAATT");
		DNAMatcher d2 = new DNAMatcher("CTAAGGGGTCTCATATC");

		// can't create bad dna
		try {
			DNAMatcher d3 = new DNAMatcher("ABCD");
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg on Bad baseDNA");
		}

		// matches test string
		System.out.println(d1.findFirstBindingPosition("GATTACA"));
		System.out.println(d2.findFirstBindingPosition("CCCAGAGT"));

		// finds empty string
		try {
			System.out.println(d1.findFirstBindingPosition(""));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg on \"\"");
		}

		// finds null
		try {
			System.out.println(d1.findFirstBindingPosition(null));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg on null");
		}

		// finds invalid chars
		try {
			System.out.println(d1.findFirstBindingPosition("{|=BCA-]"));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg on {|=BCA-]");
		}

		// finds too long
		try {
			System.out.println(d1.findFirstBindingPosition("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg on AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		}

		// doesn't find not-matching string
		System.out.println(d1.findFirstBindingPosition("GATTC"));

	}

}
