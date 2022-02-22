package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DicesPanel extends JPanel{
	
	public DicesPanel() { 
		this.setSize(626, 400);  
    }

 
    public void paint(Graphics g){ 
        Dimension size = getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, size.width, size.height);
        setOpaque(false);
        ImageIcon backImage = new ImageIcon(getClass().getResource("/Assets/dicesBack.png"));
        g.drawImage(backImage.getImage(),0,-20, size.width, size.height, null);
        setOpaque(false);
        super.paint(g);
    }

}
