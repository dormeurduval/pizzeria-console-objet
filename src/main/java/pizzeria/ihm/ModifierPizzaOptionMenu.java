/**
 * 
 */
package pizzeria.ihm;
import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;
import pizzeria.exeception.UpdatePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;


/**
 * @author joris
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public boolean execute(IPizzaDao menu,Scanner questionUser) throws IllegalAccessException, StockageException{
		logger.info("\n");
		affMenu(menu);
		logger.info("Veuillez saisir l'ancien code");
		logger.info("\n");
		String oldCode=questionUser.nextLine();

		logger.info("Veuillez saisir le nouveau code");
		logger.info("\n");
		String newCode=questionUser.nextLine();
		if(newCode.length()>3){
			throw new UpdatePizzaException("Code trop long");
		}
		logger.info("Veuillez saisir le nom(sans espace)");
		logger.info("\n");
		String nom=questionUser.nextLine();
		logger.info("Veuillez saisir le prix");
		logger.info("\n");
		int prix;
		String str =questionUser.nextLine();
		try{
			  prix = Integer.parseInt(str);
		} catch (NumberFormatException e) {	  
			throw new UpdatePizzaException("Tu as mal entré ton entier");
		}
		
		logger.info("\n");
		logger.info("Taper 1 si vous voulez une pizza avec viande");
		logger.info("Taper 2 si vous voulez une pizza avec poisson");
		logger.info("Taper 3 si vous voulez une pizza sans viande");
		
		str=questionUser.nextLine();
		
		int indice;
		try{
			  indice = Integer.parseInt(str);
		} catch (NumberFormatException e) {	  
			throw new UpdatePizzaException("Tu as mal entré ton entier");
		}
		
		Pizza pizza;
		
		if(indice==1)
			pizza=new Pizza(newCode,nom,CategoriePizza.VIANDE,prix);
		else if(indice==2)
			pizza=new Pizza(newCode,nom,CategoriePizza.POISSON,prix);	
		else if(indice==3)
			pizza=new Pizza(newCode,nom,CategoriePizza.SANS_VIANDE,prix);	
		else
			throw new UpdatePizzaException("Tu as entré un entier trop grand");
		
		menu.updatePizza(oldCode,pizza);
		affMenu(menu);
		return true;
	}
	
	public String getLibelle(){
		return "Mise à jour d'une pizza";
	}
}
