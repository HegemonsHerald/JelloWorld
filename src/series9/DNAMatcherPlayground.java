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


		// Test the minified version

		// success
		System.out.println(DNAMatcherMini.findFirstBindingPosition("ATTCCTAATGTCAATT", "GATTACA"));
		// success
		System.out.println(DNAMatcherMini.findFirstBindingPosition("CTAAGGGGTCTCATATC", "CCCAGAGT"));
		try {
		System.out.println(DNAMatcherMini.findFirstBindingPosition("ATTCCTAATGTCAATT", ""));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg exc");
		}
		try {
		System.out.println(DNAMatcherMini.findFirstBindingPosition("", "GATTACA"));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg exc");
		}
		try {
		System.out.println(DNAMatcherMini.findFirstBindingPosition(null, "GATTACA"));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg exc");
		}
		try {
		System.out.println(DNAMatcherMini.findFirstBindingPosition("A", null));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg exc");
		}
		try {
		System.out.println(DNAMatcherMini.findFirstBindingPosition("AABB", "GATTACA"));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg exc");
		}
		try {
		System.out.println(DNAMatcherMini.findFirstBindingPosition("AA", "BBBB"));
		} catch (IllegalArgumentException e) {
			System.out.println("caught illegal arg exc");
		}

	}

}
