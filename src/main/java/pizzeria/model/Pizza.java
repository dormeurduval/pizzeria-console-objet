package pizzeria.model;


/**
 * 
 * classe qui sert à gérer les pizzas
 * @author CHAFFARD Joris
 *
 */

public class Pizza {

	private int id;
	
	@ToString(uppercase=true)
	private String code;
	
	@ToString(uppercase=true)
	private String nom;
	
	
	@ToString
	private double prix;
	@ToString
	private CategoriePizza categorie;
	static int currentId=0;
	
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
	
	public void changPizza(String code,String nom,double prix){
		this.code=code;
		this.nom = nom;
		this.prix = prix;
	}
}
