package series9;

public class DNAMatcherPlayground {

	public static void main(String args[]) {

		DNAMatcher d1 = new DNAMatcher("ATTCCTAATGTCAATT");
		DNAMatcher d2 = new DNAMatcher("CTAAGGGGTCTCATATC");

		// matches test string
		//System.out.println(d1.findFirstBindingPosition("GATTACA"));
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
		System.out.println(d1.findFirstBindingPosition("{|=BCA-]"));

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
