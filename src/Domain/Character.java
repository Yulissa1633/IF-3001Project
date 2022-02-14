package Domain;

import java.awt.image.BufferedImage;

public class Character {
	
	private String name;
	private BufferedImage skin;
	private int id;
	
	public Character(String name, BufferedImage skin, int id) {
		super();
		this.name = name;
		this.skin = skin;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BufferedImage getSkin() {
		return skin;
	}

	public void setSkin(BufferedImage skin) {
		this.skin = skin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
