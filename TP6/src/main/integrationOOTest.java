package main;

import static org.junit.Assert.*;
import main.MyListImpl.Elem;

import org.junit.Before;
import org.junit.Test;

public class integrationOOTest {

	@Before
	public void setUp() throws Exception {
	}

	/*
	 * **********************
	 * Test de la classe Elem 
	 * **********************
	 */
	@Test
	public void elemGetContent() {
		/*
		 * Pour pouvoir MyLister la classe interne, on doit créer une instance de la classe englobante
		 */
		MyListImpl myList = new MyListImpl();
		
		Elem myElem = myList.new Elem(2, null);
		
		assertEquals(2, myElem.getContent());
	}
	
	@Test
	public void elemSetContent() {
		MyListImpl myList = new MyListImpl();
		
		Elem myElem = myList.new Elem(2, null);
		
		myElem.setContent(0);
		
		assertEquals(0, myElem.getContent());
	}
	
	@Test
	public void elemGetNext() {
		MyListImpl myList = new MyListImpl();
		
		Elem myElem = myList.new Elem(2, null);
		
		assertEquals(null, myElem.getNext());
	}
	
	@Test
	public void elemSetNext() {
		MyListImpl myList = new MyListImpl();
		
		Elem myElem = myList.new Elem(2, null);
		Elem myElem2 = myList.new Elem(12, null);
		
		myElem2.setNext(myElem);
		
		assertEquals(myElem, myElem2.getNext());
	}		

	/*
	 * **********************************
	 * Test de Calculator(CalculatorImpl)
	 * ********************************** 
	 */
	
	@Test
	public void CImplAdd() {
		Calculator myCalculator= new CalculatorImpl();
		assertEquals(3, myCalculator.add(1, 2));
		assertEquals(-1, myCalculator.add(1, -2));
	}
	@Test
	public void CImplSubstract() {
		Calculator myCalculator= new CalculatorImpl();
		assertEquals(-1, myCalculator.substract(1, 2));
		assertEquals(3, myCalculator.substract(1, -2));
	}
	@Test
	public void CImplMultiply() {
		Calculator myCalculator= new CalculatorImpl();
		assertEquals(21, myCalculator.multiply(3, 7));
		assertEquals(-21, myCalculator.multiply(-3, 7));
		assertEquals(21, myCalculator.multiply(-3, -7));
		assertEquals(-21, myCalculator.multiply(3, -7));
		assertEquals(0, myCalculator.multiply(0, -7));
		assertEquals(0, myCalculator.multiply(3, 0));
		assertEquals(0, myCalculator.multiply(0, 0));
	}

	@Test
	public void CImpldiv() {
		Calculator myCalculator= new CalculatorImpl();
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
		} catch (Exception e) {
			System.out.println("Exception capturée");
		}

		// Quand on a un résultat à  virgule
		assertEquals(4, myCalculator.divide(15, 4));
		assertEquals(-4, myCalculator.divide(15, -4));
		assertEquals(-4, myCalculator.divide(-15, 4));
		assertEquals(4, myCalculator.divide(-15, -4));
		
		// Quand on a un résultat à  virgule
		assertEquals(0, myCalculator.divide(4, 15));
		assertEquals(0, myCalculator.divide(-4, 15));
		assertEquals(0, myCalculator.divide(-4, -15));
		assertEquals(0, myCalculator.divide(4, -15));


	}

	/*
	 * **************************
	 * Test de MyList(MyListImpl)
	 * **************************
	 */
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void MyListGetAtTooLarge() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.getAt(10);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void MyListRemoveAtTooLarge() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.removeAt(10);
	}
	
	@Test
	public void MyListRemoveAt0() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.removeAt(0);
		assertEquals(myList.getAt(0),5);
	}
	
	@Test
	public void MyListRemoveAt2() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.removeAt(2);
		assertEquals(myList.getAt(2),9);
	}
	
	@Test
	public void MyListRemoveAt1() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.removeAt(1);
		assertEquals(myList.getAt(1),7);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void MyListSetAtTooLarge() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.setAt(4,10);
	}
	
	@Test
	public void MyListSetAt2() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.setAt(4,2);
		assertEquals(myList.getAt(2),4);
	}
	
	@Test
	public void MyListReset() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.reset();
		assertEquals(myList.getSize(),0);
	}
	
	@Test
	public void MyListToRemove() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		assertEquals(myList.removeItem(3),3);
	}
	
	@Test
	public void MyListToRemove2() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		assertEquals(myList.removeItem(7),7);
	}

	@Test
	public void MyListToRemoveReset() {
		MyListImpl myList = new MyListImpl();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		myList.add(9);
		
		myList.reset();
		assertNull(myList.removeItem(0));
	}
	
	/*
	 * **************************************
	 * Test de SuiteChainee(SuiteChaineeImpl)
	 * **************************************
	 */
		@Test(expected=AssertionError.class)
		public void SuiteChaineeBuild1() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "add", 3, 5, 0, true);
				fail("Taille liste trop petite (<= 0), should cause an exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test
		public void SuiteChaineeBuild2() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "add", 3, 5, 2, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild3() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "soust", 3, 5, 3, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild4() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "mult", 3, 5, 10, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild5() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "div", 3, 5,2, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild6() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "div", 3, 5,3, false);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}

		@Test
		public void SuiteChaineeBuild7() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "div",3, 5, 7, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild8() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "div", 3, 0, 2, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild9() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "div", 0, 5, 2, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild10() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "div", 0, 5, 3, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test
		public void SuiteChaineeBuild11() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "div", 0, 0, 2, true);
				assertTrue(suiteChainee.isValid("config.properties"));
			} catch (Exception e) {
				e.printStackTrace();
				fail("should not cause an exception");
			}
		}
		
		@Test(expected=AssertionError.class)
		public void SuiteChaineeBuild12() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "add", 3, 5, 15, true);
				fail("Taille liste trop grande (> 10), should cause an exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Test(expected=AssertionError.class)
		public void SuiteChaineeBuild13() {
			SuiteChainee suiteChainee= new SuiteChaineeImpl();
			try {
				suiteChainee.build("config.properties", "abcd", 3, 5, 2, true);
				fail("wrong Operator should cause an exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * **************************************************************************
		 * On ne teste pas en pratique la classe main car elle n'est pas instanciable
		 * ***************************************************************************
		 */

}
