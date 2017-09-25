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

	public boolean execute(PizzaDao menu,Scanner questionUser) throws DeletePizzaException, IllegalArgumentException, IllegalAccessException{
		System.out.println();
		affMenu(menu);
		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		System.out.println();
		String code=questionUser.nextLine();
		boolean isReussite=menu.deletePizza(code);
		if(!isReussite){
			throw new DeletePizzaException("Suppression a échouée");
		}
		
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Suppression d'une pizza";
	}
}
