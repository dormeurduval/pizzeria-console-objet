/**
 * 
 */
package pizzeria.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

public class PizzaJdbc implements IPizzaDao {

	static final Logger logger = LoggerFactory.getLogger("");
	
	Connection connection;
	
	ResourceBundle prop;
	String db;
	String url; 
	String user;
	String password;
	
	
	public PizzaJdbc(){
		prop = ResourceBundle.getBundle("jdbc");
		db = prop.getString("jdbc.driverClassName");
		url = prop.getString("jdbc.url"); 
		user = prop.getString("jdbc.username");
		password = prop.getString("jdbc.password");
		
	}
	
	private void openConnection(){
		try {
			Class.forName(db);
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage()); 
		}
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			logger.info(e.getMessage()); 
		}
		
		
	}
	
	private void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			logger.info("Got an exception. " + e.getMessage()); 
		}
	}
	
	public void initiate(){
		List<Pizza> menu = new ArrayList<>();
		menu.add(new Pizza("PEP","Pépéroni",12.50));
		menu.add(new Pizza("MAR","Margherita",14));
		menu.add(new Pizza("REIN","La Reine",11.50));
		menu.add(new Pizza("FRO","La 4 fromages",12));
		menu.add(new Pizza("CAN","La cannibale",12.50));
		menu.add(new Pizza("SAV","La savoyarde",13));
		menu.add(new Pizza("ORI","L'orientale",13.50));
		menu.add(new Pizza("IND","L'indienne",14));
		menu.stream().forEach(this::saveNewPizza);
	}
	
	
	
	public List<Pizza> findAllPizzas() {
		List<Pizza>l=new ArrayList();
		ResultSet resultats;
		PreparedStatement listPizza;
		openConnection();
		try {
			listPizza= connection.prepareStatement("SELECT * FROM PIZZA");
			resultats=listPizza.executeQuery("SELECT * FROM PIZZA");
			while(resultats.next()){
				BigDecimal prix=resultats.getBigDecimal("PRIX");
				String nom = resultats.getString("NOM");
				String code = resultats.getString("CODE");
				CategoriePizza categorie = CategoriePizza.toCategoriePizza(resultats.getString("CATEGORIE"));
				l.add(new Pizza(code,nom,categorie,prix.doubleValue()));
				
			}
			listPizza.close();
		} catch (SQLException e) {
			logger.info(e.getMessage()); 
		}

		closeConnection();
		
		return l;
	}


	public boolean saveNewPizza(Pizza pizza){
		openConnection();
		int value=0;
		try {
			PreparedStatement savePizza= connection.prepareStatement("INSERT INTO PIZZA(NOM,CODE,PRIX,CATEGORIE) VALUES(?,?,?,?)");
			savePizza.setString(1,pizza.getNom());
			savePizza.setString(2,pizza.getCode());
			savePizza.setBigDecimal(3,BigDecimal.valueOf(pizza.getPrix()));
			savePizza.setString(4,pizza.getCategorie().toString());
			
			value=savePizza.executeUpdate();
			savePizza.close();
		} catch (SQLException e) {
			logger.info(e.getMessage()); 
		}
		finally{
			
		}
		
		closeConnection();
		return value>0;
	}


	public boolean updatePizza(String codePizza, Pizza pizza){
		openConnection();
		int value=0;
		
		try {
			PreparedStatement updatePizza= connection.prepareStatement(prop.getString("jdbc.updatePizza"));
			updatePizza.setBigDecimal(1,BigDecimal.valueOf(pizza.getPrix()));
			updatePizza.setString(2,pizza.getCode());
			updatePizza.setString(3,pizza.getNom());
			updatePizza.setString(4,pizza.getCategorie().toString());
			updatePizza.setString(5,codePizza);
			
			value=updatePizza.executeUpdate();
			updatePizza.close();
		} catch (SQLException e) {
			logger.info(e.getMessage()); 
		}
		
		closeConnection();
		return value>0;
	}
	
	public boolean deletePizza(String codePizza) {

		openConnection();
		int value=0;
		try {
			PreparedStatement deletePizza= connection.prepareStatement("DELETE FROM PIZZA WHERE CODE=?");
			deletePizza.setString(1,codePizza);
			value=deletePizza.executeUpdate();
			deletePizza.close();
		} catch (SQLException e) {
			logger.info(e.getMessage()); 
		}
		
		closeConnection();
		return value>0;
	}
	
	/** empty is needed for the interface*/
	public void close(){
		
	}

}
