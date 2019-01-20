package series10;

// package programming.set10.parser;

/** PNParser. */
public class PNParser {

	private String tokens[];
	Term tree;


	/** Represents a tree and the last index of the tokens array that was visited, while creating the tree. */
	private class Node {

		/**
		 * Create a new Node.
		 *
		 * @param i	the largest index, that was visited while creating t
		 *
		 * @param t	the tree
		 */
		public Node(int i, Term t) {
			tree = t;
			visited = i;
		}

		public Term tree;

		public int visited;

	}

	/**
	 * Creates a new parser for expressions in Polish notation.
	 *
	 * @param pnExpression
	 *            an expression in Polish notation.
	 * @throws IllegalArgumentException
	 *             if {@code pnExpression} does not contain a valid expression in
	 *             Polish notation.
	 */
	public PNParser(String pnExpression) {

		// Check for only valid characters
		if (pnExpression == null || !pnExpression.matches("[*+ \\d]+")) throw new IllegalArgumentException();

		// Create just tokens
		tokens = pnExpression.split(" ");

		// Parse the tokens into a tree and store that tree
		Node parsed = parse(0);
		tree = parsed.tree;

		// If the last index visited while creating the parse tree
		// isn't the last index of the tokens list, there must be more
		// numeral (or numeral and operator) tokens in the tokens list,
		// than were necessary to fill up the operand slots of all
		// encountered operators, so those would be left over.
		// 
		//   + 1 2 3		-->  tree contains (1 + 2), 3 is left over.
		//   + 1 2 3 8 * *	-->  tree contains (1 + 2), (3 8 * *) is left over.
		// 
		// The left over pieces aren't visited by parse(), because
		// parse() will return the moment it doesn't need any more
		// operands to fill up previously encountered operators.
		if (parsed.visited != tokens.length-1) throw new IllegalArgumentException();

	}


	/**
	 * Parses a Polish Notation String into a {@code Node } that contains the parse-tree and the last index of {@code tokens[] }, that was visited.
	 *
	 * @param i	the current index of {@code tokens[] }
	 *
	 * @throws IllegalArgumentException	if parse encounters too many operators to satisfy
	 * @return Node	the node representing the parse tree
	 */
	private Node parse(int i) {

		// NOTE: A word on Node.visited:
		// While parsing you might have an operand, that contains
		// multiple operators and operands. Node.visited should always
		// contain the index of the last token, that was visited, while
		// parsing for this operand. That way parse() knows how many
		// tokens to skip, when it tries to parse the next operand, as
		// we don't need to revisit tokens, we already encountered.

		// If you've reached the end of the tokens list, but couldn't
		// fill up all the previously encountered operators with
		// operands, the PN String must've been invalid
		if (i >= tokens.length) throw new IllegalArgumentException();

		String me = tokens[i];

		// case: operator
		if (me.matches("[*+]")) {

			// Get left operand
			Node l = parse(i+1);

			// Get right operand
			// you might have to skip a number of indices here
			Node r = parse(1+l.visited);

			return new Node(r.visited, new Term(me, l.tree, r.tree));

		// case: numeral
		} else if (me.matches("[0-9]+")) {

			return new Node(i, new Term(me));

		// case: somehow still sth invalid
		} else throw new IllegalArgumentException();

	}


	/**
	 * Generates the infix string representation of the parse tree starting at {@code current }.
	 *
	 * @param current 	where to start creating the string from
	 *
	 * @param prevMult	was the previous operator a '*'? If yes, there might be some parens to set...
	 *
	 * @return		the string rep
	 */
	public String stringify(Term current, boolean prevMult) {

		String me = current.getContent();
		String l, r;

		// case: this thing is a numeral
		if (me.matches("[0-9]+")) {

			return me;

		// case: this thing is a *
		} else if (me.equals("*")) {

			l = stringify(current.getLeft(), true);
			r = stringify(current.getRight(), true);

		// case: this thing is a +
		} else {

			l = stringify(current.getLeft(), false);
			r = stringify(current.getRight(), false);

		}

		// assemble the string, don't forget the spaces they want
		String out = "" + l + " " + me + " " + r;

		// if the previous operator is a * and this operator is a + you
		// have to set parenthesis for the precedence
		if (prevMult && me.equals("+")) {

			out = "(" + out + ")";

		}

		return out;

	}

	/**
	 * Return the expression this class was created with in infix notation.
	 *
	 * @return the tree in infix notation as string.
	 */
	public String getInfixRepresentation() {
		return stringify(tree, false);
	}


	/* My jdoc generator failed on:
	     - parsing exceptions correctly
	     - the return type String		-> the new constructor detection must be bust
	*/

}
