package series10;

// package programming.set10.histogram;

import java.util.HashMap;

/** WordHistogram. */
public class WordHistogram {

	public HashMap<String,Integer> histogram = new HashMap<String,Integer>();

	/**
	 * WordHistogram. yeah, well itg does the nting.
	 *
	 * @param str	A value for str
	 */
	public WordHistogram(String str) {

		String phrase  = str.toUpperCase();
		String words[] = phrase.split(" ");

		for (int i = 0; i < words.length; i++) {

			String word = words[i];

			// if the word has already been visited, don't bother
			if (histogram.get(word) != null) continue;

			// how often a word appeared in str, appears at least once
			int occurences = 1;

			// count occurences, starts counting at the word after this word
			for (int j = i+1; j < words.length; j++) {

				if (word.equals(words[j])) occurences++;

			}

			// add occurences to hashmap.
			histogram.put(word, occurences);

		}

	}

	/**
	 * Returns the number of times the given word appears in the text. The results
	 * should ignore case, that is, the Text "The tHe thE" contains the string "THE"
	 * three times.
	 *
	 * @param word the word to look for.
	 * @return the number of times the word occurs in the text, ignoring case.
	 * @throws IllegalArgumentException if {@code word == null}.
	 */
	public int getOccurrences(String word) {

		if (word == null) throw new IllegalArgumentException();

		Integer occ = histogram.get(word.toUpperCase());

		if (occ == null) return 0;

		return occ;

	}


}
