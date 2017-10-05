
package pizzeria.ihm;
import java.util.Scanner;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.SavePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

/**
 * AjouterPizzaOptionMenu est la classe permettant d'ajouter une pizza au menu
 * et de l'afficher
 * @author CHAFFARD joris
 *
 */
public class AjouterPizzaOptionMenu extends OptionMenu {
	
	public boolean execute(IPizzaDao menu,Scanner questionUser) throws SavePizzaException, IllegalAccessException{
		logger.info("\n");
		affMenu(menu);
		logger.info("Veuillez saisir le code");
		logger.info("\n");
		String code;
		code = questionUser.nextLine();
		if(code.length()>3){
			throw new SavePizzaException("Code trop long");
		}
		logger.info("Veuillez saisir le nom(sans espace)");
		logger.info("\n");
		String nom;
		nom = questionUser.nextLine();
		logger.info("Veuillez saisir le prix");
		logger.info("\n");
		String str =questionUser.nextLine();
		int prix;
		try{
			  prix = Integer.parseInt(str);
		} catch (NumberFormatException e) {	  
			throw new SavePizzaException("Tu as mal entré ton entier");
		}	
		logger.info("\n");
		logger.info("Taper 1 si vous voulez une pizza avec viande");
		logger.info("Taper 2 si vous voulez une pizza avec poisson");
		logger.info("Taper 3 si vous voulez une pizza sans viande");
		logger.info("Taper 4 si vous ne voulez pas de garniture");
		
		str=questionUser.nextLine();
		
		int indice;
		try{
			  indice = Integer.parseInt(str);
		} catch (NumberFormatException e) {	  
			throw new SavePizzaException("Tu as mal entré ton entier");
		}
		Pizza pizza;
		
		if(indice==1)
			pizza=new Pizza(code,nom,CategoriePizza.VIANDE,prix);
		else if(indice==2)
			pizza=new Pizza(code,nom,CategoriePizza.POISSON,prix);	
		else if(indice==3)
			pizza=new Pizza(code,nom,CategoriePizza.SANS_VIANDE,prix);	
		else if(indice==4)	
			pizza=new Pizza(code,nom,prix);
		else
			throw new SavePizzaException("Tu as entré un entier trop grand");
			
		menu.saveNewPizza(pizza);
		affMenu(menu);
		return true;
		
	}
	
	public String getLibelle(){
		return "Ajout d'une nouvelle pizza";
	}
}