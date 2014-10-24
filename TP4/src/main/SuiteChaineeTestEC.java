package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuiteChaineeTestEC {
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


	@Test(expected=AssertionError.class)
	public void testEC1() {
		try {
			suiteChainee.build("config.properties", "add", 3, 5, 0, true);
			fail("Taille liste trop petite (<= 0), should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testEC2() {
		try {
			suiteChainee.build("config.properties", "add", 3, 5, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	@Test
	public void testEC3() {
		try {
			suiteChainee.build("test.properties", "soust", 0,0, 3, false);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	@Test
	public void testEC4() {
		try {
			suiteChainee.build("config.properties", "mult", 3,5, 10, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	@Test
	public void testEC5() {
		try {
			suiteChainee.build("config.properties", "div", 0,0, 2, true);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	
	@Test(expected=AssertionError.class)
	public void testEC6() {
		try {
			suiteChainee.build("config.properties", "add", 3,5,15, true);
			fail("Taille liste trop grande (> 10), should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testEC7() {
		try {
			suiteChainee.build("config.properties", "abcd", 3,5,15, true);
			fail("wrong Operator should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//*/
}