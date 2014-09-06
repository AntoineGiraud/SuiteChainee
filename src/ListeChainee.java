import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe permettant la gestion d'une liste chain�e
 * <p>
 * Dans la construction de notre liste, tout nouveau maillon sera ajout� en d�but de liste, il devient la t�te.
 * Cependant, nous faisons attention dans nos fonctions que si vous cherchez l'�l�ment 0, il corresponde bien au premier ajout� dans la liste, id est le plus ancien.
 * 
 * @authors Antoine Giraud, Matthieu Faou
 * 
 */
public class ListeChainee {
	private class Maillon {
		public int valeur;
		public Maillon suivant;
		public Maillon(int val, Maillon suiv){
			this.valeur = val;
			this.suivant = suiv;
		}
	}
	
	private Maillon tete; // Maillon en t�te de liste
	
	/**
	 * Constructeur de notre liste cr�ant une liste vide
	 */
	public ListeChainee(){
		this.tete = null;
	}
	
	/**
	 * On ajoute un nouveau maillon � notre liste. Il sera la nouvelle t�te de noter liste.
	 * <p>
	 * Bien comprendre donc que notre premier �lement en t�te est le plus r�cent. Pour acc�der au plus vieux il faut parcourir toute la liste.
	 * 
	 * @param element (int) element � ajouter � notre liste
	 */
	public void add(int element){
		this.tete = new Maillon(element, this.tete);
	}
	
	public void add(String chaine){
		if (chaine.matches("^([0-9]+[,]?[ ]?)+$")) { // On v�rifie que l'on a une chaine du type : "0, 1,2 " ou "0,1, 2, "
			// Si c'est le cas on va parcourir la chaine pour trouver les �l�ments "0, " ou "1," ou "2"
			Pattern pattern = Pattern.compile("([0-9])+[,]?[ ]?");
	        Matcher matcher = pattern.matcher(chaine);
	        boolean found = false;
	        while (matcher.find()) {
	        	String res = matcher.group().trim(); // On s'assure qu'il n'y a plus de " " � la fin de la chaine
	        	if (res.matches("^([0-9]+[,])$")) { // Si jamais on a en element du genre "1," on enl�ve le dernier element la ","
	        		res = res.substring(0, res.length()-1);
				}
	        	int element = Integer.parseInt(res);
	        	this.add(element);
	        	System.out.println(element+";");
	            found = true;
	        }
	        if(!found){
	            System.out.println("No match found.");
	        }
		}else{
			System.out.println("Echec la chaine n'est pas du type: /^([0-9]+[,]?[ ]?)+$/");
		}
	}
	
	/**
	 * Fonction pour vider notre liste
	 */
	public void reset(){
		this.tete = null;
	}
	
	/**
	 * Notre liste est vide si il n'y a pas de maillon, donc si la tete est vide.
	 * @return boolean
	 */
	public boolean isEmpty(){
		return this.tete == null;
	}

	
	/**
	 * Est ce que notre liste contient l'�l�ment X ?
	 * @param element
	 * @return boolean
	 */
	public boolean contains(int element){
		Maillon courant = this.tete;
		while(courant != null){
			if(courant.valeur == element){
				return true;
			}else{
				courant = courant.suivant;
			}
		}
		return false;
	}
	
	/**
	 * Retourne la valeur de l'�lement � la position voulue
	 * @param position (int) cl� / position de l'�l�ment � changer
	 * @return (int) valeur de l'�l�ment num�ro "postion"
	 * @throws IllegalStateException Si on a une liste vide ou une position inconue
	 */
	public int getAt(int position) throws IllegalStateException {
		if (this.tete == null) {
			throw new IllegalStateException("Liste vide !!");
		}
		int size = this.getSize(), i = size - 1;
		if (position < 0  || position > size) {
			throw new IllegalStateException("Position voulue inconue: "+position+" < 0  || "+position+" >= "+size);
		}
		Maillon courant = this.tete;
		while(courant != null){
			if (i == position) {
				return courant.valeur;
			}
			courant = courant.suivant;
			i--;
		}
		throw new IllegalStateException("Erreur, on n'a pas trouv� la position de nouveau ...");
	}
	
	/**
	 * On remplace la valeur de l'�lement qui a la position XX dans notre chaine par une nouvelle XX pass�e en param�tres 
	 * @param element (int) nouvelle valeur
	 * @param position (int) cl� / position de l'�l�ment � changer
	 * @throws IllegalStateException Si on a une liste vide ou une position inconue
	 */
	public void setAt(int element, int position) throws IllegalStateException {
		if (this.tete == null) {
			throw new IllegalStateException("Liste vide !!");
		}
		int size = this.getSize(), i = size - 1;
		if (position < 0  || position > size) {
			throw new IllegalStateException("Position voulue inconue: "+position+" < 0  || "+position+" >= "+size);
		}
		Maillon courant = this.tete;
		while(courant != null){
			if (i == position) {
				courant.valeur = element;
				break;
			}
			courant = courant.suivant;
			i--;
		}
	}
	
