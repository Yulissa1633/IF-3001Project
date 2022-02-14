package Data;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import Domain.Player;

public class PlayerData {
	
	private Player player;
	
	public PlayerData() {
		
	}
	
	public void registerPlayer(String user, String password, int idCharacter) {
		player = new Player(user, password, idCharacter, 0); //TO DO: Selección de personaje
	
		File file = new File("src/Data/UsersAndPass/"+user+ "User.json");
		new JsonUtil().toFile(file, player);
	}
	
	public boolean loginPlayer(String user, String password) {
		if(Files.exists(Paths.get("src/Data/UsersAndPass/" + user + "User.json"))) {
			URI uri = (Paths.get("src/Data/UsersAndPass/" + user + "User.json")).toUri();
			try {
				player = new JsonUtil().asObject(uri.toURL(), Player.class);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			if(player.getUserName().equals(user) && player.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public int getPlayerCharacter(String user) {
		
		int character = 0;
		
		if(Files.exists(Paths.get("src/Data/UsersAndPass/" + user + "User.json"))) {
			URI uri = (Paths.get("src/Data/UsersAndPass/" + user + "User.json")).toUri();
			try {
				player = new JsonUtil().asObject(uri.toURL(), Player.class);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		if(player.getUserName().equals(user) ) {
			character = player.getIdCharacter();
		}
		
		return character;
	}

}
