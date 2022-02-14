package GUI;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Business.CharacterBusiness;
import Business.PlayerBusiness;
import Data.JsonUtil;
import Domain.Player;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class StartWindow extends JFrame{
	
	private StartPanel welcomeArea;
	private StartPanel loginArea;
	private StartPanel registerArea;
	private BufferedImage logo;
	private BufferedImage title;
	private BufferedImage loginButtonSkin;
	private BufferedImage registerButtonSkin;
	private BufferedImage texfieldBackSkin;
	private JLabel labelLogo;
	private JLabel labelTitle;
	private JLabel texfieldUserBack;
	private JLabel texfieldPassBack;
	private JLabel texfieldUserBack2;
	private JLabel texfieldPassBack2;
	private JLabel comboBoxBack;
	private JLabel labelUser;
	private JLabel labelPass;
	private JLabel labelMessage;
	private JLabel labelMessage2;
	private JTextField texfieldUser;
	private JPasswordField texfieldPass;
	private JTextField texfieldUser2;
	private JPasswordField texfieldPass2;
	private JButton loginButton;
	private JButton registerButton;
	private JComboBox characterList;
	private boolean windowOneOn;
	
	private PlayerBusiness playerBusiness = new PlayerBusiness();
	private CharacterBusiness chaBusiness = new CharacterBusiness();
	private GameWindowOne gW;
	private GameWindowTwo gW2;

	public StartWindow() {
		this.setSize(580, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);	
		
		try {
			logo =ImageIO.read(getClass().getResourceAsStream("/Assets/logo.png"));
			loginButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/loginButton.png"));
			registerButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/registerButton.png"));
			title =ImageIO.read(getClass().getResourceAsStream("/Assets/title.png"));
			texfieldBackSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/textfieldBack.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
	}
	
	@SuppressWarnings("unchecked")
	private void init() {
		this.chaBusiness.createCharacter();
		
		//-------------Sección de Bienvenida-----------------
		this.welcomeArea = new StartPanel();
		this.welcomeArea.setLayout(null);
		
		this.labelLogo = new JLabel(new ImageIcon(logo));
		this.welcomeArea.add(labelLogo);
		labelLogo.setBounds(360,20,200,200);
		
		this.labelTitle = new JLabel(new ImageIcon(title));
		this.welcomeArea.add(labelTitle);
		labelTitle.setBounds(140,240,291,64);
		
		this.loginButton = new JButton(new ImageIcon(loginButtonSkin));
		this.welcomeArea.add(loginButton);
		loginButton.setBounds(204,350,150,33);
		loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	welcomeArea.setVisible(false);
            	loginArea.setVisible(true);
            }
          });
		
		this.registerButton = new JButton(new ImageIcon(registerButtonSkin));
		this.welcomeArea.add(registerButton);
		registerButton.setBounds(204,420,150,33);
		registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	welcomeArea.setVisible(false);
            	registerArea.setVisible(true);
            }
          });
		
		//-------------Sección de Login-----------------
		this.loginArea = new StartPanel();
		this.loginArea.setLayout(null);
		
		this.labelLogo = new JLabel(new ImageIcon(logo));
		this.loginArea.add(labelLogo);
		labelLogo.setBounds(360,20,200,200);
		
		this.texfieldUserBack = new JLabel(new ImageIcon(texfieldBackSkin));
		this.loginArea.add(texfieldUserBack, 1, 0);
		texfieldUserBack.setBounds(170,310,227,50);
		
		this.labelUser = new JLabel("Usuario:");
		this.labelUser.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.loginArea.add(labelUser, 2, 0);
		labelUser.setBounds(180,310,100,50);
		
		this.texfieldUser = new JTextField();
		this.texfieldUser.setOpaque(false);
		this.texfieldUser.setBorder(null);
		this.loginArea.add(texfieldUser, 2, 0);
		texfieldUser.setBounds(250,322,120,25);
		
		this.texfieldPassBack = new JLabel(new ImageIcon(texfieldBackSkin));
		this.loginArea.add(texfieldPassBack, 1, 0);
		texfieldPassBack.setBounds(170,380,227,50);
		
		this.labelPass = new JLabel("Contraseña:");
		this.labelPass.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.loginArea.add(labelPass, 2, 0);
		labelPass.setBounds(180,380,100,50);
		
		this.texfieldPass = new JPasswordField();
		this.texfieldPass.setOpaque(false);
		this.texfieldPass.setBorder(null);
		this.loginArea.add(texfieldPass, 2, 0);
		texfieldPass.setBounds(270,392,100,25);
		
		this.texfieldUserBack = new JLabel(new ImageIcon(texfieldBackSkin));
		this.loginArea.add(texfieldUserBack, 1, 0);
		texfieldUserBack.setBounds(170,600,227,50);
		texfieldUserBack.setVisible(false);
		
		this.labelMessage = new JLabel("");
		this.labelMessage.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.loginArea.add(labelMessage, 2, 0);
		labelMessage.setBounds(225,600,200,50);
		labelMessage.setVisible(false);
		
		this.loginButton = new JButton(new ImageIcon(loginButtonSkin));
		this.loginArea.add(loginButton);
		loginButton.setBounds(209,450,150,33);
		loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	if(!playerBusiness.loginPlayer(texfieldUser.getText(), 
                	String.valueOf(texfieldPass.getPassword()))) {
            		texfieldUserBack.setVisible(true);	
    				labelMessage.setText("Datos incorrectos");
    				labelMessage.setVisible(true);	
                	}
                	else {  
                		if(windowOneOn) {
                			gW2 = new GameWindowTwo(texfieldUser.getText());
                			gW2.setResizable(false);
	                        gW2.setVisible(true);
                		}
                		else {
	                        gW = new GameWindowOne(texfieldUser.getText());                  
	                        gW.setResizable(false);
	                        gW.setVisible(true);
	                        windowOneOn = true;	                    
                		}
                		texfieldUser.setText("");
                        texfieldPass.setText(""); 
                	}
            }
          });
		
		this.registerButton = new JButton(new ImageIcon(registerButtonSkin));
		this.loginArea.add(registerButton);
		registerButton.setBounds(209,520,150,33);
		registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	loginArea.setVisible(false);
            	registerArea.setVisible(true);
            }
          });
		
		//-------------Sección de Registro-----------------
		this.registerArea = new StartPanel();
		this.registerArea.setLayout(null);
		
		this.labelLogo = new JLabel(new ImageIcon(logo));
		this.registerArea.add(labelLogo);
		labelLogo.setBounds(360,20,200,200);
		
		this.texfieldUserBack2 = new JLabel(new ImageIcon(texfieldBackSkin));
		this.registerArea.add(texfieldUserBack2, 1, 0);
		texfieldUserBack2.setBounds(170,310,227,50);
		
		this.labelUser = new JLabel("Usuario:");
		this.labelUser.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.registerArea.add(labelUser, 2, 0);
		labelUser.setBounds(180,310,100,50);
		
		this.texfieldUser2 = new JTextField();
		this.texfieldUser2.setOpaque(false);
		this.texfieldUser2.setBorder(null);
		this.registerArea.add(texfieldUser2, 2, 0);
		texfieldUser2.setBounds(250,322,120,25);
		
		this.texfieldPassBack2 = new JLabel(new ImageIcon(texfieldBackSkin));
		this.registerArea.add(texfieldPassBack2, 1, 0);
		texfieldPassBack2.setBounds(170,380,227,50);
		
		this.labelPass = new JLabel("Contraseña:");
		this.labelPass.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.registerArea.add(labelPass, 2, 0);
		labelPass.setBounds(180,380,100,50);
		
		this.texfieldPass2 = new JPasswordField();
		this.texfieldPass2.setOpaque(false);
		this.texfieldPass2.setBorder(null);
		this.registerArea.add(texfieldPass2, 2, 0);
		texfieldPass2.setBounds(270,392,100,25);
		
		this.comboBoxBack = new JLabel(new ImageIcon(texfieldBackSkin));
		this.registerArea.add(comboBoxBack, 1, 0);
		comboBoxBack.setBounds(170,460,227,50);
		
		this.characterList = new JComboBox(new Object[] 
							{"Loki", "Odin", "Thor", "Skade"});
		this.characterList.setOpaque(false);
		this.characterList.setBorder(null);
		this.characterList.setRenderer(new IconListRenderer(chaBusiness.makeJComboBox()));
		this.registerArea.add(characterList, 2, 0);
		characterList.setBounds(190,470,190,30);
		
		this.texfieldUserBack2 = new JLabel(new ImageIcon(texfieldBackSkin));
		this.registerArea.add(texfieldUserBack2, 1, 0);
		texfieldUserBack2.setBounds(170,640,227,50);
		texfieldUserBack2.setVisible(false);
		
		this.labelMessage2 = new JLabel("");
		this.labelMessage2.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.registerArea.add(labelMessage2, 2, 0);
		labelMessage2.setBounds(225,640,200,50);
		labelMessage2.setVisible(false);
		
		this.registerButton = new JButton(new ImageIcon(registerButtonSkin));
		this.registerArea.add(registerButton);
		registerButton.setBounds(209,540,150,33);
		registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(!playerBusiness.registerPlayer(texfieldUser2.getText(), 
            		String.valueOf(texfieldPass2.getPassword()),characterList.getSelectedIndex()+1)) {
            				texfieldUserBack2.setVisible(true);
            				labelMessage2.setText("Datos incorrectos");
            				labelMessage2.setVisible(true);
            				
                    	}
                    	else {  
                            texfieldUser2.setText("");
                            texfieldPass2.setText("");
                            labelMessage2.setText("Registro completado");
                            texfieldUserBack2.setVisible(true);
                            labelMessage2.setVisible(true);

                    	}
            }
          });
		
		this.loginButton = new JButton(new ImageIcon(loginButtonSkin));
		this.registerArea.add(loginButton);
		loginButton.setBounds(209,590,150,33);
		loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	registerArea.setVisible(false);
            	loginArea.setVisible(true);
            }
          });
		
		this.add(welcomeArea);
		this.add(loginArea);
		this.add(registerArea);
		this.loginArea.setVisible(false);
		this.registerArea.setVisible(false);
	}
	
}
