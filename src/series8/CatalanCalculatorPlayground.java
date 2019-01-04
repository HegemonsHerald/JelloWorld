package series8;

public class CatalanCalculatorPlayground {

	public static void main(String args[]) {

		CatalanCalculator c = new CatalanCalculator();

		c.catalan(3);

		System.out.println("numbers count  " + c.getCalculatedCatalanNumbersCount());
		System.out.println("number 0 count " + c.getCalculatedCatalanNumberCount(0));
		System.out.println("number 1 count " + c.getCalculatedCatalanNumberCount(1));
		System.out.println("number 2 count " + c.getCalculatedCatalanNumberCount(2));
		System.out.println("number 3 count " + c.getCalculatedCatalanNumberCount(3));
		System.out.println("stack depth    " + c.getMaximumStackDepth());

	}

}