	/**
	 * On retire le maillon qui a la cl� / est � la position xx
	 * @param position (int) position du maillon / de la valeur � retirer
	 */
	public void removeAt(int position) {
		if (this.tete == null) {
			throw new IllegalStateException("Liste vide !!");
		}
		int size = this.getSize(), i = size - 1;
		if (position < 0  || position >= size) {
			throw new IllegalStateException("Position voulue inconue: "+position+" < 0  || "+position+" >= "+size);
		}
		Maillon courant = this.tete, prev = null;
		while(courant != null){
			if (i == position) {
				if (prev == null && i == (size - 1) ) {
					if (courant.suivant == null) {
						this.tete = null;
					}else {
						this.tete.valeur = courant.suivant.valeur;
						this.tete.suivant = courant.suivant.suivant;
					}
				}else{
					prev.suivant = courant.suivant;
				}
				break;
			}
			prev = courant;
			courant = courant.suivant;
			i--;
		}
	}
	
	/**
	 * on parcours toute notre liste pour retirer tous les �l�ments qui sont �gaux � celui pass� en param�tre.
	 * @param element (int)
	 */
	public void removeItem(int element) {
		if (this.tete == null) {
			throw new IllegalStateException("Liste vide !!");
		}
		Maillon courant = this.tete, prev = null;
		while(courant != null){
			if (courant.valeur == element) { // On le supprime
				if (prev == null) { // Si on est sur la t�te
					if (courant.suivant == null) { // On supprime la t�te le seul maillon
						this.tete = null;
						break;
					}else { // On supprime le maillon de t�te et on le remplace par le suivant qui n'est pas vide
						this.tete.valeur = courant.suivant.valeur;
						this.tete.suivant = courant.suivant.suivant;
						courant = this.tete;
					}
				}else{ // Cas simple, on n'�tait pas en t�te
					prev.suivant = courant.suivant;
					courant = prev.suivant;
				}
				// On a retir� le maillon, on veut tester le maillon qui a pris sa place !
			}else{
				prev = courant;
				courant = courant.suivant;
			}
		}
	}
	
	/**
	 * Fonction qui retourne la taille de notre liste chain�e
	 * @return (int) Taille de notre liste chain�e
	 */
	public int getSize(){
		Maillon courant = this.tete;
		int nb = 0;
		while(courant != null){
			courant = courant.suivant;
			nb++;
		}
		return nb;
	}
	
	/**
	 * On va afficher le contenu de notre liste chain�e dans l'ordre dans lequels les �l�ments ont �t� ajout�s
	 * <br>C'est � dire dans l'ordre des cl�s si jamais on avait : 0 => 1er elnt, 1 => 2e elnt, ...
	 * <br>Pour ce faire, on utilise la fonction showByKeyOrderedAsc : elle est plus longue que showByKeyOrderedDesc...
	 */
	public void show() {
		this.showByKeyOrderedAsc();
	}
	
	/**
	 * On parcours directement la chaine une seule fois et on affiche les valeurrs rencontr�es.
	 * <br>Comme on ajoute les nouvelles valeurs au d�but de notre pile, on affiche alors les valeurs dans l'ordre du plus r�cent au plus ancien
	 */
	public void showByKeyOrderedDesc() {
		if (this.tete == null) {
			System.out.print("Liste vide !!");
		}
		Maillon courant = this.tete;
		while(courant != null){
			System.out.print(courant.valeur + ((courant.suivant != null)?", ":""));
			courant = courant.suivant;
		}
		System.out.println("");
	}
	
	/**
	 * On parcours une premiere fois la liste pour ajouter les valeurs au fur et � mesure dans une nouvelle liste.
	 * <br>La nouvelle liste aura alors les valeurs les plus anciennes en t�te. On aura invers� la pile.
	 */
	public void showByKeyOrderedAsc() {
		if (this.tete == null) {
			System.out.println("Liste vide !!");
		}else{
			System.out.println(this.toString());
		}
	}
	
	/**
	 * On retourne une chaine de caract�re des �l�ments de la liste dans l'ordre d'ajout de ceux-ci s�par�s par des virgules
	 */
	@Override
	public String toString() {
		String retour = "";
		if (this.tete == null) {
			return retour;
		}else{
			ListeChainee L = new ListeChainee();
			Maillon courant = this.tete;
			while(courant != null){
				L.add(courant.valeur);
				courant = courant.suivant;
			}
			courant = L.tete;
			while(courant != null){
				retour += courant.valeur+", "; 
				courant = courant.suivant;
			}
		}
		retour = retour.substring(0, retour.length()-2); // On enl�ve le dernier ", "
		return retour;
	}
}