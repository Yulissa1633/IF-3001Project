package ADT;

import java.awt.image.BufferedImage;

public class Card {

	private BufferedImage skin;
	private String type;
	
	public Card(BufferedImage skin, String type) {
		super();
		this.skin = skin;
		this.type = type;
	}

	public BufferedImage getSkin() {
		return skin;
	}

	public void setSkin(BufferedImage skin) {
		this.skin = skin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
