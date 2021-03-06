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

import Business.CharacterBusiness;
import Business.SoundBusiness;

public class GameWindow extends JFrame {
	
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
	
	private int player;
	private GamePanel principalArea;
	private CardsZonePanel cardsZone;
	private AttackZonePanel atkZone;
	private CharacterBusiness chaBusiness = new CharacterBusiness();
	private SoundBusiness soundBusiness = new SoundBusiness();

	public GameWindow(String userName, int player) {
		this.setSize(1400, 800);  
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.userName = userName;
		this.player = player;
		this.setTitle("Jugador: "+userName);
		this.chaBusiness.createCharacter();
		this.characterName = this.chaBusiness.findNameCharacter(chaBusiness.getPlayerCharacter(userName));
		
		try {
			labeldBackSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/textfieldBack.png"));
			characterSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/"+this.characterName+".png"));
			diceSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
			throwDiceButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/throwDiceButton.png"));
			shuffleButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/shuffleButton.png"));
			cleanATKAreaButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/cleanATKAreaButton.png"));
			launchATKButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/launchATKButton.png"));
			deckButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/mazo.png"));
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
		labelCharacter.setBounds(-20,0,297,289);
		
		this.labelPlayerNameBack = new JLabel(new ImageIcon(labeldBackSkin));
		this.principalArea.add(labelPlayerNameBack, 1, 0);
		labelPlayerNameBack.setBounds(220,20,227,50);
		
		this.labelPlayerName = new JLabel(userName +" ("+this.characterName+")");
		this.labelPlayerName.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.principalArea.add(labelPlayerName, 2, 0);
		labelPlayerName.setBounds(240,21,100,50);
		
		this.throwDiceButton = new JButton(new ImageIcon(throwDiceButtonSkin));
		this.principalArea.add(throwDiceButton);
		throwDiceButton.setBounds(260,80,150,33);
		throwDiceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	DicesWindow dicesWindow = new DicesWindow(characterSkin);
            	soundBusiness.playDiceSoud();
            	dicesWindow.setVisible(true);
            }
          });
		
		this.cleanATKAreaButton = new JButton(new ImageIcon(cleanATKAreaButtonSkin));
		this.principalArea.add(cleanATKAreaButton);
		cleanATKAreaButton.setBounds(260,120,150,33);
		cleanATKAreaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//Limpiar ?rea ataque
            }
          });
		
		this.launchATKButton = new JButton(new ImageIcon(launchATKButtonSkin));
		this.principalArea.add(launchATKButton);
		launchATKButton.setBounds(260,160,150,33);
		launchATKButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//Lanzar ataque
            	
            }
          });
		
		this.deckButton = new JButton(new ImageIcon(deckButtonSkin));
		this.principalArea.add(deckButton);
		deckButton.setBounds(20,350,198,300);
		deckButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	//Sacar una carta del mazo
            }
          });
		
		this.cardsZone = new CardsZonePanel();
		cardsZone.setBounds(240,345,1100,310);
		this.add(cardsZone);
		
		this.atkZone = new AttackZonePanel();
		atkZone.setBounds(550,20,700,310);
		this.add(atkZone);
		
		
		this.add(principalArea);
		
	}
	
	
	
}
