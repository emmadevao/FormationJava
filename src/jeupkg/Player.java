package jeupkg;

import java.util.Scanner ;

public class Player {
	
	int playerNumber;
	
	public int getNumber() {
		
		Scanner sc = new Scanner (System.in); 
		System.out.println("Tentez votre chance : ");
		String str = sc.nextLine(); 
		//sc.close();
		
		try {
			
		    playerNumber = Integer.parseInt(str);
			
		}catch (NumberFormatException e) {
			
			System.out.println("Vous n'avez pas saisi un nombre");
		}
		
		return playerNumber;
	}

}
