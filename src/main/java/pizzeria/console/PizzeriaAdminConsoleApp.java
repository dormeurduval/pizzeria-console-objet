package pizzeria.console;
import java.util.HashMap;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaDao;
import pizzeria.exeception.StockageException;
import pizzeria.exeception.UpdatePizzaException;
import pizzeria.ihm.*;

public class PizzeriaAdminConsoleApp {
	static final Logger logger = LoggerFactory.getLogger("");
	
	public static void main(String[] args) throws IllegalAccessException, StockageException {
		
		final Scanner questionUser= new Scanner(System.in);
		
		IPizzaDao menu = new PizzaDao();
		
		HashMap<String,OptionMenu> optionMenu = new HashMap<>();
		final Logger logger = LoggerFactory.getLogger("");
		
		optionMenu.put("1",new ListerPizzasOptionMenu());
		optionMenu.put("2",new AjouterPizzaOptionMenu());
		optionMenu.put("3",new ModifierPizzaOptionMenu());
		optionMenu.put("4",new SupprimerPizzaOptionMenu());
		Boolean cont = true;
		while(cont){
			try {
				logger.info("***Pizzeria Administration******");
				logger.info("1:Lister les pizzas");
				logger.info("2:Ajouter une nouvelle pizza");
				logger.info("3:Mettre à jour une pizza");
				logger.info("4:Supprimé une pizza");
				logger.info("99:Sortir");
				
				String answer = questionUser.nextLine();
				
				if(optionMenu.get(answer)!=null){
					logger.info(optionMenu.get(answer).getLibelle()+"\n");
					optionMenu.get(answer).execute(menu, questionUser);
				}
				else if(answer=="99"){
					logger.info("Aurevoir");
				}
				else{
					logger.info("Tu as mal entré ton entier");
				}
			} catch (StockageException e) {
				logger.info(e.getMessage());
			}
			
		}
		
		
		
		
	}

}
