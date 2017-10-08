/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;
import java.util.logging.Logger;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;


public abstract class OptionMenu {

	final Logger logger = Logger.getLogger("");
	
	public abstract boolean execute(IPizzaDao menu,Scanner questionUser)throws StockageException, IllegalAccessException;
	
	abstract String getLibelle();
	
	public void affMenu(IPizzaDao menu){
		menu.findAllPizzas().stream().forEach(p->{
			try {
				logger.info(p.toStringAnnotation().toString());
			} catch (IllegalAccessException e) {
				logger.info("We got an exception: "+e.getMessage());
			}
		});
	}
}
