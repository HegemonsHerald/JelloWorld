package series9;

import java.util.List;

public class LinkListerPlayground {

	public static void main(String args[]) {

		String markdown = "hohoho htis is tsome text yaeasljk sdl;jfa.,d.,sdf;he w\nan \nsldkjf \n [desc](https://a.website) ldskjf s ldfj[desc desc](http://www.w..w...w.html) \nsldkjf SLDKJ \nsldkfj";

		System.out.println(markdown);
		System.out.println("");
		System.out.println("============================================================");
		System.out.println("");

		List<Link> links = LinkLister.extractLinks(markdown);

		for (Link l : links) {

			System.out.println(l);

		}
	}

}
