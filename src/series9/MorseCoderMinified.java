package series9;
import java.util.ArrayList;
import java.util.Arrays;
public class MorseCoderMinified {
	private static final String REGULARS_ARRAY[]    = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private static final ArrayList<String> REGULARS = new ArrayList<String>( Arrays.asList(REGULARS_ARRAY) );
	private static final String CODES_ARRAY[]       = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----." };
	private static final ArrayList<String> CODE     = new ArrayList<String>( Arrays.asList(CODES_ARRAY) );
	public static String encode(String input) {
		String words[] = input.split(" ");
		String output = "";
		for (String word : words) {
			char wordChars[] = word.toUpperCase().toCharArray();
			for (char l : wordChars) {
				int indexOfCode = REGULARS.indexOf(""+l);
				if (indexOfCode > -1) output = output + CODE.get(indexOfCode) + " "; }
			output = output + "\n";
		}
		return output;
	}
	public static String decode(String input) {
		String words[] = input.split("\n");
		String decoded = "";
		for (String word : words) {
			String codes[] = word.split(" ");
			for (String code : codes) {
				int indexOfRegular = CODE.indexOf(code);
				if (indexOfRegular > -1) decoded = decoded + REGULARS.get(indexOfRegular);
			}
			decoded = decoded + " ";
		}
		return decoded;
	}
}
