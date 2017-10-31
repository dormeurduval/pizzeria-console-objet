package pizzeria.console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pizzeria.config.ServicesConfig;
import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaDao;
import pizzeria.exeception.StockageException;
import pizzeria.ihm.AjouterPizzaOptionMenu;
import pizzeria.ihm.ListerPizzasOptionMenu;
import pizzeria.ihm.ModifierPizzaOptionMenu;
import pizzeria.ihm.OptionMenu;
import pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {
	
	AnnotationConfigApplicationContext context;
	
	
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class)) {
			ConsoleApp menu = context.getBean(ConsoleApp.class);
			menu.execute();
		}
		
	}

}
