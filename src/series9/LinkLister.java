package series9;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/** LinkLister. */
public class LinkLister {

	/**
	 * Extracts all links from the given Markdown-formatted String and returns them
	 * in a handy list.
	 *
	 * @param markdown a Markdown-formatted String.
	 * @return possibly empty list of links in the order they appeared in the text.
	 */
	public static List<Link> extractLinks(String markdown) {

		// Where to put stuff
		ArrayList<String> linkStrings = new ArrayList<String>();
		ArrayList<Link>   links       = new ArrayList<Link>();

		// Get lines!
		String lines[] = markdown.split("\n");

		// From each line...
		for (String line : lines) {

			// ... get all the links
			String linksFromLine[] = line.split("\\[");

			// ... for each link...
			for (String link : linksFromLine) {

				// ... if it's actually a link
				if (link.matches(".*\\]\\(.*\\).*")) linkStrings.add(link);

			}

		}

		// Now remove all the non-link parts from the links,
		// and build up the list of Links, they want
		for (String l : linkStrings) {

			/* split the link into its parts */

			String desc = new String(l);
			String link = new String(l);

			// delete everything after the ]
			desc = desc.replaceAll("\\].*", "");

			// delete everything before and including the (
			link = link.replaceAll(".*\\]\\(", "");

			// delete everything after and including the )
			link = link.replaceAll("\\).*", "");

			// add the new link to the link-list
			links.add(new Link(desc, link));


			// So right, apparently I HAVE to use replaceAll or replaceFirst, I can't just go replace, cause replace is only for single chars.
			// What bollocks!

			// Also, the capture groups just don't work. Like at all.

		}

		return links;

	}
}
