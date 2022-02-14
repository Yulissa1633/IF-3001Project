package GUI;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Business.CharacterBusiness;

public class GameWindowTwo extends JFrame {
	
	private BufferedImage labeldBackSkin;
	private BufferedImage characterSkin;
	private JLabel labelPlayerNameBack;
	private JLabel labelPlayerName;
	private JLabel labelCharacter;
	private String userName;
	private String characterName;
	
	private GamePanel principalArea;
	private CharacterBusiness chaBusiness = new CharacterBusiness();

	public GameWindowTwo(String userName) {
		this.setSize(1136, 936);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.userName = userName;
		this.setTitle("Jugador 2: "+userName);
		this.chaBusiness.createCharacter();
		this.characterName = this.chaBusiness.findNameCharacter(chaBusiness.getPlayerCharacter(userName));
		
		try {
			labeldBackSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/textfieldBack.png"));
			characterSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/"+this.characterName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
	}
	
	private void init() {
		
		
		this.principalArea = new GamePanel();
		this.principalArea.setLayout(null);
		
		this.labelCharacter = new JLabel(new ImageIcon(characterSkin));
		this.principalArea.add(labelCharacter, 1, 0);
		labelCharacter.setBounds(0,0,400,389);
		
		this.labelPlayerNameBack = new JLabel(new ImageIcon(labeldBackSkin));
		this.principalArea.add(labelPlayerNameBack, 1, 0);
		labelPlayerNameBack.setBounds(250,40,227,50);
		
		this.labelPlayerName = new JLabel(userName +" ("+this.characterName+")");
		this.labelPlayerName.setFont(new Font("Perpetua", Font.PLAIN, 30));
		this.principalArea.add(labelPlayerName, 2, 0);
		labelPlayerName.setBounds(270,42,100,50);
		
		this.add(principalArea);
	}
	
}
