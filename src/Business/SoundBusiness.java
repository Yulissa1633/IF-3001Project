package Business;

import Data.SoundData;

public class SoundBusiness {
	
	SoundData soundData = new SoundData();
	
	public SoundBusiness() {
		
	}
	
	public void playDiceSoud() {
		soundData.dicesSound();
	}

}
