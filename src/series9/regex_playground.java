package series9;

public class regex_playground {

	public static void main(String args[]) {

		String ts0 = "honk";
		String ts1 = " sldkfj [valid](linke) [va klsdjflid](linke)";
		String ts2 = "[valid validyp](linke)";
		String ts3 = "[ invalid validyp](linke)";
		String ts4 = "[valid validyp ](linke)";
		String ts5 = "[ valid validyp ](linke)";
		String ts6 = "[valid validyp] (linke)";
		String ts7 = "[valid validyp] ( li lnk e)";
		String ts8 = "[valid validyp] (lil";
		String ts9 = "d validyp] (lil)";

		// Right, this one works
		String regex      = "\\[([^ \\[\\]]|[^ \\[\\]][^\\[\\]]*[^ \\[\\]])\\]\\([^ ()]*\\)";
		String regexAll   = ".*" + regex + ".*";

		// get everything before and including the first match
		String regexFirst = "(" + regex + ").*";

		// remove everything before the found first match
		String regexBefre = ".*(" + regex + ")";

		// remove the first match
		String regexSubst = "(" + regex + ")";

		// get just the description
		String desc = "\\[([^\\[\\]]+)\\]\\([^\\(\\)]*\\)";

		// get just the link
		String link = "\\[[^\\[\\]]+\\]\\(([^\\(\\)]*)\\)";

		/*
		System.out.println(ts0 + " matches regex: " + ts0.matches(regex));
		System.out.println(ts1 + " matches regex: " + ts1.matches(regex));
		System.out.println(ts2 + " matches regex: " + ts2.matches(regex));
		System.out.println(ts3 + " matches regex: " + ts3.matches(regex));
		System.out.println(ts4 + " matches regex: " + ts4.matches(regex));
		System.out.println(ts5 + " matches regex: " + ts5.matches(regex));
		System.out.println(ts6 + " matches regex: " + ts6.matches(regex));
		System.out.println(ts7 + " matches regex: " + ts7.matches(regex));
		System.out.println(ts8 + " matches regex: " + ts8.matches(regex));
		System.out.println(ts9 + " matches regex: " + ts9.matches(regex));
		*/

		String sb1  = ts1.replaceFirst(regexFirst, "$1");
		sb1         = sb1.replaceFirst(regexBefre, "$1");
		String d1   = sb1.replaceFirst(desc, "$1");
		String l1   = sb1.replaceFirst(link, "$1");

		String ts11 = ts1.replaceFirst(regexSubst, "").trim();

		String sb2  = ts11.replaceFirst(regexFirst, "$1");
		sb2         = sb2.replaceFirst(regexBefre, "$1");
		String d2   = sb2.replaceFirst(desc, "$1");
		String l2   = sb2.replaceFirst(link, "$1");

		System.out.println(sb1);
		System.out.println("   " + d1);
		System.out.println("   " + l1);
		System.out.println(sb2);
		System.out.println("   " + d2);
		System.out.println("   " + l2);

		/* Eclipse bindings
		 * c-r	run
		 * c-d	debug
		 * 	c-r	resume
		 * 	c-l	step over
		 * 	c-j	step into
		 * 	c-h	step return
		 * 	c-c	terminate
		 */

	}

}
