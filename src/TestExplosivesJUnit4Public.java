import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestExplosivesJUnit4Public {

	static int nb_inc = 0;
	static int nb_fail = 0;

	Explosives e;

	public static void main(String args[]) {
		String testClass = "TestExplosivesJUnit4Public";
		org.junit.runner.JUnitCore.main(testClass);
		
		
	}

	private void handleJMLAssertionError(
			org.jmlspecs.jmlrac.runtime.JMLAssertionError e) {
		if (e.getClass().equals(
				org.jmlspecs.jmlrac.runtime.JMLEntryPreconditionError.class)) {
			System.out.println("\n INCONCLUSIVE "
					+ (new Exception().getStackTrace()[0].getMethodName())
					+ "\n\t " + e.getMessage());
			nb_inc++;
		} else {
			// test failure
			nb_fail++;
			junit.framework.Assert.fail("\n\t" + e.getMessage());
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		nb_inc = 0;
		nb_fail = 0;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("\n inconclusive tests: " + nb_inc
				+ " -- failures : " + nb_fail);
	}

	@Test
	public void invalidePropiete_6(){
			e = new Explosives();
			e.incomp[0][0] = "Prod_hd";
			e.incomp[0][1] = "Prod_sos";
			e.nb_inc++;
			e.skip();	
	}

	@Test
	public void  testSequence_Prop6_success() {
		
			Explosives e = new Explosives();
			for (int i = 1; i < 25;) {
				int j = i + 1;
				e.add_incomp("Prod_ss" + i, "Prod_ss" + j);
				i=i+2;
			} 
	}




}
