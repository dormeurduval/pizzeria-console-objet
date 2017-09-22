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
public class AjouterPizzaOptionMenu extends OptionMenu {

	public boolean execute(PizzaDao menu,Scanner questionUser){
		System.out.println();
		affMenu(menu);
		System.out.println("Veuillez saisir le code");
		System.out.println();
		String code=questionUser.nextLine();
		System.out.println("Veuillez saisir le nom(sans espace)");
		System.out.println();
		String nom=questionUser.nextLine();
		System.out.println("Veuillez saisir le prix");
		System.out.println();
		int prix=questionUser.nextInt();
		questionUser.nextLine();
		menu.saveNewPizza(new Pizza(code,nom,prix));
		System.out.println();
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Ajout d'une nouvelle pizza";
	}
}
