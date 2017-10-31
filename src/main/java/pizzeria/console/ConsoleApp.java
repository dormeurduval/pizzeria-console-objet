/**
 * 
 */
package pizzeria.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;
import pizzeria.ihm.AjouterPizzaOptionMenu;
import pizzeria.ihm.ListerPizzasOptionMenu;
import pizzeria.ihm.ModifierPizzaOptionMenu;
import pizzeria.ihm.OptionMenu;

/**
 * @author joris
 *
 */
@Controller
public class ConsoleApp {

	@Autowired
	Scanner questionUser;
	
	@Autowired
	Logger logger;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	Map<String,OptionMenu> optionMenu;
	
	@Autowired
	IPizzaDao menu;
	
	private int num(OptionMenu opt){
		if(opt instanceof ListerPizzasOptionMenu)
			return 1;
		else if(opt instanceof AjouterPizzaOptionMenu)
			return 2;
		else if(opt instanceof ModifierPizzaOptionMenu)
			return 3;
		else
			return 4;
	}
	
	@PostConstruct
	public void init(){
		optionMenu= new HashMap<>();
		context.getBeansOfType(OptionMenu.class).forEach((id,opt)->{
			optionMenu.put(String.valueOf(num(opt)), opt);
		});
	}
	
	/** Methods
	 * @param menu
	 * @param logger
	 * @param cont
	 * @return
	 */
	public void execute() {
		boolean cont = true;
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
					try {
						optionMenu.get(answer).execute();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				else if(answer.equals("99")){
					logger.info("Aurevoir");
					cont=false;
				}
				else{
					logger.info("Tu as mal entré ton entier");
				}
			} catch (StockageException e) {
				logger.info(e.getMessage());
			}
				
		}
		//menu.close();
	}
	
	
}
