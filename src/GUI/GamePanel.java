package GUI;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel{

	public GamePanel() { 
        this.setSize(1136, 936);    
    }

 
    public void paint(Graphics g){ 
        Dimension size = getSize();
        ImageIcon backImage = new ImageIcon(getClass().getResource("/Assets/fightingArena.jpg"));
        g.drawImage(backImage.getImage(),0,0, size.width, size.height, null);
        setOpaque(false);
        super.paint(g);
    }
	
}
