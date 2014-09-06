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

		// On teste la fonction removeIten
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
		
		// Test ajout d'une chaine de charactères
		l.add("0,1, 2,3 ");
		l.add("1,2");
		l.show();
	}

}
