/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;

import pizzeria.dao.IPizzaDao;

/**
 * @author joris
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {
	
	public boolean execute(IPizzaDao menu,Scanner questionUser) throws IllegalAccessException{
		logger.info("\n");
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Liste des pizzas";
	}
}
