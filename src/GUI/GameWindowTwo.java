package GUI;

import javax.swing.JFrame;

public class GameWindowTwo extends JFrame {
	
	private GamePanel principalArea;

	public GameWindowTwo(String userName) {
		this.setSize(1136, 936);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Jugador 2: "+userName);
		init();
	}
	
	private void init() {
		
		this.principalArea = new GamePanel();
		this.principalArea.setLayout(null);
		
		this.add(principalArea);
	}
	
}
