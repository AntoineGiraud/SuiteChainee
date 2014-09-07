import java.io.File;


public class SuiteChainee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListeChainee l = new ListeChainee();
		l.add(4);
		l.add(8);
		l.add(4);
		l.add(3);
		l.add(4);
		l.add(4);
		l.add(1);
		l.add(9);
		l.add(1);
		l.add(4);
		
		
		l.show();
		System.out.println("----------------------------------------");
		System.out.println("l.getAt(0) : "+l.getAt(0));
		System.out.println("l.getAt(1) : "+l.getAt(1));
		System.out.println("l.getSize(): "+l.getSize());
		System.out.println("----------------------------------------");

		// On teste la fonction removeItem
		l.show();
		l.removeItem(1);
		l.show();
		System.out.println("----------------------------------------");
		
		// On teste la fonction setAt
		l.show();
		l.setAt(11,0);
		l.show();
		l.setAt(11,4);
		l.show();
		System.out.println("----------------------------------------");
		
		// On teste la fonction removeAt
//		l.show();
//		l.removeAt(0);
//		l.show();
//		l.removeAt(3);
//		l.show();
//		System.out.println("----------------------------------------");
		
		// Test showByKeyOrderedAsc & show
		l.show();
		l.showByKeyOrderedDesc();
		l.showByKeyOrderedAsc();
		System.out.println("----------------------------------------");
		System.out.println(l.toString());
		System.out.println("----------------------------------------");
		
		// On teste la fonction reset
		l.show();
		l.reset();
		l.show();
		System.out.println("----------------------------------------");
		
		// Test ajout d'une chaine de charact�res
		l.add("0,1, 2,3 ");
		l.add("1,2");
		l.show();
		
		//Test de la suite chainée
		System.out.println("-----------------test---------------------");
		Suite mySuite = new Suite("mySuite.properties", "add", 1, 2, 4, true);
		mySuite.getContent().show();
		
		//On continue les calculs avec un autre opérateur
		System.out.println("----------------------------------------");
		Suite mySuite2 = new Suite("mySuite.properties", "sub", 1, 2, 10, false);
		mySuite2.getContent().show();
		
		//On force la remise à zero de la chaine, le résultat n'est pas la même que le précédent
		System.out.println("----------------------------------------");
		Suite mySuite3 = new Suite("mySuite.properties", "add", 1, 2, 4, true);
		mySuite3.getContent().show();
		Suite mySuite4 = new Suite("mySuite.properties", "sub", 1, 2, 10, true);
		mySuite4.getContent().show();
	}

}
