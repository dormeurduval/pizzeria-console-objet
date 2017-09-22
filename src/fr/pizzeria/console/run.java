package fr.pizzeria.console;
import java.util.Scanner;

/**
 * 
 * classe principale
 * @author CHAFFARD Joris
 *
 */

public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean end = false;
		Scanner questionUser= new Scanner(System.in);
		
		PizzeriaAdminConsoleApp Menu = new PizzeriaAdminConsoleApp();
		
		while(!end){
			System.out.println("***Pizzeria Administration******");
			System.out.println("1:Lister les pizzas");
			System.out.println("2:Ajouter une nouvelle pizza");
			System.out.println("3:Mettre à jour une pizza");
			System.out.println("4:Supprimé une pizza");
			System.out.println("99:Sortir");
			
			int answer = questionUser.nextInt();
			questionUser.nextLine();
			if(answer==1){
				System.out.println("Liste des pizzas");
				System.out.println();
				Menu.affMenu();
			}
			else if(answer==2){
				System.out.println("Ajout d'une nouvelle pizza");
				System.out.println();
				Menu.affMenu();
				System.out.println("Veuillez saisir le code");
				System.out.println();
				String code=questionUser.nextLine();
				System.out.println("Veuillez saisir le nom(sans espace)");
				System.out.println();
				String nom=questionUser.nextLine();
				System.out.println("Veuillez saisir le prix");
				System.out.println();
				int prix=questionUser.nextInt();
				questionUser.nextLine();
				Menu.ajoutPizza(new Pizza(code,nom,prix));
				System.out.println();
				Menu.affMenu();
			}
			else if(answer==3){
				System.out.println("Mise à jour d'une pizza");
				System.out.println();
				Menu.affMenu();
				System.out.println("Veuillez saisir l'ancien code");
				System.out.println();
				String oldCode=questionUser.nextLine();
				System.out.println("Veuillez saisir le nouveau code");
				System.out.println();
				String newCode=questionUser.nextLine();
				System.out.println("Veuillez saisir le nom(sans espace)");
				System.out.println();
				String nom=questionUser.nextLine();
				System.out.println("Veuillez saisir le prix");
				System.out.println();
				int prix=questionUser.nextInt();
				questionUser.nextLine();
				Menu.changePizza(oldCode, newCode, nom, prix);
				Menu.affMenu();
			}
			else if(answer==4){
				System.out.println("Suppression d'une pizza");
				System.out.println();
				Menu.affMenu();
				System.out.println("Veuillez saisir le code de la pizza à supprimer");
				System.out.println();
				String code=questionUser.nextLine();
				Menu.removePizza(code);
				Menu.affMenu();
			}
			else{
				System.out.println("Aurevoir \u2639");
				end=true;
			}
			System.out.println();
		}
		questionUser.close();
	}

}
