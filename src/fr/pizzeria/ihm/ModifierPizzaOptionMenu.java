/**
 * 
 */
package fr.pizzeria.ihm;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exeception.SavePizzaException;
import fr.pizzeria.exeception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author joris
 *
 */
public class ModifierPizzaOptionMenu extends OptionMenu {

	public boolean execute(PizzaDao menu,Scanner questionUser) throws UpdatePizzaException{
		System.out.println();
		affMenu(menu);
		System.out.println("Veuillez saisir l'ancien code");
		System.out.println();
		String oldCode=questionUser.nextLine();
		if(oldCode.length()>3){
			throw new UpdatePizzaException("Code trop long");
		}
		System.out.println("Veuillez saisir le nouveau code");
		System.out.println();
		String newCode=questionUser.nextLine();
		if(newCode.length()>3){
			throw new UpdatePizzaException("Code trop long");
		}
		System.out.println("Veuillez saisir le nom(sans espace)");
		System.out.println();
		String nom=questionUser.nextLine();
		System.out.println("Veuillez saisir le prix");
		System.out.println();
		int prix;
		String str =questionUser.nextLine();
		try{
			  prix = Integer.parseInt(str);
		} catch (NumberFormatException e) {	  
			throw new UpdatePizzaException("Tu as mal entré ton entier");
		}
		
		System.out.println();
		System.out.println("Taper 1 si vous voulez une pizza avec viande");
		System.out.println("Taper 2 si vous voulez une pizza avec poisson");
		System.out.println("Taper 3 si vous voulez une pizza sans viande");
		System.out.println("Taper 4 si vous ne voulez pas de garniture");
		
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
		else if(indice==4)	
			pizza=new Pizza(newCode,nom,prix);
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
