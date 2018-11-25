package series4;

import acm.program.*;
import acm.graphics.*;

public class honk extends ConsoleProgram {

	public void run() {

		println(5&3);
		println(-(5&3));
		println(1+-(5&3));
		println(+2);
		println(1<<+2);
		println(1<<+2&(1+-(5&3)));
		println(~(1<<+2&1+-(5&3)));
		println();
		println(true || !!false && true != false);
		println(1 + 6 * 3 % 10 / 5 + 3 + 7 + 10 / 100 / 10);

		/*




		   true  ||   ! ! false    &&  true    !=  false
		(((true) || ((!(!(false))) && (true))) != (false))

		(true || ((!(!(false))) && true)) != false



		    1  +     6  *  3   %  10   /  5   +  3   +  7   +    10  /  100   /  10
		((((1) + ((((6) * (3)) % (10)) / (5)) + (3)) + (7)) + (((10) / (100)) / (10)))

		(((1 + (((6 * 3) % 10) / 5)) + 3) + 7) + ((10 / 100) / 10)



		 ~(  1  <<  +  2    &   1  +  - ( 5  &  3 )  )
		(~(((1) << (+ (2))) & ((1) + (- ((5) & (3))))))

		~( (1 << (+(2))) & (1 + (-(5&3))) )



		*/

	}

}
