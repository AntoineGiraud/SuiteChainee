package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyListImplObjectTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testStart() {
		//Test de la tranche start
		
		/*
		 * Test de la Séquence 1 du tableau de séquences corrigées du rapport madum
		 */
		
		//Test du constructeur
		MyListImpl myList = new MyListImpl();
		assertTrue(myList.getStart() == null);
		
		//Test du add
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		assertTrue(myList.getStart() != null);
		
		//Test du removeAt
		myList.removeAt(2);
		assertTrue(myList.getStart() != null);
		
		//Test du removeItem
		//item au début
		myList.removeItem(2);
		assertTrue(myList.getStart() != null);
		
		//item qui n'est pas au début
		myList.removeItem(5);
		assertTrue(myList.getStart() != null);

		/*
		 * item qui n'est pas dans la liste
		 * On doit observer une exception NullPointerException
		 */
		try {
			myList.removeItem(0);
			fail("On attend un crash !!!!!!!!!!!!!");
		} catch (NullPointerException e) {
			assertTrue(myList.getStart() != null);
		}
		
		//Test du setAt
		myList.setAt(18,1);
		assertTrue(myList.getStart() != null);
		
		//test du getAt
		myList.getAt(1);
		assertTrue(myList.getStart() != null);
		
		//test du reset
		myList.reset();
		assertTrue(myList.getStart() == null);
		
		/*
		 * Test de la Séquence 2 du tableau de séquences corrigées du rapport madum
		 */
		
		//Test du constructeur
		myList = new MyListImpl();
		assertTrue(myList.getStart() == null);
		
		//Test du removeItem
		try {
			myList.removeItem(0);
			fail("On attend un crash !!!!!!!!!!!!!");
		} catch (NullPointerException e) {
			assertTrue(myList.getStart() == null);
		}
		
		//Test du add
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		assertTrue(myList.getStart() != null);
		
		//test du removeAt
		myList.removeAt(2);
		assertTrue(myList.getStart() != null);
		
		//test du setAt
		myList.setAt(18,1);
		assertTrue(myList.getStart() != null);
		
		//test du getAt
		myList.getAt(1);
		assertTrue(myList.getStart() != null);
		
		//test du reset
		myList.reset();
		assertTrue(myList.getStart() == null);
	}
	
	@Test
	public void testSize() {
		/*
		 * Test de la Séquence 1 de la tranche size du tableau de séquences corrigées du rapport madum
		 */
		MyListImpl myList = new MyListImpl();
		assertTrue(myList.getSize() == 0);
		
		//Test du add
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		assertTrue(myList.getSize() > 0);
		
		//test du removeAt
		myList.removeAt(0);
		assertTrue(myList.getSize() > 0);
		
		//test du removeAt
		try {
			myList.removeAt(50);
			fail("On attend un crash !!!!!!!!!!!!!");
		} catch (ArrayIndexOutOfBoundsException e) {
			assertTrue(myList.getSize() > 0);
		}
		
		//Test du removeItem
		myList.removeItem(3);
		assertTrue(myList.getSize() > 0);
		
		//Test du setItem
		try {
			myList.setAt(2,18);
			fail("On attend un crash !!!!!!!!!!!!!");
		} catch (ArrayIndexOutOfBoundsException e) {
			assertTrue(myList.getSize() > 0);
		}
		
		//Test du getItem
		try {
			myList.getAt(42);
			fail("On attend un crash !!!!!!!!!!!!!");
		} catch (ArrayIndexOutOfBoundsException e) {
			assertTrue(myList.getSize() > 0);
		}
		
		//Test du reset
		myList.reset();
		assertTrue(myList.getSize() == 0);
	}
	
	@Test
	public void testCurrent() {
		/*
		 * Test de la Séquence 1 de la tranche current du tableau de séquences corrigées du rapport madum
		 */
		
		//Test du constructeur
		MyListImpl myList = new MyListImpl();
		assertTrue(myList.getCurrent() == null);
		
		//Test du add
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		myList.add(6);
		assertTrue(myList.getCurrent() != null);
		
		//Test du reset
		myList.reset();
		assertTrue(myList.getCurrent() == null);
	}	

}
