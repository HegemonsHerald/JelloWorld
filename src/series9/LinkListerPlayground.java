package series9;

import java.util.List;

public class LinkListerPlayground {

	public static void main(String args[]) {

		String markdown = "This Jen is [The internet](https://www.youtube.com/watch?v=iDbyYGrswtg). - What?\n [https://www.youtube.com/watch?v=iDbyYGrswtg](https://www.youtube.com/watch?v=iDbyYGrswtg)\n [Road To Nowhere]()\n [The internet](https://www.youtube.com/watch?v=iDbyYGrswtg)\n [](https://www.youtube.com/watch?v=ZbdMMI6ty0o)\n [The internet](https://www.youtube.com/watch?v=iDbyYGrswtg)\n [iLearn](https://ilearn.ps.informatik.uni-kiel.de/) is a learning portal for stundents of the CAU Kiel.\n [xkcd](https://xkcd.com/)\n [Nein Doch Org](http://neindoch.org/)[Road To Nowhere](https://www.youtube.com/watch?v=LQiOA7euaYA)\n After all this years, this webcomic still brings me joy: [xkcd](https://xkcd.com/)\n [Doch reicht nicht als Antwort ](http://neindoch.org/)\n [ Nein das solltest du nicht ausgeben](http://neindoch.org/)\n [iLearn](https://ilearn.ps.informatik.uni-kiel.de/) is a learning portal for stundents of the CAU Kiel.\n  [This Jen is] The internet](https://www.youtube.com/watch?v=iDbyYGrswtg). - What?\n [Nein Doch Org](http://nein doch.org/)";

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
