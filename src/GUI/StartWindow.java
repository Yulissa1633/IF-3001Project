package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class StartWindow extends JFrame{
	
	private StartPanel welcomeArea;
	private StartPanel loginArea;
	private StartPanel registerArea;
	private StartPanel selectCharacterArea;
	private BufferedImage logo;
	private BufferedImage title;
	private BufferedImage loginButtonSkin;
	private BufferedImage registerButtonSkin;
	private BufferedImage texfieldBackSkin;
	private JLabel labelLogo;
	private JLabel labelTitle;
	private JLabel texfieldUserBack;
	private JLabel texfieldPassBack;
	private JLabel labelUser;
	private JLabel labelPass;
	private JTextField texfieldUser;
	private JPasswordField texfieldPass;
	private JButton loginButton;
	private JButton registerButton;

	public StartWindow() {
		this.setSize(580, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	
	private void init() {
		
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
		
		this.loginButton = new JButton(new ImageIcon(loginButtonSkin));
		this.loginArea.add(loginButton);
		loginButton.setBounds(209,450,150,33);
		loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
          });
		
		//-------------Sección de Registro-----------------
		this.registerArea = new StartPanel();
		this.registerArea.setLayout(null);
		
		this.labelLogo = new JLabel(new ImageIcon(logo));
		this.registerArea.add(labelLogo);
		labelLogo.setBounds(360,20,200,200);
		
		this.texfieldUserBack = new JLabel(new ImageIcon(texfieldBackSkin));
		this.registerArea.add(texfieldUserBack, 1, 0);
		texfieldUserBack.setBounds(170,310,227,50);
		
		this.labelUser = new JLabel("Usuario:");
		this.labelUser.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.registerArea.add(labelUser, 2, 0);
		labelUser.setBounds(180,310,100,50);
		
		this.texfieldUser = new JTextField();
		this.texfieldUser.setOpaque(false);
		this.texfieldUser.setBorder(null);
		this.registerArea.add(texfieldUser, 2, 0);
		texfieldUser.setBounds(250,322,120,25);
		
		this.texfieldPassBack = new JLabel(new ImageIcon(texfieldBackSkin));
		this.registerArea.add(texfieldPassBack, 1, 0);
		texfieldPassBack.setBounds(170,380,227,50);
		
		
		this.labelPass = new JLabel("Contraseña:");
		this.labelPass.setFont(new Font("Perpetua", Font.PLAIN, 18));
		this.registerArea.add(labelPass, 2, 0);
		labelPass.setBounds(180,380,100,50);
		
		this.texfieldPass = new JPasswordField();
		this.texfieldPass.setOpaque(false);
		this.texfieldPass.setBorder(null);
		this.registerArea.add(texfieldPass, 2, 0);
		texfieldPass.setBounds(270,392,100,25);
		
		this.registerButton = new JButton(new ImageIcon(registerButtonSkin));
		this.registerArea.add(registerButton);
		registerButton.setBounds(209,450,150,33);
		registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
          });
		
		this.add(welcomeArea);
		this.add(loginArea);
		this.add(registerArea);
		this.loginArea.setVisible(false);
		this.registerArea.setVisible(false);
	}
	
}
