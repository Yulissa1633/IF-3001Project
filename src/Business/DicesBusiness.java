package Business;

import Data.DiceData;

public class DicesBusiness {
	
	DiceData diceData = new DiceData();
	
	public DicesBusiness() {
		
	}
	
	public int getDiceFace() {
		return diceData.getDiceFace();
	}

}
