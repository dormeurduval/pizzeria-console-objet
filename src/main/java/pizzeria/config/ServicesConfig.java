/**
 * 
 */
package pizzeria.config;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pizzeria.dao.IPizzaDao;
import pizzeria.dao.PizzaDao;

@Configuration
@ComponentScan({"pizzeria.ihm","pizzeria.console","pizzeria.console"})
public class ServicesConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
	
	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger("");
	}
	
	@Bean 
	public IPizzaDao pizzaDao(){
		return new PizzaDao();
	}

}
