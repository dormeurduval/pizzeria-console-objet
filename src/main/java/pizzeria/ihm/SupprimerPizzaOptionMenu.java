/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;


import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.DeletePizzaException;


/**
 * @author joris
 *
 */
public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	public boolean execute(IPizzaDao menu,Scanner questionUser) throws DeletePizzaException, IllegalAccessException{
		logger.info("\n");
		affMenu(menu);
		logger.info("Veuillez saisir le code de la pizza à supprimer");
		logger.info("\n");
		String code=questionUser.nextLine();
		boolean isReussite=menu.deletePizza(code);
		if(!isReussite){
			throw new DeletePizzaException("Suppression a échouée");
		}
		
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Suppression d'une pizza";
	}
}
