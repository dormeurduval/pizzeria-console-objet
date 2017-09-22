/**
 * 
 */
package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * @author joris
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu {

	public boolean execute(PizzaDao menu,Scanner questionUser){
		System.out.println();
		affMenu(menu);
		System.out.println("Veuillez saisir l'ancien code");
		System.out.println();
		String oldCode=questionUser.nextLine();
		System.out.println("Veuillez saisir le nouveau code");
		System.out.println();
		String newCode=questionUser.nextLine();
		System.out.println("Veuillez saisir le nom(sans espace)");
		System.out.println();
		String nom=questionUser.nextLine();
		System.out.println("Veuillez saisir le prix");
		System.out.println();
		int prix=questionUser.nextInt();
		questionUser.nextLine();
		menu.updatePizza(oldCode,new Pizza(newCode,nom,prix));
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Mise à jour d'une pizza";
	}
}
