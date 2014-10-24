/**
 * 
 */
package main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mafao
 *
 */
public class MyListImplTest {
	protected MyListImpl myList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 myList = new MyListImpl();
		 myList.add(3);
		 myList.add(5);
		 myList.add(7);
		 myList.add(9);
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testGetAtTooLarge() {
		myList.getAt(10);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testRemoveAtTooLarge() {
		myList.removeAt(10);
	}
	
	@Test
	public void testRemoveAt0() {
		myList.removeAt(0);
		assertEquals(myList.getAt(0),5);
	}
	
	@Test
	public void testRemoveAt2() {
		myList.removeAt(2);
		assertEquals(myList.getAt(2),9);
	}
	
	@Test
	public void testRemoveAt1() {
		myList.removeAt(1);
		assertEquals(myList.getAt(1),7);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testSetAtTooLarge() {
		myList.setAt(4,10);
	}
	
	@Test
	public void testSetAt2() {
		myList.setAt(4,2);
		assertEquals(myList.getAt(2),4);
	}
	
	@Test
	public void testReset() {
		myList.reset();
		assertEquals(myList.getSize(),0);
	}
	
	@Test
	public void testToRemove() {
		assertEquals(myList.removeItem(3),3);
	}
	
	@Test
	public void testToRemove2() {
		assertEquals(myList.removeItem(7),7);
	}

	@Test
	public void testToRemoveReset() {
		myList.reset();
		assertNull(myList.removeItem(0));
	}
	
	
}
