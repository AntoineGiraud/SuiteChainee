package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuiteChaineeTest {
	protected SuiteChainee suiteChainee;
	
	@Before
	public void setUp() throws Exception {
		// call for main operation
		//suiteChainee.build(path, op, val1, val2, taille, etatVide) 
		//path="config.properties"
		//op{"add","mult","soust",div"}
		//val1,val2 are int
		//0< taille <=10
		//etatVide{true,false}
		
		suiteChainee= new SuiteChaineeImpl();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testEC1() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "div", 3, 2, 0, true);
			assertFalse(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test
	public void testEC5() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "div", 0, 0, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}

	@Test
	public void testEC2() {
		try {
			suiteChainee.build("config.properties", "add", 3, 2, 1, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Fichier qui n'existe pas ...
	@Test
	public void testEC3() {
		boolean thrown = false;
		try {
			suiteChainee.build("config2.properties", "mult", 0, 0, 3, false);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}

	@Test
	public void testEC4() {
		boolean thrown = false;
		try {
			System.out.println("Hello World");
			
			suiteChainee.build("config.properties", "soust", 1, 3, 10, true);
			System.out.println("Le programme a été arrété ... Vous ne verrez Jamais !!!");
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}

	@Test
	public void testEC6() {
		boolean thrown = false;
		try {
			System.out.println("Hello World");
			suiteChainee.build("config.properties", "soust", 1, 3, 15, true);
			System.out.println("Le programme a été arrété ... Vous ne verrez Jamais !!!");
			assertFalse(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	//*/
	
	// -------------------- Tests All Combinations -------------------- //
	
	@Test
	public void testAC1() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "div", 3, 2, 0, true);
			assertFalse(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
	@Test
	public void testAC2() {
		try {
			suiteChainee.build("config.properties", "add", 1, -7, 1, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// si on ne vide pas la chaine ...?!
	@Test
	public void testAC32() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "mult", 7, 8, 3, false);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}
	// Fichier qui n'existe pas ...
	@Test
	public void testAC3() {
		boolean thrown = false;
		try {
			suiteChainee.build("config2.properties", "mult", 7, 8, 3, false);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}
	// Fichier qui n'existe pas ...
	@Test
	public void testAC4() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "soust", 0, 0, 4, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}
	@Test
	public void testAC5() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "div", 0, 8, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}
	@Test
	public void testAC6() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "div", 4, 5, 3, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}
	@Test
	public void testAC7() {
		boolean thrown = false;
		try {
			suiteChainee.build("config.properties", "div", 4, 0, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertFalse(thrown);
	}
	@Test
	public void testAC8() {
		boolean thrown = false;
		try {
			System.out.println("Hello World");
			suiteChainee.build("config.properties", "soust", 1, 3, 15, true);
			assertFalse(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			thrown = true;
		}
		assertTrue(thrown);
	}
}