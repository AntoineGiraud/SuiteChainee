package main;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuiteChaineeTestECBBlanche {
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
			suiteChainee.build("config.properties", "soust", 0,0, 3, false);
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
	
	//Section complétude de EC
	/**
	 * Test pour générer une chaine trop pleine dans le fichier config.properties
	 */
	@Test(expected=AssertionError.class)
	public void testEC8() {
		try {
			suiteChainee.build("config.properties", "div", 3, 2, 3, true);
			suiteChainee.build("config.properties", "div", 3, 2, 3, false);
			fail("System should print chaine deja pleine");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour générer une chaine pouvant s'ajouter correctement au fichier config.properties
	 */
	@Test
	public void testEC9() {
		try {
			suiteChainee.build("config.properties", "add", 3,5,1, true);
			suiteChainee.build("config.properties", "add", 3,5,5, false);
			assertTrue(suiteChainee.isValid("config.properties"));
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour multiplication
	 */
	@Test
	public void testEC10() {
		try {
			suiteChainee.build("config.properties", "mult", 3,5,1, true);
			suiteChainee.build("config.properties", "mult", 1,2,4, false);
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour multiplication
	 */
	@Test
	public void testEC11() {
		try {
			suiteChainee.build("config.properties", "mult", 3,5,1, true);
			suiteChainee.build("config.properties", "mult", 1,2,4, false);
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour soustraction
	 */
	@Test
	public void testEC12() {
		try {
			suiteChainee.build("config.properties", "soust", 3,5,1, true);
			suiteChainee.build("config.properties", "soust", 1,2,4, false);
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour operateur non identifie
	 */
	@Test
	public void testEC13() {
		try {
			suiteChainee.build("config.properties", "operator", 3,5,1, true);
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour index non valide (index plus grand que taille de la liste)
	 */
	@Test
	public void testEC14() {
		try {
			
			suiteChainee.build("config.properties", "add", 3,5,2, false);
			
			Properties prop = new Properties();
			FileInputStream propFile = new FileInputStream("src/"+"config.properties"); //charge le fichier de propriétés
			prop.load(propFile);
			prop.setProperty("indexe", ""+20);
			
			FileOutputStream editpropFile = new FileOutputStream("src/"+"config.properties");
			prop.save(editpropFile, "save");
			
			propFile.close();
			
			suiteChainee.isValid("config.properties");
//			fail("Index trop grand pour la list, should cause an exception");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour operateur non identifie de isValid()
	 */
	@Test
	public void testEC15() {
		try {
			
			suiteChainee.build("config.properties", "add", 3,5,2, true);
			
			Properties prop = new Properties();
			FileInputStream propFile = new FileInputStream("src/"+"config.properties"); //charge le fichier de propriétés
			prop.load(propFile);
			prop.setProperty("operateur", "operateur");
			
			FileOutputStream editpropFile = new FileOutputStream("src/"+"config.properties");
			prop.save(editpropFile, "save");
			
			propFile.close();
			
			suiteChainee.isValid("config.properties");
//			fail("Index trop grand pour la list, should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test pour valeur non int dans contenu isValid()
	 */
	@Test
	public void testEC16() {
		try {
			
			suiteChainee.build("config.properties", "add", 3,5,2, true);
			
			Properties prop = new Properties();
			FileInputStream propFile = new FileInputStream("src/"+"config.properties"); //charge le fichier de propriétés
			prop.load(propFile);
			prop.setProperty("contenue", ""+32);
			
			FileOutputStream editpropFile = new FileOutputStream("src/"+"config.properties");
			prop.save(editpropFile, "save");
			
			propFile.close();
			
			suiteChainee.isValid("config.properties");
//			fail("Index trop grand pour la list, should cause an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test validité des opérateurs de fonction isValid
	 */
	@Test
	public void testEC17() {
		try {
			suiteChainee.build("config.properties", "soust", 1,2,4, true);
			suiteChainee.isValid("config.properties");
			suiteChainee.build("config.properties", "mult", 1,2,4, true);
			suiteChainee.isValid("config.properties");
			suiteChainee.build("config.properties", "div", 1,2,4, true);
			suiteChainee.isValid("config.properties");
		} catch (Exception e) {
			fail("should not cause an exception");
			e.printStackTrace();
		}
	}
	
	//*/
}