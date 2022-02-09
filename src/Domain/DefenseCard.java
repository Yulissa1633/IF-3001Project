package Domain;

import java.awt.image.BufferedImage;

import Domain.Card;

public class DefenseCard extends Card{
	
	private String defenseType;
	private int defensePower;

	public DefenseCard(BufferedImage skin, String type, String defenseType, int defensePower) {
		super(skin, type);
		this.defenseType = defenseType;
		this.defensePower = defensePower;
	}

	
	
}
