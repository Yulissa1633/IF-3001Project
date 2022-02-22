package GUI;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Business.DicesBusiness;

public class DicesWindow extends JFrame{
	
	DicesPanel dicesPanel = new DicesPanel();
	DicesBusiness dicesBusiness = new DicesBusiness();
	
	private JLabel labelCharacter;
	private JLabel labelDiceOne;
	private JLabel labelDiceTwo;
	private JLabel labelResult;
	private BufferedImage characterSkin;
	private BufferedImage diceOneSkin;
	private BufferedImage diceTwoSkin;
	private int diceOne;
	private int diceTwo;
	
	public DicesWindow(BufferedImage characterSkin) {
		this.setSize(626, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);	
        this.setResizable(false);
        this.diceOne = dicesBusiness.getDiceFace();
        this.diceTwo = dicesBusiness.getDiceFace();
        this.characterSkin = characterSkin;
        
        
        try {
        	diceOneSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/"+diceOne+".png"));
			diceTwoSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/"+diceTwo+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		init();
	}
	
	private void init() {
		this.add(dicesPanel);
		this.dicesPanel.setLayout(null);
		
		this.labelDiceOne = new JLabel(new ImageIcon(diceOneSkin));
		this.dicesPanel.add(labelDiceOne);
		labelDiceOne.setBounds(220,150,72,72);
		
		this.labelDiceTwo = new JLabel(new ImageIcon(diceTwoSkin));
		this.dicesPanel.add(labelDiceTwo);
		labelDiceTwo.setBounds(370,150,72,72);
		
		this.labelResult = new JLabel("Resultado: "+(diceOne+diceTwo));
		this.labelResult.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.dicesPanel.add(labelResult);
		labelResult.setBounds(290,200,100,50);
		
		this.labelCharacter = new JLabel(new ImageIcon(characterSkin));
		this.dicesPanel.add(labelCharacter);
		labelCharacter.setBounds(-30,100,297,289);
	}

}
