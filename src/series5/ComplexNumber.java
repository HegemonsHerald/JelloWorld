package series5;

import java.lang.Math;

/**
 * Cőőmplex Nőőmbőőrs.
 */
public class ComplexNumber {

	/* Fields */
	/** Real part of the Complex Number. */
	private final double real;
	/** Imaginary part of the Complex Number. */
	private final double imaginary;

	/* Constructors */

	/**
	 * Constructs a ComplexNumber.
	 * @param real what the real part of the ComplexNumber should be
	 * @param imaginary what the imaginary part of the ComplexNumber should be
	 */
	public ComplexNumber(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	/**
	 * Constructs a ComplexNumber with its imaginary and real parts set to 0.
	 */
	public ComplexNumber() {
		this(0, 0);
	}

	/**
	 * Duplicates a ComplexNumber.
	 * @param cn the ComplexNumber to duplicate
	 */
	public ComplexNumber(ComplexNumber cn) {
		this(cn.getReal(), cn.getImaginary());
	}


	/* Accessors */

	/**
	 * Gets the real part of a ComplexNumber
	 * @return the real part of a ComplexNumber
	 */
	public double getReal() {
		return this.real;
	}

	/**
	 * Gets the imaginary part of a ComplexNumber
	 * @return the imaginary part of a ComplexNumber
	 */
	public double getImaginary() {
		return this.imaginary;
	}


	/* Printing */

	@Override
	public String toString() {
		return "" + this.real + " + " + this.imaginary + "i";
	}


	/* Operations */

	/**
	 * Computes the conjugate of {@code this}.
	 * @return the conjugate of {@code this}
	 */
	public ComplexNumber conjugate() {
		// Do the thing from the Wikipedia
		return new ComplexNumber(this.real, -(this.imaginary));
	}

	/**
	 * Computes the sum of {@code this} and the provided {@code other}.
	 * @param other another ComplexNumber
	 * @return sum of two ComplexNumbers
	 */
	public ComplexNumber add(ComplexNumber other) {
		// Add real parts and add imaginary parts
		return new ComplexNumber(this.real + other.getReal(), this.imaginary + other.getImaginary());
	}

	/**
	 * Computes the difference of {@code this} and the provided {@code other}.
	 * @param other another ComplexNumber
	 * @return difference of two ComplexNumbers
	 */
	public ComplexNumber subtract(ComplexNumber other) {
		// Subtract real parts and add imaginary parts
		return new ComplexNumber(this.real - other.getReal(), this.imaginary - other.getImaginary());
	}

	/**
	 * Computes the product of {@code this} and the provided {@code other}.
	 * @param other another ComplexNumber
	 * @return product of two ComplexNumbers
	 */
	public ComplexNumber multiply(ComplexNumber other) {
		// Simply do the thing from the wikipedia
		double newReal = (this.real * other.getReal() - this.imaginary * other.getImaginary());
		double newImag = (this.real * other.getImaginary() + this.imaginary * other.getReal());
		return new ComplexNumber(newReal, newImag);
	}

	/**
	 * Computes the fraction of {@code this} and the provided {@code other}.
	 * @param other another ComplexNumber
	 * @return fraction of two ComplexNumbers
	 */
	public ComplexNumber divide(ComplexNumber other) {
		// Check for division by 0
		if (other.getReal() == 0 && other.getImaginary() == 0) return null;

		// Do the thing from the Wikipedia
		double fraction = 1.d / (other.getReal() * other.getReal() + other.getImaginary() * other.getImaginary());
		double newReal = this.real * other.getReal() + this.imaginary * other.getImaginary();
		double newImag = this.real * other.getImaginary() - this.imaginary * other.getReal();
		return new ComplexNumber(newReal * fraction, newImag * fraction);
	}

	/**
	 * Computes the absolute value of {@code this}.
	 * @return absolute value of ComplexNumber
	 */
	public double abs() {
		// Do the thing from the Wikipedia
		return Math.sqrt( Math.pow(this.real, 2) + Math.pow(this.imaginary, 2) );
	}

}
