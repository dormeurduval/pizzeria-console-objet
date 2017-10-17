/**
 * 
 */
package pizzeria.model;

/**
 * @author joris
 *
 */
public enum CategoriePizza {

	VIANDE("Viande"),POISSON("Poisson"),SANS_VIANDE("Sans Viande");
	
	private String nom;
	private CategoriePizza(String nom){
		this.nom = nom;
	}
	
	@Override
	public String toString(){
		return nom;
	}
	
	public static CategoriePizza toCategoriePizza(String s){
		if(s==null)
			return null;
		if(s.equals("Viande")){
			return CategoriePizza.VIANDE;
		}
		else if(s.equals("Poisson")){
			return CategoriePizza.POISSON;
		}
		else if(s.equals("Sans Viande")){
			return CategoriePizza.SANS_VIANDE;
		}
		else
			return null;
	}
}
