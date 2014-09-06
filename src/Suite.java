import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Suite {
	String path;
	String operator;
	int val1;
	int val2;
	int index;
	int length;
	ListeChainee content;
	
	public Suite(String path, String operator, int val1, int val2, int length, boolean emptyState) {
		this.path = path;
		this.operator = operator;
		this.val1 = val1;
		this.val2 = val2;
		this.length = length;
		
		if(emptyState) {
			//content est une liste vide -> On la remet à 0.
			content.reset();
		} else {
			// TODO
			//On charge dans content les entrees contenues dqns le fichier properties
		}
	}
	
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
	
	public int divide(int a, int b) {
		//Compute a/b
		if(b == 0) {
			throw new IllegalArgumentException("Argument b is 0");
		}
		
		int res = 0;
		while(b > 0) {
			b = add(b,-a);
			res++;
		}
		
		return res;
		
	}
	
	private void load() {
        Properties properties = new Properties();
 
        File f = new File(this.path);
        FileInputStream fileInputStream = null;
        
		try {
			fileInputStream = new FileInputStream(f);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if (fileInputStream == null) {
            //Le fichier properties n'existe pas encore, on le cree
        } else {
        	//Sinon, on charge les valeurs deja calculee et on met a jour les parametres
        	String contenue = properties.getProperty("Contenue");
        	this.index = Integer.parseInt(properties.getProperty("Indexe"));
        }
        
        this.save();
	}
	
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
	 * vérifie si le dernier contenu de la chaine écrit est valide ou pas (vérifie bien une suite)
	 * <p>
	 * isValid() s’applique seulement sur le fichier .properties
	 * Cette méthode peut être implanter dans la classe où on fait la construction de la suite chainée.
	 * </p> 
	 * @return (boolean) Est ce que la chaine est valide ou non ?!
	 */
	private boolean isValid() {
		// TODO
		return false;
	}
}
