package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.fasterxml.jackson.core.json.async.NonBlockingJsonParserBase;

import Business.CharacterBusiness;

public class GameWindowOne extends JFrame {
	
	private BufferedImage labeldBackSkin;
	private BufferedImage characterSkin;
	private BufferedImage diceSkin;
	private BufferedImage throwDiceButtonSkin;
	private BufferedImage cleanATKAreaButtonSkin;
	private BufferedImage shuffleButtonSkin;
	private BufferedImage launchATKButtonSkin;
	private BufferedImage deckButtonSkin;
	private JLabel labelPlayerNameBack;
	private JLabel labelPlayerName;
	private JLabel labelCharacter;
	private String userName;
	private String characterName;
	private JButton shuffleButton;
	private JButton throwDiceButton;
	private JButton cleanATKAreaButton;
	private JButton launchATKButton;
	private JButton deckButton;
	
	private GamePanel principalArea;
	private CharacterBusiness chaBusiness = new CharacterBusiness();

	public GameWindowOne(String userName) {
		this.setSize(1136, 936);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.userName = userName;
		this.setTitle("Jugador 1: "+userName);
		this.chaBusiness.createCharacter();
		this.characterName = this.chaBusiness.findNameCharacter(chaBusiness.getPlayerCharacter(userName));
		
		try {
			labeldBackSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/textfieldBack.png"));
			characterSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/"+this.characterName+".png"));
			diceSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
			throwDiceButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
			shuffleButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
			cleanATKAreaButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
			launchATKButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
			deckButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
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
		labelCharacter.setBounds(0,0,297,289);
		
		this.labelPlayerNameBack = new JLabel(new ImageIcon(labeldBackSkin));
		this.principalArea.add(labelPlayerNameBack, 1, 0);
		labelPlayerNameBack.setBounds(320,40,227,50);
		
		this.labelPlayerName = new JLabel(userName +" ("+this.characterName+")");
		this.labelPlayerName.setFont(new Font("Perpetua", Font.PLAIN, 30));
		this.principalArea.add(labelPlayerName, 2, 0);
		labelPlayerName.setBounds(340,41,100,50);
		
		this.throwDiceButton = new JButton(new ImageIcon(throwDiceButtonSkin));
		this.principalArea.add(throwDiceButton);
		throwDiceButton.setBounds(900,40,150,33);
		throwDiceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//lanza dados
            }
          });
		
		this.shuffleButton = new JButton(new ImageIcon(shuffleButtonSkin));
		this.principalArea.add(shuffleButton);
		shuffleButton.setBounds(770,300,150,33);
		shuffleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//Barajar mazo
            }
          });
		
		this.cleanATKAreaButton = new JButton(new ImageIcon(cleanATKAreaButtonSkin));
		this.principalArea.add(cleanATKAreaButton);
		cleanATKAreaButton.setBounds(940,300,150,33);
		cleanATKAreaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//Limpiar área ataque
            }
          });
		
		this.launchATKButton = new JButton(new ImageIcon(launchATKButtonSkin));
		this.principalArea.add(launchATKButton);
		launchATKButton.setBounds(940,330,150,33);
		launchATKButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//Lanzar ataque
            }
          });
		
		this.deckButton = new JButton("Mazo");
		this.principalArea.add(deckButton);
		deckButton.setBounds(770,370,215,300);
		deckButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//Sacar una carta del mazo
            }
          });
		
		this.add(principalArea);
	}
	
}
