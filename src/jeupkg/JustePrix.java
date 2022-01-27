package jeupkg;

import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

//import jeupkg.RandomNumber; 

public class JustePrix {
	
	int rightPrice ;
	int playerPrice ; 
	int countdownDuration;
	boolean timeout ;
	
	
	
	
	public int getRightPrice() {
		return rightPrice;
	}

	public void setRightPrice(int maxNumber) {
		RandomNumber r = new RandomNumber();
		this.rightPrice=r.generateRandomNumber(maxNumber);
	}

	public int getPlayerPrice() {
		return playerPrice;
	}

	public void setPlayerPrice() {
		Player p= new Player(); 
		this.playerPrice=p.getNumber(); 
	}
		

	public int getCountdownDuration() {
		return countdownDuration;
	}

	public void setCountdownDuration(int countdownDuration) {
		this.countdownDuration = countdownDuration;
	}

	public void startCountdown(int duration) {
		JFrame jframe = new JFrame(); 
		JLabel jLabel = new JLabel(); 
		jframe.setLayout(new FlowLayout());
		jframe.setBounds(500, 300, 400, 100);
		
		jframe.add(jLabel);
		jframe.setVisible(true);
		
		Timer timer = new Timer(); 
		
		timer.scheduleAtFixedRate( new TimerTask() {
			int i = duration;
			
			public void run() {
				
				jLabel.setText("Time left: " +i);
				i--;
				
				if(i<0) {
					timer.cancel();
					jLabel.setText("Timeout");
					timeout=true; 
					
					
				}
				
			}
		}, 0, 1000);
    	
    	
	}
	
	
	public boolean isTimeout() {
		return timeout;
	}

	public static void main(String[] args) {
		
		JustePrix jeu = new JustePrix();
		
		jeu.setCountdownDuration(30);
		
		jeu.setRightPrice(1000);
		System.out.println("Le juste prix est généré entre 0 et 1000 à vous de le deviner");
	
        jeu.startCountdown(jeu.getCountdownDuration());
		
		
		jeu.setPlayerPrice();
		System.out.println("Votre prix : " + jeu.playerPrice);
		
		while( (jeu.getPlayerPrice()!=jeu.getRightPrice()) && (!jeu.isTimeout())) {
			
			if (jeu.getPlayerPrice()>jeu.getRightPrice()) {
				System.out.println("C'est moins");
			}else {
				System.out.println("C'est plus");
			}
			
			jeu.setPlayerPrice(); 
			
		} // end while
	
		if (jeu.isTimeout()) {
			System.out.println("Timeout !");
			
		}else {
			System.out.println("C'est gagné !");
			
		}
		
			
		
		
	} // end main

} // end class
