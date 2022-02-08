package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartWindow extends JFrame{
	
	private StartPanel welcomeArea;
	private StartPanel loginArea;
	private StartPanel registerArea;
	private StartPanel selectCharacterArea;
	private BufferedImage logo;
	private JLabel labelLogo;

	public StartWindow() {
		this.setSize(580, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		try {
			logo =ImageIO.read(getClass().getResourceAsStream("/Assets/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
	}
	
	private void init() {
		this.welcomeArea = new StartPanel();
		this.labelLogo = new JLabel(new ImageIcon(logo));
		this.labelLogo.setBounds(140, 140, 40, 40);
		this.welcomeArea.add(labelLogo);
		this.add(welcomeArea);
	}
	
}
