package series8;

// package programming.set8.length;

/** Length. */
public enum Length {

	// The constants...
	ARSHIN      	(0.71),
	FINGER      	(0.022225),
	METRE       	(1.0),
	HORSE_LENGTH	(2.4),
	PARSEC      	(30_856_776_000_000_000.d),
	PLUTO_RADIUS	(1_186_000.d);

	// The field
	private final double unitLength;


	/**
	 * The constructor.
	 *
	 * @param lengthInMetres	this is the unit length of the {@code Length }
	 */
	Length(double lengthInMetres) {

		this.unitLength = lengthInMetres;

	}

	/**
	 * Returns how much one of this unit is in metres.
	 *
	 * @return one unit in metres.
	 */
	public double getUnitLengthInMetres() {

		return this.unitLength;

	}

	/**
	 * Converts the given amount measured in the current length unit to how much it would be
	 * in the target unit.
	 *
	 * @param targetLength
	 *            the target unit of length.
	 * @param amount
	 *            the length to convert to the target length.
	 * @return the corresponding length in the target unit.
	 */
	public double convertTo(Length targetLength, double amount) {

		// amount is in this' unit, so actualAmount is amount in metres
		double actualAmount = amount * unitLength;

		return actualAmount / targetLength.getUnitLengthInMetres();

	}

}
