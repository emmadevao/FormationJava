package jeupkg;

import java.util.Random; 

public class RandomNumber {
	
	
	
	public int generateRandomNumber(int nbMax) {
		
		Random r = new Random(); 
		int number = r.nextInt(nbMax);
		return number; 
	}

}
