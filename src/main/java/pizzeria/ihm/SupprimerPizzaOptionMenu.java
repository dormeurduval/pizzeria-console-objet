/**
 * 
 */
package pizzeria.ihm;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.DeletePizzaException;
import pizzeria.exeception.StockageException;

@Controller
public class SupprimerPizzaOptionMenu extends OptionMenu {

	public boolean execute() throws IllegalAccessException, StockageException {
		logger.info("\n");
		affMenu();
		logger.info("Veuillez saisir le code de la pizza à supprimer");
		logger.info("\n");
		String code = questionUser.nextLine();
		boolean isReussite = menu.deletePizza(code);
		if (!isReussite) {
			throw new DeletePizzaException("Suppression a échouée");
		}

		affMenu();
		return true;
	}

	public String getLibelle() {
		return "Suppression d'une pizza";
	}
}
