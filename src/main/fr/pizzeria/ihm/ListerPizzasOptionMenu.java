/**
 * 
 */
package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * @author joris
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {
	
	public boolean execute(IPizzaDao menu,Scanner questionUser) throws IllegalArgumentException, IllegalAccessException{
		System.out.println();
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Liste des pizzas";
	}
}
