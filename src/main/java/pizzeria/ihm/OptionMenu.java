/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;

import org.apache.log4j.Logger;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;
/**
 * @author joris
 *
 */
public abstract class OptionMenu {

	final Logger logger = Logger.getLogger(OptionMenu.class);
	
	public abstract boolean execute(IPizzaDao menu,Scanner questionUser)throws StockageException, IllegalAccessException;
	
	abstract String getLibelle();
	
	public void affMenu(IPizzaDao menu) throws IllegalAccessException{
		for(int i=0;i<menu.findAllPizzas().size();i++){
			logger.info(menu.findAllPizzas().get(i).toStringAnnotation());
		}
	}
}
