import java.util.Scanner;

public class run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean end = false;
		
		while(!end){
			System.out.println("***Pizzeria Administration******");
			System.out.println("1:Lister les pizzas");
			System.out.println("2:Ajouter une nouvelle pizza");
			System.out.println("3:Mettre à jour une pizza");
			System.out.println("4:Supprimé une pizza");
			System.out.println("99:Sortir");
			
			Scanner questionUser= new Scanner(System.in);
			int answer = questionUser.nextInt();
			if(answer==1){
				
			}
			else if(answer==2){
				
			}
			else if(answer==3){
				
			}
			else if(answer==4){
				
			}
			else{
				end=true;
			}
		}	
	}

}
