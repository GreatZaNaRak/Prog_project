package sound;

import java.nio.file.Paths;

import javafx.animation.Animation;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class soundManagement {
	
	private MediaPlayer mediaPlayer, gunSound, selectSound, confirmSound;
	private MediaPlayer cloudVoice, tifaVoice, zackVoice;
	
	public void music(){
	    String bip = "C:\\Users\\USER\\AppData\\Local\\Temp\\angel.wav";
	    Media hit = new Media(Paths.get(bip).toUri().toString());
	    mediaPlayer = new MediaPlayer(hit);
	    mediaPlayer.setVolume(0.17);
	    mediaPlayer.setCycleCount(Animation.INDEFINITE);
	    mediaPlayer.setStartTime(Duration.seconds(0)); // to be delete
	    mediaPlayer.setStopTime(Duration.seconds(242)); // to be delete
	    mediaPlayer.play();
	}
	
	public void stopMusic() {
		mediaPlayer.stop();
	}
	
	public void gun() {
		String bip = "C:\\Users\\USER\\AppData\\Local\\Temp\\gun.wav";
	    Media hit = new Media(Paths.get(bip).toUri().toString());
	    gunSound = new MediaPlayer(hit);
	    gunSound.setStartTime(Duration.seconds(1.2));
	    gunSound.setVolume(1);
	    gunSound.play();
	}
	
	public void charSelect() {
		String bip = "C:\\Users\\USER\\AppData\\Local\\Temp\\charSelect.wav";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		selectSound = new MediaPlayer(hit);
		selectSound.setStartTime(Duration.seconds(63.5));
		selectSound.setStopTime(Duration.seconds(64));
		selectSound.play();
	}
	
	public void confirmed() {
		String bip = "C:\\Users\\USER\\AppData\\Local\\Temp\\charConfirmed.wav";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		confirmSound = new MediaPlayer(hit);
		confirmSound.setStartTime(Duration.seconds(0));
		confirmSound.play();
	}
	
	public void cloudVoice() {
		String bip = "C:\\Users\\USER\\AppData\\Local\\Temp\\cloud.wav";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		cloudVoice = new MediaPlayer(hit);
		cloudVoice.setStartTime(Duration.seconds(7));
		cloudVoice.setVolume(10);
		cloudVoice.setStopTime(Duration.seconds(8.9));
		cloudVoice.play();
	}
	
	public void tifaVoice() {
		String bip = "C:\\Users\\USER\\AppData\\Local\\Temp\\Tifa Voice acting.wav";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		tifaVoice = new MediaPlayer(hit);
		tifaVoice.setStartTime(Duration.seconds(4.4));
		tifaVoice.setVolume(0.5);
		tifaVoice.setStopTime(Duration.seconds(7));
		tifaVoice.play();
	}
	
	public void zackVoice() {
		String bip = "C:\\Users\\USER\\AppData\\Local\\Temp\\Zack Fair voice acting reference.wav";
		Media hit = new Media(Paths.get(bip).toUri().toString());
		zackVoice = new MediaPlayer(hit);
		zackVoice.setStartTime(Duration.seconds(22));
		zackVoice.setVolume(0.2);
		zackVoice.play();
	}
	
}
