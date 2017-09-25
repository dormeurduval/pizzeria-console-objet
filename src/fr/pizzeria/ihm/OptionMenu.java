/**
 * 
 */
package fr.pizzeria.ihm;
import java.util.Scanner;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exeception.SavePizzaException;
import fr.pizzeria.exeception.StockageException;
/**
 * @author joris
 *
 */
public abstract class OptionMenu {

	abstract boolean execute(PizzaDao menu,Scanner questionUser)throws StockageException,IllegalArgumentException, IllegalAccessException;
	
	abstract String getLibelle();
	
	public void affMenu(PizzaDao menu) throws IllegalArgumentException, IllegalAccessException{
		for(int i=0;i<menu.findAllPizzas().size();i++){
			System.out.println(menu.findAllPizzas().get(i).toStringAnnotation());
		}
	}
}
