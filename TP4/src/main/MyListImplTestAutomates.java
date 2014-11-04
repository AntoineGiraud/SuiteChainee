package main;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author mat
 *
 */
public class MyListImplTestAutomates {
	protected MyListImpl myList;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 myList = new MyListImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	//Test du reset sur sur une chaine non vide
	//Etat final souhaité : chaine vide
	public void test1() {
		if (myList.getSize() != 0)
			fail("On voullait tester ici sur une liste déjà vide.");
		
		myList.reset();
		
		assertTrue(myList.getSize() == 0);
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	//Test du reset sur sur une chaine non vide
	//Etat final souhaité : chaine vide
	public void test2() {
		if (myList.getSize() != 0)
			fail("On voullait tester ici sur une liste déjà vide.");
		try {
			myList.removeAt(0);
			fail("Division par 0, should cause an exception");
		} catch (Exception e) {System.out.println(e.getClass().toString());}
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	//Test du reset sur sur une chaine non vide
	//Etat final souhaité : chaine vide
	public void test3() {
		if (myList.getSize() != 0)
			fail("On voullait tester ici sur une liste déjà vide.");
		try {
			myList.getAt(0);
			fail("Division par 0, should cause an exception");
		} catch (Exception e) {System.out.println(e.getClass().toString());}
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	//Test du reset sur sur une chaine non vide
	//Etat final souhaité : chaine vide
	public void test4() {
		if (myList.getSize() != 0)
			fail("On voullait tester ici sur une liste déjà vide.");
		try {
			myList.setAt(0, 0);
			fail("Division par 0, should cause an exception");
		} catch (Exception e) {System.out.println(e.getClass().toString());}
	}

	@Test
	//Test du reset sur sur une chaine non vide
	//Etat final souhaité : chaine vide
	public void test5() {
		myList.add(5);
		myList.add(3);
		myList.reset();
		
		assertTrue(myList.getSize() == 0);
	}

	//Test du removeItem sur une chaine de taille 1
	//Etat final souhaité : chaine vide	
	@Test
	public void test6() {
		myList.add(3);
		myList.removeItem(3);
		
		assertTrue(myList.getSize() == 0);
	}

	//Test du removeItem sur sur une chaine de taille strictement supérieure à 1
	//Etat final souhaité : chaine non vide
	@Test
	public void test7a() {
		myList.add(3);
		myList.add(5);

		myList.removeItem(3);
		
		assertTrue(myList.getSize() > 0);
	}

	//Test du removeItem sur sur une chaine de taille 1 mais sur un élément non contenu dans la liste
	//Etat final souhaité : chaine non vide
	@Test
	public void test7b() {
		myList.add(3);

		myList.removeItem(5);
		
		assertTrue(myList.getSize() > 0);
		//Retourne un NullPointerException. Il y a donc une erreur de transition. 
		//L'état final est un état d'exception et non "chaine non vide"
	}

	//Test du removeAt à la position 0 sur sur une chaine de taille 1
	//Etat final souhaité : chaine vide
	@Test
	public void test8() {
		myList.add(3);

		myList.removeAt(0);
		
		assertTrue(myList.getSize() == 0);
	}

	//Test du removeAt à une position quelconque (inférieure à la taille de la chaine) sur une chaine de taille strictement supérieure à 1
	//Etat final souhaité : chaine non vide
	@Test
	public void test9a() {
		myList.add(3);
		myList.add(6);
		myList.add(13);


		myList.removeAt(0);
		
		assertTrue(myList.getSize() > 0);
	}
}
