package fr.pizzeria.model;
import java.util.LinkedList;

/**
 * 
 * classe qui sert à gérer les menus de pizzas
 * @author CHAFFARD Joris
 *
 */


public class Menu {
	private LinkedList<Pizza> menu;

	public Menu(){
		menu = new LinkedList<Pizza>();
		menu.add(new Pizza("PEP","Pépéroni",12.50));
		menu.add(new Pizza("MAR","Margherita",14));
		menu.add(new Pizza("REIN","La Reine",11.50));
		menu.add(new Pizza("FRO","La 4 fromages",12));
		menu.add(new Pizza("CAN","La cannibale",12.50));
		menu.add(new Pizza("SAV","La savoyarde",13));
		menu.add(new Pizza("ORI","L'orientale",13.50));
		menu.add(new Pizza("IND","L'indienne",14));
	}

	public LinkedList<Pizza> getList() {
		return menu;
	}

	public void setList(LinkedList<Pizza> menu) {
		this.menu = menu;
	}
	
	public void affMenu(){
		for(int i=0;i<menu.size();i++){
			menu.get(i).affPizza();
		}
	}
	
	public void ajoutPizza(Pizza pizza){
		menu.add(pizza);
	}
	
	public void changePizza(String oldCode,String newCode,String nom,double prix){
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).codeSemblabePizza(oldCode)){
				menu.get(i).changPizza(newCode, nom, prix);
			}
		}
	}
	
	public void removePizza(String code){
		for(int i=0;i<menu.size();i++){
			if(menu.get(i).codeSemblabePizza(code)){
				menu.remove(i);
			}
		}
	}
	
}
