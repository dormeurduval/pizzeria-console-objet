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
public abstract class OptionMenu {

	abstract boolean execute(PizzaDao menu,Scanner questionUser);
	
	abstract String getLibelle();
	
	public void affMenu(PizzaDao menu){
		for(int i=0;i<menu.findAllPizzas().size();i++){
			menu.findAllPizzas().get(i).affPizza();
		}
	}
}
