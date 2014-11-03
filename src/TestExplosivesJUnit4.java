import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestExplosivesJUnit4 {

	static int nb_inc = 0;
	static int nb_fail = 0;

	Explosives e;

	public static void main(String args[]) {
		String testClass = "TestExplosivesJUnit4";
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
/**
	@Test
	public void testSequence_0() {
		try {
			e = new Explosives();
			e.add_incomp("Prod_Nitro", "Prod_Glycerine");
			e.add_incomp("Prod_Dyna", "Prod_Mite");
			e.add_assign("Bat_1", "Prod_Dyna");
			e.add_assign("Bat_1", "Prod_Nitro");
			e.add_assign("Bat_2", "Prod_Mite");
			e.add_assign("Bat_1", "Prod_Glycerine");
		} catch (org.jmlspecs.jmlrac.runtime.JMLAssertionError e) {
			handleJMLAssertionError(e);
		}
	}


	@Test
	public void invalidePropiete_1() {

		e = new Explosives();
	
		for(int i = 0; i < 48; ){

			e.add_incomp("Prod_Nitro"+i, "Prod_Glycerine"+i);
			i=i+2;
		}
	
		e.add_incomp("Prod_Dybna", "Prod_Mbite");

	}

	@Test
	public void invalidePropiete_2() {
		e = new Explosives();
		
		for(int i = 0; i < 30; ){

			e.add_assign("Bat_2", "Prod_Mite"+i);
			
		}
	}

	@Test
	public void invalidePropiete_3() {
		e = new Explosives();
		e.add_incomp("tt", "sss");
	}

	@Test
	public void invalidePropiete_4(){
		e = new Explosives();
		e.add_assign("tt", "Prod__");
	}
	
	@Test
	public void invalidePropiete_5(){
		e = new Explosives();
		e.add_incomp("Prod_Nitro", "Prod_Nitro");
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
	public void invalidePropiete_7(){
		e = new Explosives();
		e.add_incomp("Prod_Nitro", "Prod_Glycerine");
		e.add_assign("Bat_1", "Prod_Nitro");	
		e.add_assign("Bat_1", "Prod_Glycerine");
	}
**/

/**
	@Test
	public void invalidePreCond1_1(){
		e = new Explosives();
		String prod1 = null;
		String prod2 = null;
		e.add_incomp(prod1, prod2);
		
	}

	@Test
	public void invalidePreCond1_2(){
		e = new Explosives();
		String prod1 = "Prodrrr";
		String prod2 = null;
		e.add_incomp(prod1, prod2);
		
	}
	
	@Test
	public void invalidePreCond1_3(){
		e = new Explosives();
		e.nb_inc = 49;
		String prod1 = "Prodrrr";
		String prod2 = null;
		e.add_incomp(prod1, prod2);
		
	}
**/

	@Test
	public void testFindBat(){
		e = new Explosives();
		System.out.println("Inserting Prod_Nitro Prod_Glycerine");
		e.add_incomp("Prod_Nitro","Prod_Glycerine");
		System.out.println("Inserting Prod_Dyna Prod_Mite");
		e.add_incomp("Prod_Dyna","Prod_Mite");
		System.out.println("Assigning Prod_Dyna to Bat_1");
		e.add_assign("Bat_1","Prod_Dyna");
		System.out.println("Assigning Prod_Nitro to Bat_1");
		e.add_assign("Bat_1","Prod_Nitro");
		System.out.println("Assigning Prod_Mite to Bat_2");
		e.add_assign("Bat_2","Prod_Mite");
		System.out.println("Assigning Prod_Glycerine to Bat_1");
		e.add_assign("Bat_2","Prod_Glycerine");
		System.out.println("It should have exploded at this point");
		e.add_incomp("Prod_Nitro","Prod_GAGA");
		String bat = e.findBat("Prod_GAGA");
		System.out.println("-------------------------");
		System.out.println("Incompatibilities");
		for(int i=0; i< e.nb_inc; i++){System.out.println(e.incomp[i][0] + "  " +e.incomp[i][1] );}
		System.out.println("-------------------------");
		System.out.println("Assignments");
		for(int i=0; i< e.nb_assign; i++){System.out.println(e.assign[i][0] + "  " +e.assign[i][1] );}
		System.out.println("-------------------------");
		System.out.println("Batiment dispo : " + bat);
    }
	
}
