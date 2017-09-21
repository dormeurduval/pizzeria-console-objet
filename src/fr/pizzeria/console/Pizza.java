package fr.pizzeria.console;

public class Pizza {
	private int id;
	private String code;
	private String nom;
	private double prix;
	static int current_id=0;
	
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
	
	public Pizza(String code,String nom,double prix){
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.id = current_id;
		current_id++;
	}
		
	
	public void affPizza(){
		System.out.println(code+" -> "+nom+"("+prix+"euros)");
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
