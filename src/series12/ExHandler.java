/* use a private exceptions class:
 * private OperatorException extends Exception
 *
 * the calculator
 *
 * - read a line, check it for being an operand
 *    if it isn't an operand: throw an OperatorException
 * - read two more lines
 *    parse them to double, if that fails, catch the exception
 *    and throw a new exception (OperatorException I assume?)
 *    if not enough lines were provided propagate the nullpointerexception:
 *
 *   try {
 *     read next line
 *     read next line
 *     parse line
 *     parse line
 *   } catch (parse error e) {
 *     throw new OperatorException(parse error e)
 *   }
 *
 *   that should propagate the nullpointer...
 *
 * - if you get til here, perform the operation on the operands
 *
 * - while loop this with some kind of sentinel expression
 *     this depends on whether values are left, so first thing in the loop: check that there is more to do!
 */

package series12;

public class ExHandler {

}

private class OperatorException extends Exception {

}
