package edu.ilstu;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Plays a simple alarm ringing noise upon the implementation of method "playAlarm()" and closes it upon the implementation
 * of "stopAlarm()". Must implement "setUpAlarm()" before "playAlarm()" will work.
 * 
 * @author Christopher Runyan
 */
public class AlarmAudio{
	Clip clip;
	AudioInputStream ais;
	
	public void setUpAlarm() throws Exception{
		URL url = new URL(
	            "http://www.mp3item.com/soundeffects/clock03.wav");
		clip = AudioSystem.getClip();
		ais = AudioSystem.getAudioInputStream(url);
	}
	 
	public void playAlarm() throws Exception{
		clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
 
	}
	
	public void stopAlarm(){
		clip.close();
	}
}
