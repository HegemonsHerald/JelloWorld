package series9;

// programming.set9.markdown;

import java.util.ArrayList;
import java.util.List;

/** LinkLister. */
public class LinkLister {


	// Matches against a link
	private static final String REGEX_BASE = "\\[([^ \\[\\]]|[^ \\[\\]][^\\[\\]]*[^ \\[\\]])\\]\\([^ ()]*\\)";

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
		ArrayList<Link> links = new ArrayList<Link>();

		// Get lines!
		String lines[] = markdown.split("\n");

		// From each line...
		for (String line : lines) {

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

			}

		}

		return links;

	}
}
