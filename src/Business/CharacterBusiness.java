package Business;

import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import ADT.Node;
import ADT.SLinkedList;
import Data.CharacterData;
import Domain.Character;

public class CharacterBusiness {
	
	private CharacterData characterData;
	private PlayerBusiness playerBusiness;

	public CharacterBusiness() {
		this.characterData = new CharacterData();
		this.playerBusiness = new PlayerBusiness();
	}
	
	public SLinkedList createCharacter() {
		return characterData.createCharacter();
	}
	
	public int getPlayerCharacter(String user) {
		return playerBusiness.getPlayerCharacter(user);
	}
	
	public String findNameCharacter(int idCharacter) {
		return characterData.findNameCharacter(idCharacter);
	}
	
	public Map<Object, Icon> makeJComboBox(){	
		return characterData.makeJComboBox();
	}
	
}
