package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AttackZonePanel extends JPanel{
	
	public AttackZonePanel() { 
		this.setSize(700, 310);  
    }
	
	public void paint(Graphics g){ 
        Dimension size = getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, size.width, size.height);
        setOpaque(false);
        super.paint(g);
    }

}
