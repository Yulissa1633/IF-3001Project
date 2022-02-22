package Data;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundData {
	
	public SoundData() {
		
	}
	
	
	public void dicesSound(){
	       
	        AudioInputStream audioInputStream;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(new File("src/Assets/diceSound.wav").getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	      
	     }

}
