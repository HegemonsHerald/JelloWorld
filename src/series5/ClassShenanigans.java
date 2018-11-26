package series5;

import acm.program.*;
import acm.graphics.*;

/**
 * Honk.
 */
public class ClassShenanigans extends ConsoleProgram {

	private class Honk {
		public String msg;
		public Honk(String m) {
			this.msg = m;
		}
	}

	@Override
	public void run() {

		Honk tonk = new Honk("quack");
		println(tonk.msg);

	}

}
