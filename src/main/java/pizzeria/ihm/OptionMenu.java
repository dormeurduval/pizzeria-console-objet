/**
 * 
 */
package pizzeria.ihm;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import pizzeria.dao.IPizzaDao;
import pizzeria.exeception.StockageException;

public abstract class OptionMenu {

	@Autowired
	ApplicationContext context;

	@Autowired
	Logger logger;

	@Autowired
	Scanner questionUser;

	@Autowired
	IPizzaDao menu;

	public abstract boolean execute() throws StockageException, IllegalAccessException;

	public abstract String getLibelle();

	public void affMenu() {
		menu.findAllPizzas().stream().forEach(p -> {
			try {
				logger.info(p.toStringAnnotation().toString());
			} catch (IllegalAccessException e) {
				logger.info("We got an exception: " + e.getMessage());
			}
		});
		logger.info("\n");
	}
}
