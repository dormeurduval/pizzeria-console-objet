/**
 * 
 */
package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;

/**
 * @author joris
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {

	public boolean execute(PizzaDao menu,Scanner questionUser){
		System.out.println();
		affMenu(menu);
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		System.out.println();
		String code=questionUser.nextLine();
		menu.deletePizza(code);
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Suppression d'une pizza";
	}
}
