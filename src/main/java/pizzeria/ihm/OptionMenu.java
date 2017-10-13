/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;


public abstract class OptionMenu {

	static final Logger logger = LoggerFactory.getLogger("");
	
	
	public abstract boolean execute(IPizzaDao menu,Scanner questionUser)throws StockageException, IllegalAccessException;
	
	public abstract String getLibelle();
	
	public static void affMenu(IPizzaDao menu){
		menu.findAllPizzas().stream().forEach(p->{
			try {
				logger.info(p.toStringAnnotation().toString());
			} catch (IllegalAccessException e) {
				logger.info("We got an exception: "+e.getMessage());
			}
		});
		logger.info("\n");
	}
}
