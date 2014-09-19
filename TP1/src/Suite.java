import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe permettant la gestion d'une suite chainée
 * Les résultats et paramètres sont stockées dans un fichier properties
 * Il est possible de reprendre la génération d'un suite en passant en paramètre path un fichier properties existant. 
 * Si les paramètres de l'objet et du fichier ne correspondent pas, c'est celui de l'objet qui est pris en compte.
 * @authors Antoine Giraud, Matthieu Faou
 * 
 */

public class Suite {
	private String path;
	private String operator;
	private int val1;
	private int val2;
	private int index;
	private int length;
	private ListeChainee content = new ListeChainee();
	
	/*
	 * Constructor
	 * Initialise l'objet
	 * Lance les calculs
	 */
	public Suite(String path, String operator, int val1, int val2, int length, boolean emptyState) {
		/*
		 * La taille de la suite ne doit pas dépasser 10
		 */
		if(length > 10) {
			throw new IllegalArgumentException("Suite length cannot be greater than 10.");
		}
		this.path = path;
		this.operator = operator;
		this.val1 = val1;
		this.val2 = val2;
		this.length = length;
		
		if(emptyState) {
			//On remet la liste à zero
			this.content.reset();
			this.index = 0;
			
		} else {
			//Chargement des valeurs déjà calculées et présentes dans le fichier properties
			this.load();
		}
		
		if(content.getSize() == 0) {
			/*
			 * Si la liste est vide, on ajoute les deux premières valeurs et on incrémente index.
			 */
			this.content.add(this.val1);
			this.content.add(this.val2);
			this.index += 2;
		}
		
	
		//On lance la génération de la suite.
		this.iterativeCalc();
	}
	
	
	/*
	 * Charge le fichier properties
	 * S'il existe, les résultats déjà calculées sont insérées dans la Liste content
	 */
	private void load() {
        Properties properties = new Properties();
        
        File f = new File(this.path);
        FileInputStream fileInputStream = null;
        
        //Ouverture du fichier
		try {
			fileInputStream = new FileInputStream(f);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (fileInputStream != null) {
        	//Si le fichier properties existe déjà, on charge les valeurs déjà calculées
        	this.content.add(properties.getProperty("Contenue"));
        	this.index = Integer.parseInt(properties.getProperty("Indexe"));
			int size = this.content.getSize();
			
			/*
			 * L'index du dernier element calculé doit correspondre à la taille de la liste chainée
			 */
			if(size != this.index) {
				throw new IllegalStateException("Le dernier index du fichier properties ne correspond pas à la taille de la liste chainée calculée.");
			}
        }
	}
	
	/*
	 * Sauvegarde l'objet suite dans un fichier properties
	 */
	private void save() {
        Properties properties = new Properties();
        properties.setProperty("Val1", Integer.toString(this.val1));
        properties.setProperty("Val2", Integer.toString(this.val2));
        properties.setProperty("Operateur", this.operator);
        properties.setProperty("Indexe", Integer.toString(this.index));
        properties.setProperty("Taille", Integer.toString(this.length));
        properties.setProperty("Contenue", this.content.toString());


        //Store in the properties file
        File f = new File(this.path);
        try {
			FileOutputStream fileOutputStream = new FileOutputStream(f);
			properties.store(fileOutputStream, null);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Vérifie si le dernier contenu de la chaine écrit est valide ou pas (vérifie bien une suite)
	 * <p>
	 * isValid() s'applique seulement sur le fichier .properties
	 * Cette méthode peut être implantée dans la classe où on fait la construction de la suite chainée.
	 * </p> 
	 * @return (boolean) Est ce que la chaine est valide ou non ?!
	 */
	public boolean isValid() {
		//On charge le contenu du fichier properties sous forme d'une suite
		Suite savedSuite = new Suite(this.path, this.operator, this.val1, this.val2, this.length, false);
		int size = savedSuite.content.getSize();
		int lastValue = savedSuite.content.getAt(size-1);
		
		//Vérification de la dernière valeur
		if(lastValue == this.compute(savedSuite.content.getAt(size-3), savedSuite.content.getAt(size-2), savedSuite.operator)) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * Calcule les éléments de la liste non encore calculés
	 * Effectue l'operation operator sur les deux derniers elements calculés en utilisant la fonction compute
	 * S'arrête lorsque la taille de la liste chainée est égale à la taille de suite souhaitée
	 */
	private void iterativeCalc() {
		while(this.index < this.length) {
			int newVal = compute(this.val1, this.val2, this.operator);
			
			this.content.add(newVal);
			this.val1 = this.val2;
			this.val2 = newVal;
			this.index++;
			this.save(); //On sauvegarde après chaque calcul pour ne pas perdre les résultats en cas de crash du programme.
		}
	}
	
	/*
	 * Effectue le calcul de a et b avec l'opération operation
	 * Retourne un entier
	 */
	private int compute(int a, int b, String operation) {
		if(operation.equals("add")) {
			return this.add(a, b);
		} else if(operation.equals("sub")) {
			return this.add(-a, b);
		} else if(operation.equals("mult")) {
			return this.mult(a, b);
		} else if(operation.equals("div")) {
			return this.divide(a, b);
		} else {
			//On admet seulement les opérateur add, sub, mult et div.
			throw new IllegalArgumentException("This operator does not exist.");
		}
	}
	
	/*
	 * Fonction réalisant une addition sans utilier +
	 * Retourne a+b
	 */
	public int add(int a, int b){
		int res = a;
		if (b > 0) {
			while(b-- != 0) {
				res++;
			}
		}
		else if (b < 0) {
			while(b++ != 0) {
				res--;
			}
		}
		return res;
	}
	
	/*
	 * Fonction réalisant une multiplication sans utilier *
	 * Retourne a*b
	 */
	public int mult(int a, int b){
		int res = 0;
		if(b > 0) {
			while(b > 0) {
				res = this.add(res, a);
				b--;
			}
		} else {
			while(b < 0) {
				res = this.add(res, a);
				b++;
			}
			res = -res;
		}

		return res;
	}
	
	/*
	 * Fonction réalisant une division entière euclidienne sans utilier /
	 * Retourne le résultat entier de a/b
	 */
	public int divide(int a, int b) {
		if(b == 0) {
			throw new IllegalArgumentException("Argument b cannot be equal to 0");
		}
		
		int res = 0;
		while(b > 0) {
			b = this.add(b,-a);
			res++;
		}
		
		return res;
	}
	
	/*
	 * Retourne la liste chainée contenant les valeurs calculées
	 */
	public ListeChainee getContent() {
		return content;
	}
}
