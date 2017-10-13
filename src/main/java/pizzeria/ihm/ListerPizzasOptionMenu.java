/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;


public class ListerPizzasOptionMenu extends OptionMenu {
	
	public boolean execute(IPizzaDao menu,Scanner questionUser) throws IllegalAccessException, StockageException{
		logger.info("\n");
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Liste des pizzas";
	}
}
