/**
 * 
 */
package fr.pizzeria.model;

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
	
	public String toString(){
		return nom;
	}
}
