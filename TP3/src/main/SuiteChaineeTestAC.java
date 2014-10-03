package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuiteChaineeTestAC {
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
	
	// -------------------- Tests All Combinations -------------------- //
	
	@Test
	public void testAC1() {
		try {
			suiteChainee.build("config.properties", "add", 3, 5, 0, true);
			fail("Taille liste trop petite (<= 0), should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testAC2() {
		try {
			suiteChainee.build("config.properties", "add", 3, 5, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC3() {
		try {
			suiteChainee.build("config.properties", "soust", 3, 5, 3, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC4() {
		try {
			suiteChainee.build("test.properties", "mult", 3, 5, 10, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC5() {
		try {
			suiteChainee.build("config.properties", "div", 3, 5,2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC6() {
		try {
			suiteChainee.build("config.properties", "div", 3, 5,3, false);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC7() {
		try {
			suiteChainee.build("config.properties", "div",3, 5, 7, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC8() {
		try {
			suiteChainee.build("config.properties", "div", 3, 0, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC9() {
		try {
			suiteChainee.build("config.properties", "div", 0, 5, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC10() {
		try {
			suiteChainee.build("config.properties", "div", 0, 5, 3, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testA11() {
		try {
			suiteChainee.build("config.properties", "div", 0, 0, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("should not cause an exception");
		}
	}
	@Test
	public void testAC12() {
		try {
			suiteChainee.build("config.properties", "add", 3, 5, 15, true);
			fail("Taille liste trop grande (> 10), should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testAC13() {
		try {
			suiteChainee.build("config.properties", "abcd", 3, 5, 2, true);
			fail("wrong Operator should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}