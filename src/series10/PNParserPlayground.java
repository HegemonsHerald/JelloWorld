package series10;

public class PNParserPlayground {

	public static void main(String args[]) {

		// String s = "+ * + 1 2 + 3 4 5";
		String s = "* 6 * + 3 + 3 + 2 * + 0 * 3 + 6 7 4 1";
		PNParser p = new PNParser(s);
		System.out.println(p.getInfixRepresentation());
		
//		String s1 = "+ + 1 2 + 3 4 5";
//		PNParser p1 = new PNParser(s1);
//		System.out.println(p1.getInfixRepresentation());

		String s2 = "+ * + 1 + 3 4 5";
		PNParser p2 = new PNParser(s2);
		System.out.println(p2.getInfixRepresentation());
	}

}
