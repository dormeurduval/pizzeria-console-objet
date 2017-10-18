package pizzeria.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * classe qui sert à gérer les pizzas
 * @author CHAFFARD Joris
 *
 */
@Entity
@Table(name="pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	@ToString(uppercase=true)
	private String code;
	
	@Column
	@ToString(uppercase=true)
	private String nom;
	
	
	@Column
	@ToString
	private double prix;
	
	@ToString
	@Enumerated(EnumType.STRING)
	private CategoriePizza categorie;
	
	static int currentId=0;
	
	
	public Pizza(){
		
	}

	
	public Pizza(String code,String nom,double prix){
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.id = currentId;
		currentId++;
	}
	
	public Pizza(String code,String nom,CategoriePizza categorie,double prix){
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.id = currentId;
		this.categorie = categorie;
		currentId++;
	}
		
	public String toString(){
		if(categorie!=null)
			return code+" -> "+nom+" "+"categorie: " +categorie.toString()+" "+"("+ +prix+"euros)";
		else
			return code+" -> "+nom+"("+ prix+"euros)";
	}
	
	
	
	public StringBuilder toStringAnnotation() throws IllegalAccessException{
		
		StringBuilder s=new StringBuilder();
		Class classe = this.getClass();
		for (java.lang.reflect.Field fields : classe.getDeclaredFields() ){
				if(fields.isAnnotationPresent(ToString.class)){
					if(!fields.getAnnotation(ToString.class).uppercase()){
						s = s.append(fields.getName()).append(" = ").append(fields.get(this)).append(" ");
					}
					else{
						s = s.append(fields.getName().toUpperCase()).append(" = ")
								.append(((String)fields.get(this)).toUpperCase()).append(" ");
					}
						
				}
		}
		
		
		return s;
	}
	
	public boolean codeSemblabePizza(String code){
		return code.equals(this.code);
	}
	
	public void changPizza(Pizza p){
		this.code=p.getCode();
		this.nom = p.getNom();
		this.prix = p.getPrix();
		this.categorie=p.getCategorie();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;

	}
	
	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
}
