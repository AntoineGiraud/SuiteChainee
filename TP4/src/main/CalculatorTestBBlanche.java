package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTestBBlanche {
	protected Calculator myCalculator;
	

	@Before
	public void setUp() throws Exception {		
		myCalculator= new CalculatorImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		assertEquals(3, myCalculator.add(1, 2));
		assertEquals(-1, myCalculator.add(1, -2));
	}
	@Test
	public void testSubstract() {
		assertEquals(-1, myCalculator.substract(1, 2));
		assertEquals(3, myCalculator.substract(1, -2));
	}
	@Test
	public void testMultiply() {
		assertEquals(21, myCalculator.multiply(3, 7));
		assertEquals(-21, myCalculator.multiply(-3, 7));
		assertEquals(21, myCalculator.multiply(-3, -7));
		assertEquals(-21, myCalculator.multiply(3, -7));
		assertEquals(0, myCalculator.multiply(0, -7));
		assertEquals(0, myCalculator.multiply(3, 0));
		assertEquals(0, myCalculator.multiply(0, 0));
	}

	@Test
	public void testdiv() {
		// Quand on a un reste null
		assertEquals(5, myCalculator.divide(15, 3));
		assertEquals(-5, myCalculator.divide(-15, 3));
		assertEquals(5, myCalculator.divide(-15, -3));
		assertEquals(-5, myCalculator.divide(15, -3));

		assertEquals(0, myCalculator.divide(0, -3));
		assertEquals(0, myCalculator.divide(0, 3));
		try {
			myCalculator.divide(3, 0);
			fail("Division par 0, should cause an exception");
		} catch (Exception e) {e.printStackTrace();}

		// Quand on a un résultat à virgule
		assertEquals(4, myCalculator.divide(15, 4));
		assertEquals(-4, myCalculator.divide(15, -4));
		assertEquals(-4, myCalculator.divide(-15, 4));
		assertEquals(4, myCalculator.divide(-15, -4));
		
		// Quand on a un résultat à virgule
		assertEquals(0, myCalculator.divide(4, 15));
		assertEquals(0, myCalculator.divide(-4, 15));
		assertEquals(0, myCalculator.divide(-4, -15));
		assertEquals(0, myCalculator.divide(4, -15));


	}

}
