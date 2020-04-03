package Project01;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class PocketmonAttackMusic {
	File bgm = new File("C:/Users/SIST78/Desktop/ds/bgmAttack.wav");
	AudioInputStream stream;
	AudioFormat format;
	DataLine.Info info;
	Clip clip;

	public void run() {
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopSound() {
		clip.stop();
		clip.close();
	}
}