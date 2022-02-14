package Business;

import java.nio.file.attribute.UserPrincipalLookupService;

import Data.PlayerData;

public class PlayerBusiness {

	private PlayerData playerData;

	public PlayerBusiness() {
		this.playerData = new PlayerData();
	}
	
	public boolean registerPlayer(String user, String password, int idCharacter) {
		
		if(!user.equals("") || !password.equals("")) {
			playerData.registerPlayer(user, password, idCharacter);
			return true;
		}
		
		return false;
	}
	
	public boolean loginPlayer(String user, String password) {
		
		if(!user.equals("") || !password.equals("")) {
			return playerData.loginPlayer(user, password);
		}
		
		return false;
	}
	
	public int getPlayerCharacter(String user) {
		return playerData.getPlayerCharacter(user);
	}
	
	
}
