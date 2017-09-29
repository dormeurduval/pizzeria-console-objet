/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;
/**
 * @author joris
 *
 */
public abstract class OptionMenu {

	public abstract boolean execute(IPizzaDao menu,Scanner questionUser)throws StockageException,IllegalArgumentException, IllegalAccessException;
	
	abstract String getLibelle();
	
	public void affMenu(IPizzaDao menu) throws IllegalArgumentException, IllegalAccessException{
		for(int i=0;i<menu.findAllPizzas().size();i++){
			System.out.println(menu.findAllPizzas().get(i).toStringAnnotation());
		}
	}
}
