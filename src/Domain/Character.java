package Domain;

import java.awt.image.BufferedImage;

public class Character {
	
	private String name;
	private BufferedImage skin;
	
	public Character(String name, BufferedImage skin) {
		super();
		this.name = name;
		this.skin = skin;
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
	
	
	
}
