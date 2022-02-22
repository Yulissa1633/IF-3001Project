package Data;

import java.util.Random;

public class DiceData {
	
	public DiceData() {
		
	}
	
	public int getDiceFace() {
		return (int) (Math.random()*(6-1)) + 1;
	}

}
