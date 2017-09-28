package fr.pizzeria.console;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exeception.SavePizzaException;
/**
 * 
 * classe principale
 * @author CHAFFARD Joris
 *
 */
import fr.pizzeria.ihm.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean end = false;
		final Scanner questionUser= new Scanner(System.in);
		
		PizzaDao menu = new PizzaDao();
		
		AjouterPizzaOptionMenu ajout = new AjouterPizzaOptionMenu();
		ListerPizzasOptionMenu listage = new ListerPizzasOptionMenu();
		ModifierPizzaOptionMenu modification = new ModifierPizzaOptionMenu();
		SupprimerPizzaOptionMenu suppression = new SupprimerPizzaOptionMenu();
		
		
		while(!end){
			try {
				System.out.println("***Pizzeria Administration******");
				System.out.println("1:Lister les pizzas");
				System.out.println("2:Ajouter une nouvelle pizza");
				System.out.println("3:Mettre à jour une pizza");
				System.out.println("4:Supprimé une pizza");
				System.out.println("99:Sortir");
				
				int answer = questionUser.nextInt();
				questionUser.nextLine();
				if(answer==1){
					System.out.println(listage.getLibelle());
					listage.execute(menu, questionUser);
				}
				else if(answer==2){
					System.out.println(ajout.getLibelle());
					ajout.execute(menu, questionUser);
				}
				else if(answer==3){
					System.out.println(modification.getLibelle());
					modification.execute(menu, questionUser);
				}
				else if(answer==4){
					System.out.println(suppression.getLibelle());
					suppression.execute(menu, questionUser);
				}
				else{
					System.out.println("Aurevoir \u2639");
					end=true;
				}
				System.out.println();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		questionUser.close();
	}

}
