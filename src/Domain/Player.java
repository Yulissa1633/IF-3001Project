package Domain;

import Domain.Character;

public class Player {
	private String userName;
	private String password;
	private int idCharacter;
	private int coins;
	
	public Player(String userName, String password, int idCharacter, int coins) {
		this.userName = userName;
		this.password = password;
		this.idCharacter = idCharacter;
		this.coins = coins;
	}
	
	public Player(){ super(); }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdCharacter() {
		return idCharacter;
	}

	public void setIdCharacter(int idCharacter) {
		this.idCharacter = idCharacter;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}	
	
}
