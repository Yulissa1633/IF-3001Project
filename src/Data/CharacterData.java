package Data;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import ADT.SLinkedList;
import Domain.Character;
import Domain.SLinkedList.ListException;
import Domain.SLinkedList.Node;

public class CharacterData {

	private Character character;
	private SLinkedList s;
	private BufferedImage skinLoki;
	private BufferedImage skinOdin;
	private BufferedImage skinThor;
	private BufferedImage skinSkade;
	
	private Map<Object, Icon> icons;
	
	public CharacterData() {
		s = new SLinkedList();
		icons = new HashMap<Object, Icon>();
	}
	
	public SLinkedList createCharacter() {
		
		try {
			skinLoki=ImageIO.read(getClass().getResourceAsStream("/Assets/Loki.png"));
			skinOdin=ImageIO.read(getClass().getResourceAsStream("/Assets/Odin.png"));
			skinThor=ImageIO.read(getClass().getResourceAsStream("/Assets/Thor.png"));
			skinSkade=ImageIO.read(getClass().getResourceAsStream("/Assets/Skade.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		character = new Character("Loki", skinLoki, 1);
		s.addFirst(new Node(character));
		character = new Character("Odin", skinOdin, 2);
		s.addFirst(new Node(character));
		character = new Character("Thor", skinThor, 3);
		s.addFirst(new Node(character));
		character = new Character("Skade", skinSkade, 4);
		s.addFirst(new Node(character));
		
		return s;
	}
	
	public String findNameCharacter(int idCharacter) {
		try {
			for (int i = 1; i <= s.size(); i++) {
				Node n = s.getNode(i);
				character = (Character) n.element;
				if(character.getId()==idCharacter) {
					return character.getName();
				}
			}
		} catch (ListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public Map<Object, Icon> makeJComboBox(){
		
		try {
			skinLoki=ImageIO.read(getClass().getResourceAsStream("/Assets/lokiIcon.png"));
			skinOdin=ImageIO.read(getClass().getResourceAsStream("/Assets/odinIcon.png"));
			skinThor=ImageIO.read(getClass().getResourceAsStream("/Assets/thorIcon.png"));
			skinSkade=ImageIO.read(getClass().getResourceAsStream("/Assets/skadeIcon.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		icons.put("Loki", new ImageIcon(skinLoki));
		icons.put("Odin", new ImageIcon(skinOdin));
		icons.put("Thor", new ImageIcon(skinThor));
		icons.put("Skade", new ImageIcon(skinSkade));
				
		return icons;
	}
	
}
