package pizzeria.console;
import java.util.Scanner;
import java.util.logging.Logger;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaDao;
import pizzeria.ihm.*;

public class PizzeriaAdminConsoleApp {
	static final Logger logger = Logger.getLogger("");
	
	public static void main(String[] args) {
		
		boolean end = false;
		final Scanner questionUser= new Scanner(System.in);
		
		IPizzaDao menu = new PizzaDao();
		
		AjouterPizzaOptionMenu ajout = new AjouterPizzaOptionMenu();
		ListerPizzasOptionMenu listage = new ListerPizzasOptionMenu();
		ModifierPizzaOptionMenu modification = new ModifierPizzaOptionMenu();
		SupprimerPizzaOptionMenu suppression = new SupprimerPizzaOptionMenu();
		
		
		while(!end){
			try {
				logger.info("***Pizzeria Administration******");
				logger.info("1:Lister les pizzas");
				logger.info("2:Ajouter une nouvelle pizza");
				logger.info("3:Mettre à jour une pizza");
				logger.info("4:Supprimé une pizza");
				logger.info("99:Sortir");
				
				int answer = questionUser.nextInt();
				questionUser.nextLine();
				if(answer==1){
					logger.info(listage.getLibelle());
					listage.execute(menu, questionUser);
				}
				else if(answer==2){
					logger.info(ajout.getLibelle());
					ajout.execute(menu, questionUser);
				}
				else if(answer==3){
					logger.info(modification.getLibelle());
					modification.execute(menu, questionUser);
				}
				else if(answer==4){
					logger.info(suppression.getLibelle());
					suppression.execute(menu, questionUser);
				}
				else{
					logger.info("Aurevoir \u2639");
					end=true;
				}
				logger.info("\n");
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		questionUser.close();
	}

}
