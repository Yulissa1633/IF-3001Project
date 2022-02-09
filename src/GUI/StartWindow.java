package GUI;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
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
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class StartWindow extends JFrame{
	
	private StartPanel welcomeArea;
	private StartPanel loginArea;
	private StartPanel registerArea;
	private StartPanel selectCharacterArea;
	private BufferedImage logo;
	private BufferedImage loginButtonSkin;
	private JLabel labelLogo;
	private JButton loginButton;
	private JButton registerButton;

	public StartWindow() {
		this.setSize(580, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		try {
			logo =ImageIO.read(getClass().getResourceAsStream("/Assets/logo.png"));
			loginButtonSkin =ImageIO.read(getClass().getResourceAsStream("/Assets/loginButton.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
	}
	
	private void init() {
		this.welcomeArea = new StartPanel();
		this.welcomeArea.setLayout(null);
		
		this.labelLogo = new JLabel(new ImageIcon(logo));
		this.welcomeArea.add(labelLogo);
		labelLogo.setBounds(360,20,200,200);
		
		this.loginButton = new JButton(new ImageIcon(loginButtonSkin));
		this.welcomeArea.add(loginButton);
		loginButton.setBounds(200,350,150,33);
		loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
          });
		
		this.registerButton = new JButton("Registrarse");
		this.welcomeArea.add(registerButton);
		registerButton.setBounds(200,420,120,40);
		registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
          });
		
		
		
		this.add(welcomeArea);
	}
	
}
