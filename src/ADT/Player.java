package ADT;

public class Player {
	private String userName;
	private String password;
	private Character character;
	private int coins;
	
	public Player(String userName, String password, Character character, int coins) {
		super();
		this.userName = userName;
		this.password = password;
		this.character = character;
		this.coins = coins;
	}

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

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	

}
