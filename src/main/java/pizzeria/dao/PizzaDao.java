/**
 * 
 */
package pizzeria.dao;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


import pizzeria.model.Pizza;


public class PizzaDao implements IPizzaDao {
	private List<Pizza> menu;
	
	public PizzaDao(){
		menu = new ArrayList<>();
		menu.add(new Pizza("PEP","Pépéroni",12.50));
		menu.add(new Pizza("MAR","Margherita",14));
		menu.add(new Pizza("REIN","La Reine",11.50));
		menu.add(new Pizza("FRO","La 4 fromages",12));
		menu.add(new Pizza("CAN","La cannibale",12.50));
		menu.add(new Pizza("SAV","La savoyarde",13));
		menu.add(new Pizza("ORI","L'orientale",13.50));
		menu.add(new Pizza("IND","L'indienne",14));
	}

	public List<Pizza> findAllPizzas() {
		return menu;
	}

	public boolean saveNewPizza(Pizza pizza) {
		return menu.add(pizza);
	}

	public boolean updatePizza(String codePizza, Pizza pizza) {

		Optional<Pizza> opt=menu.stream().filter(p->p.codeSemblabePizza(codePizza)).findAny();
		opt.ifPresent(p->p.changPizza(codePizza,p.getNom(), p.getPrix()));
		
		return opt.isPresent();
		
	}

	public boolean deletePizza(String codePizza) {
		return menu.removeIf(p->p.codeSemblabePizza(codePizza));
	}	
	
}
