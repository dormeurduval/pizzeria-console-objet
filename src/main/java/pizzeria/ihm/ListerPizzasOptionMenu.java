/**
 * 
 */
package pizzeria.ihm;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;

@Controller
public class ListerPizzasOptionMenu extends OptionMenu {

	public boolean execute() throws IllegalAccessException, StockageException {
		logger.info("\n");
		affMenu();
		return true;
	}

	public String getLibelle() {
		return "Liste des pizzas";
	}
}
