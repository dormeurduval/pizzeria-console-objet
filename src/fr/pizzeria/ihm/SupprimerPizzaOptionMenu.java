/**
 * 
 */
package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exeception.DeletePizzaException;
import fr.pizzeria.exeception.UpdatePizzaException;

/**
 * @author joris
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {

	public boolean execute(PizzaDao menu,Scanner questionUser) throws DeletePizzaException{
		System.out.println();
		affMenu(menu);
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		System.out.println();
		String code=questionUser.nextLine();
		if(code.length()>3){
			throw new DeletePizzaException("Code trop long");
		}
		menu.deletePizza(code);
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Suppression d'une pizza";
	}
}
