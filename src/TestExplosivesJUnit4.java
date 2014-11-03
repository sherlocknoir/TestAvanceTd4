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
		
		try{
			e = new Explosives();
			for(int i = 0; i < 48; ){
				e.add_incomp("Prod_Nitro"+i, "Prod_Glycerine"+i);
				i=i+2;
			}
			e.add_incomp("Prod_Dybna", "Prod_Mbite");

		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
		
	}

	@Test
	public void invalidePropiete_2() {
		try{
			e = new Explosives();
		
			for(int i = 0; i < 30; ){

				e.add_assign("Bat_2", "Prod_Mite"+i);
			
			}
		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
		
	}

	

	@Test
	public void invalidePropiete_3() {
		try{
			e = new Explosives();
			e.add_incomp("tt", "sss");
		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
		
	}

	@Test
	public void  testSequence_Prop3_success() {
		try{
			e=new Explosives();
		    e.add_incomp("Prod_ss1","Prod_ss2");
		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}

	@Test
	public void invalidePropiete_4(){
		try{
			e = new Explosives();
			e.add_assign("tt", "Prod__");

		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
		
	}
	
	@Test
	public void  testSequence_Prop4_success() {
		try{
			e=new Explosives();
		    e.add_assign("Bat_bb1","Prod_ss1");
		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}
	

	@Test
	public void invalidePropiete_5(){
		try{
			e = new Explosives();
			e.add_incomp("Prod_Nitro", "Prod_Nitro");

		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}
	
	@Test
	public void  testSequence_Prop5_success() {
		try{
			e=new Explosives();
		    e.add_incomp("Prod_ss3","Prod_ss4");
		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}	
	
	@Test
	public void invalidePropiete_6(){
		try{
			e = new Explosives();
			e.incomp[0][0] = "Prod_hd";
			e.incomp[0][1] = "Prod_sos";
			e.nb_inc++;
			e.skip();
			}
		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
		
	}

	@Test
	public void  testSequence_Prop6_success() {
		try{
			Explosives e = new Explosives();
			for (int i = 1; i < 25;) {
				int j = i + 1;
				e.add_incomp("Prod_ss" + i, "Prod_ss" + j);
				i=i+2;
			}
		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
	}
	

	@Test
	public void invalidePropiete_7(){
		try{
			e = new Explosives();
			e.add_incomp("Prod_Nitro", "Prod_Glycerine");
			e.add_assign("Bat_1", "Prod_Nitro");	
			e.add_assign("Bat_1", "Prod_Glycerine");

		} 	catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
				handleJMLAssertionError(e);		
		}  
		
	}
	
	@Test
	public void  testSequence_prop7_success() {
	try{
		Explosives e = new Explosives();
		for (int i = 1; i < 25;) {
			int j = i + 1;
			e.add_incomp("Prod_ss" + i, "Prod_ss" + j);
			i=i+2;
		}
		e.add_assign("Bat_A", "Prod_ss1");
	        e.add_assign("Bat_B", "Prod_ss2");
		
	} catch(org.jmlspecs.jmlrac.runtime.JMLAssertionError e){
		handleJMLAssertionError(e);		
	}  
	}
	
	
}
