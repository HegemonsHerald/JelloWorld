package series5;

import series5.ComplexNumber;

public class ComplexNumberPlayground {

	public static void main(String args[]) {

		// Make stuff
		ComplexNumber cn1 = new ComplexNumber();
		ComplexNumber cn2 = new ComplexNumber(1.35, 38945.33);
		ComplexNumber cn3 = new ComplexNumber(cn2);
		ComplexNumber cn4 = new ComplexNumber(42.3, 9.0);

		// Basic methods
		System.out.println(cn2);		// toString
		System.out.println(cn2.getReal());	// getReal
		System.out.println(cn2.getImaginary());	// getImaginary

		// Operations
		ComplexNumber cn2Con = cn2.conjugate();
		ComplexNumber cn2Add = cn2.add(cn4);
		ComplexNumber cn2Sub = cn2.subtract(cn4);
		ComplexNumber cn2Mul = cn2.multiply(cn4);
		ComplexNumber cn2Div = cn2.divide(cn4);
		double cn2Abs = cn2.abs();

		System.out.println(cn2Con);
		System.out.println(cn2Add);
		System.out.println(cn2Sub);
		System.out.println(cn2Mul);
		System.out.println(cn2Div);
		System.out.println(cn2Abs);
		System.out.println(cn2.divide(cn1));

	}

}
