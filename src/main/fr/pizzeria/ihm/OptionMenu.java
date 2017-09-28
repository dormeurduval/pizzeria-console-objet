/**
 * 
 */
package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exeception.StockageException;
/**
 * @author joris
 *
 */
public abstract class OptionMenu {

	abstract boolean execute(IPizzaDao menu,Scanner questionUser)throws StockageException,IllegalArgumentException, IllegalAccessException;
	
	abstract String getLibelle();
	
	public void affMenu(IPizzaDao menu) throws IllegalArgumentException, IllegalAccessException{
		for(int i=0;i<menu.findAllPizzas().size();i++){
			System.out.println(menu.findAllPizzas().get(i).toStringAnnotation());
		}
	}
}
