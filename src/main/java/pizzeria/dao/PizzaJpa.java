
package pizzeria.dao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import pizzeria.model.Pizza;


public class PizzaJpa implements IPizzaDao {

	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;

	public PizzaJpa(){
		entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
	}
	
	public void close(){
		entityManagerFactory.close();
	}
	

	
	public List<Pizza> findAllPizzas() {
		openManager();
		List l = entityManager.createQuery("from Pizza p").getResultList();
		closeManager();
		return l;
	}


	public boolean saveNewPizza(Pizza pizza) {
		openManager();
		entityManager.getTransaction().begin();
		entityManager.persist(pizza);
		entityManager.getTransaction().commit();
		closeManager();
		return true;
	}


	public boolean updatePizza(String codePizza, Pizza pizza) {
		openManager();
		
		List result= entityManager.createQuery(getPizza(codePizza)).getResultList();
		if(result.isEmpty()){
			closeManager();
			return false;	
		}	
		else{
			Pizza pizzaChange = (Pizza) result.get(0);
		
			pizzaChange.changPizza(pizza);
			
			entityManager.getTransaction().begin();
			entityManager.merge(pizzaChange);
			entityManager.getTransaction().commit();
			closeManager();
			return true;
		}	
	}


	public boolean deletePizza(String codePizza) {
		openManager();
		List result= entityManager.createQuery(getPizza(codePizza)).getResultList();
		if(result.isEmpty()){
			closeManager();
			return false;
		}	
		else{	
			Pizza pizzaRemove = (Pizza) result.get(0);
	
			entityManager.getTransaction().begin();
			entityManager.remove(pizzaRemove);
			entityManager.getTransaction().commit();
			closeManager();
			return true;
		}	
	}
	
	private String getPizza(String codePizza){
		return "from Pizza p where p.code="+"'"+codePizza
				+"'";
	}
	
	private void openManager(){
		entityManager= entityManagerFactory.createEntityManager();
	}
	
	private void closeManager(){
		entityManager.close();
	}

}
