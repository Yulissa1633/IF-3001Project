package Domain;

import java.awt.image.BufferedImage;

import Domain.Card;

public class AttackCard extends Card {
	
	private String attackType;
	private int attackPower;

	public AttackCard(BufferedImage skin, String type, String attackType, int attackPower) {
		super(skin, type);
		this.attackType = attackType;
		this.attackPower = attackPower;
	}
	
	

	

	
}
