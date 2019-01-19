package series9;

import java.util.List;

public class LinkListerPlayground {

	public static void main(String args[]) {

<<<<<<< Updated upstream
		String markdown = "This Jen is [The internet](https://www.youtube.com/watch?v=iDbyYGrswtg). - What?\n [https://www.youtube.com/watch?v=iDbyYGrswtg](https://www.youtube.com/watch?v=iDbyYGrswtg)\n [Road To Nowhere]()\n [The internet](https://www.youtube.com/watch?v=iDbyYGrswtg)\n [](https://www.youtube.com/watch?v=ZbdMMI6ty0o)\n [The internet](https://www.youtube.com/watch?v=iDbyYGrswtg)\n [iLearn](https://ilearn.ps.informatik.uni-kiel.de/) is a learning portal for stundents of the CAU Kiel.\n [xkcd](https://xkcd.com/)\n [Nein Doch Org](http://neindoch.org/)[Road To Nowhere](https://www.youtube.com/watch?v=LQiOA7euaYA)\n After all this years, this webcomic still brings me joy: [xkcd](https://xkcd.com/)\n [Doch reicht nicht als Antwort ](http://neindoch.org/)\n [ Nein das solltest du nicht ausgeben](http://neindoch.org/)\n [iLearn](https://ilearn.ps.informatik.uni-kiel.de/) is a learning portal for stundents of the CAU Kiel.\n  [This Jen is] The internet](https://www.youtube.com/watch?v=iDbyYGrswtg). - What?\n [Nein Doch Org](http://nein doch.org/)";
=======
		String markdown = "[desc](sth) [desc](sth)[desc](\nsth)hohoho htis is tsome text yaeasljk sdl;jfa.,d.,sdf;he w\nan \nsldkjf \n [desc](https://a.website) \n [  descfalsy](sldkfj) [descf ](sldkf) [desc]( sldkfjlsdkjf) [desc](falsy ) ldskjf s ldfj[desc desc](http://www.w..w...w.html) \nsldkjf SLDKJ \nsldkfj";

		/*
		 * REWRITE:
		 * actually do teh thing of splitting into lines
		 * and then splitting into string-per-link again
		 * so that you don't have to use complex regex...

		String string = "if (yankee) while  [sth sth](sthelse)(stanky)";

		System.out.println(string);

		System.out.println(string.matches(".*\\[[^\\[\\]]*[^ \\[\\]]\\].*"));
		System.out.println(string.matches(".*\\[[^ \\[\\]][^\\[\\]]*\\]\\([^ \\(\\)]+\\).*"));
		System.out.println(string.replaceAll(".*\\[([^ \\[\\]][^\\[\\]]*)\\]\\(([^ \\(\\)]+)\\).*", "$1		$2"));

		string = string.replaceAll("if \\(([^)]*)\\) while .*", "$1");

		System.out.println(string);



		System.out.println(markdown);
		System.out.println("");
		System.out.println("============================================================");
		System.out.println("");
>>>>>>> Stashed changes

		List<Link> links = LinkLister.extractLinks(markdown);

		for (Link l : links) {

			System.out.println(l);

		}

		List<Link> links2 = LinkLister.extractLinks("");
		List<Link> links3 = LinkLister.extractLinks(null);

		for (Link l : links2) {

			System.out.println("empty string: " + l);

		}

		for (Link l : links3) {

			System.out.println("null string: " + l);

		}

	}

}
