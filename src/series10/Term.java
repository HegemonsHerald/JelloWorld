package series10;
/**
 * A node in a parse tree. Each node represents one of two things:
 *
 * <ol>
 *   <li>An operator, in which case there needs to be a left and right subtree to
 *       represent the operands.</li>
 *   <li>A literal, in which case the subtrees will be empty.</li>
 * </ol>
 */
public class Term {

	/** The literal or operator represented by this node. */
	private String content;
	/** The left subtree, if any. */
	private Term left;
	/** The right subtree, if any. */
	private Term right;

	/**
	 * Creates a new term without subtrees.
	 *
	 * @param content
	 *            the operator or literal represented by this node.
	 */
	public Term(String content) {
		// Call the other constructor
		this(content, null, null);
	}

	/**
	 * Creates a new term with the given subtrees.
	 *
	 * @param content
	 *            the operator or literal represented by this node.
	 * @param left
	 *            the left subtree, if any.
	 * @param right
	 *            the right subtree, if any.
	 */
	public Term(String content, Term left, Term right) {
		this.content = content;
		this.left = left;
		this.right = right;
	}

	/**
	 * Returns the operator or literal represented by this node.
	 *
	 * @return the operator or literal.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the operator or literal represented by this node.
	 *
	 * @param content
	 *            the new operator or literal.
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns the left subtree.
	 *
	 * @return the left subtree.
	 */
	public Term getLeft() {
		return left;
	}

	/**
	 * Returns the right subtree.
	 *
	 * @return the right subtree.
	 */
	public Term getRight() {
		return right;
	}

	/**
	 * Sets the left subtree.
	 *
	 * @param left
	 *            the new left subtree.
	 */
	public void setLeft(Term left) {
		this.left = left;
	}

	/**
	 * Sets the right subtree.
	 *
	 * @param right
	 *            the new right subtree.
	 */
	public void setRight(Term right) {
		this.right = right;
	}
}
