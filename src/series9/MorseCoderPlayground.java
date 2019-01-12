package series9;

public class MorseCoderPlayground {

	public static void main(String args[]) {

		String eg = "Honkers, bonkers a A";
		System.out.println(eg);
		System.out.println("===================================================");

		String en = MorseCoder.encode(eg);
		System.out.println(en);
		System.out.println("===================================================");

		String de = MorseCoder.decode(en);
		System.out.println(de);

	}

}
