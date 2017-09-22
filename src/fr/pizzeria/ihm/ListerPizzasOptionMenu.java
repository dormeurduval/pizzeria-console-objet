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
public class ListerPizzasOptionMenu extends OptionMenu {
	
	public boolean execute(PizzaDao menu,Scanner questionUser){
		System.out.println();
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Liste des pizzas";
	}
}
