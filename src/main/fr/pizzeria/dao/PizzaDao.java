/**
 * 
 */
package fr.pizzeria.dao;

import java.util.ArrayList;


import fr.pizzeria.model.Pizza;

/**
 * @author joris
 *
 */
public class PizzaDao implements IPizzaDao {
	private ArrayList<Pizza> menu;
	
	public PizzaDao(){
		menu = new ArrayList<Pizza>();
		menu.add(new Pizza("PEP","Pépéroni",12.50));
		menu.add(new Pizza("MAR","Margherita",14));
		menu.add(new Pizza("REIN","La Reine",11.50));
		menu.add(new Pizza("FRO","La 4 fromages",12));
		menu.add(new Pizza("CAN","La cannibale",12.50));
		menu.add(new Pizza("SAV","La savoyarde",13));
		menu.add(new Pizza("ORI","L'orientale",13.50));
		menu.add(new Pizza("IND","L'indienne",14));
	}

	public ArrayList<Pizza> findAllPizzas() {
		return menu;
	}

	public boolean saveNewPizza(Pizza pizza) {
		menu.add(pizza);
		return true;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).codeSemblabePizza(codePizza)){
				menu.set(i,pizza);
			}
		}
		return true;
		
	}

	public boolean deletePizza(String codePizza) {
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).codeSemblabePizza(codePizza)){
				menu.remove(i);
			}
		}
		return true;
	}	
	
}
