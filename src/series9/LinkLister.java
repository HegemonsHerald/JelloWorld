package series9;

// package programming.set9.markdown;

import java.util.ArrayList;
import java.util.List;

/** LinkLister. */
public class LinkLister {


	// Matches against a link
	private static final String REGEX_BASE = "\\[([^ \\[\\]]|[^ \\[\\]][^\\[\\]]*[^ \\[\\]])\\]\\([^ ()]+\\)";

	// Matches against a line containing a link
	private static final String REGEX_FULL = ".*" + REGEX_BASE + ".*";

	// Captures the first link, so it can be removed
	private static final String REGEX_SBST = "(" + REGEX_BASE + ")";

	// Captures the first link and everything after it, so everything after it can be removed
	private static final String REGEX_FRST = "(" + REGEX_BASE + ").*";

	// Captures the first link and everything before it, so everything before it can be removed
	private static final String REGEX_LAST = "[^\\[]*(" + REGEX_BASE + ")";

	// Captures the description of the link
	private static final String REGEX_DESC = "\\[([^\\[\\]]+)\\]\\([^\\(\\)]*\\)";

	// Caputres the link of the link
	private static final String REGEX_LINK = "\\[[^\\[\\]]+\\]\\(([^\\(\\)]*)\\)";

	/**
	 * Extracts all links from the given Markdown-formatted String and returns them
	 * in a handy list.
	 *
	 * @param markdown a Markdown-formatted String.
	 * @return possibly empty list of links in the order they appeared in the text.
	 */
	public static List<Link> extractLinks(String markdown) {

		// Where to put stuff
<<<<<<< Updated upstream
		ArrayList<Link> links = new ArrayList<Link>();

		if (markdown == null || markdown.equals("")) return links;
=======
		ArrayList<String> validLines  = new ArrayList<String>();
		ArrayList<String> linkStrings = new ArrayList<String>();
		ArrayList<Link>   links       = new ArrayList<Link>();
>>>>>>> Stashed changes

		// Get lines!
		String lines[] = markdown.split("\n");

		// For each line, check that it contains a valid link
		for (String line : lines) {

<<<<<<< Updated upstream
			while (line.matches(REGEX_FULL)) {

				// Get the first line
				String l = line.replaceFirst(REGEX_FRST, "$1");
				l	 = l.replaceFirst(REGEX_LAST, "$1");

				// Get desc and line
				String desc = l.replaceFirst(REGEX_DESC, "$1");
				String link = l.replaceFirst(REGEX_LINK, "$1");

				// Add to the lines
				links.add(new Link(desc, link));

				// Remove it from the source line, for the next iteration (there might be multiple lines)
				line = line.replaceFirst(REGEX_SBST, "");
=======
			// If the link doesn't have a space after the '['
			// doesn't contain any '[]' in the description,
			// matches '](',
			// doesn't have any spaces or '()' in the link...
			while (line.matches(".*\\[[^ \\[\\]][^\\[\\]]*\\]\\([^ \\(\\)]+\\).*")) {

				// ... get the link candidate's description
				String desc = line.replaceFirst(".*\\[([^ \\[\\]][^\\[\\]]*)\\]\\([^ \\(\\)]+\\).*", "$1");

				// ... check that it doesn't have a space before the ']'
				if (desc.matches(".*[^ ]")) {

					// It doesn't, so this thing must be a valid link.

					// Get the address
					String addr = line.replaceFirst(".*\\[[^ \\[\\]][^\\[\\]]*\\]\\(([^ \\(\\)]+)\\).*", "$1");
					
					// Make a link of them and add it to the output
					links.add(new Link(desc, addr));

				}

				// Try again, until there are no links left in the line!
				// By removing the link(-candidate) we just dealt with
				line = line.replaceFirst("\\[[^ \\[\\]][^\\[\\]]*\\]\\([^ \\(\\)]+\\)", "");
>>>>>>> Stashed changes

			}

		}

		return links;

	}
}
