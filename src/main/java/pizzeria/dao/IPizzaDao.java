/**
 * 
 */
package pizzeria.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import pizzeria.model.Pizza;
/**
 * @author joris
 *
 */
public interface IPizzaDao {
	List<Pizza> findAllPizzas();
	
	boolean saveNewPizza(Pizza pizza);
	boolean updatePizza(String codePizza,Pizza pizza);
	boolean deletePizza(String codePizza);
	void close();
	
}
