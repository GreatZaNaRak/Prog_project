package sound;

import javafx.animation.Animation;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class soundManagement {
	
	private static MediaPlayer media, gunSound, selectSound, confirmSound, gameSound, enterSound, enterFightSound;
	
	public static void enterFightSound() {
		enterFightSound = new MediaPlayer(new Media(ClassLoader.getSystemResource("enterFightSound.mp3").toString()));
		enterFightSound.setStartTime(Duration.seconds(0.5));
		enterFightSound.play();
	}
	
	public static void music() {
		
		Thread bgMusic = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
					Media sound = new Media(ClassLoader.getSystemResource("angel.wav").toString());
					media = new MediaPlayer(sound);
					media.setAutoPlay(true);
					media.setCycleCount(Animation.INDEFINITE);
					media.setVolume(0.2);
					media.play();
			}
		});bgMusic.start();
		
	}
	
	public static void stopMusic() {
		media.stop();
	}
	
	public static void gun() {
	    Media hit = new Media(ClassLoader.getSystemResource("gun.wav").toString());
	    gunSound = new MediaPlayer(hit);
	    gunSound.setStartTime(Duration.seconds(0.3));
	    gunSound.setVolume(1);
	    gunSound.play();
	}
	
	public static void charSelect() {
		Media hit = new Media(ClassLoader.getSystemResource("charSelect.wav").toString());
		selectSound = new MediaPlayer(hit);
		selectSound.setStartTime(Duration.seconds(0.35));
		selectSound.setStopTime(Duration.seconds(1));
		selectSound.setVolume(0.5);
		selectSound.play();
	}
	
	public static void confirmed() {
		Media hit = new Media(ClassLoader.getSystemResource("charConfirmed.wav").toString());
		confirmSound = new MediaPlayer(hit);
		confirmSound.setStartTime(Duration.seconds(0));
		confirmSound.play();
	}
	
	public static void gameSound1() {
		Thread gameBgSound = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Media hit = new Media(ClassLoader.getSystemResource("normal1.wav").toString());
				gameSound = new MediaPlayer(hit);
				gameSound.setVolume(0.4);
				gameSound.setAutoPlay(true);
				gameSound.setCycleCount(Animation.INDEFINITE);
				gameSound.setStartTime(Duration.seconds(2.5));
				gameSound.play();
				
			}
		});gameBgSound.start();
		
	}
	
	public static void gameSound2() {
		
			Thread gameBgSound2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Media hit = new Media(ClassLoader.getSystemResource("normal2.wav").toString());
				gameSound = new MediaPlayer(hit);
				gameSound.setVolume(0.4);
				gameSound.setAutoPlay(true);
				gameSound.setCycleCount(Animation.INDEFINITE);
				gameSound.setStartTime(Duration.seconds(2.5));
				gameSound.play();
				
			}
		});gameBgSound2.start();
	}
	
	public static void battleSound() {
		Media hit = new Media(ClassLoader.getSystemResource("fightSound.wav").toString());
		gameSound = new MediaPlayer(hit);
		gameSound.setVolume(1);
		gameSound.setAutoPlay(true);
		gameSound.setCycleCount(Animation.INDEFINITE);
		gameSound.setStartTime(Duration.seconds(1));
		gameSound.play();
	}
	
	public static void bossSound() {
		Media hit = new Media(ClassLoader.getSystemResource("bSound.wav").toString());
		gameSound = new MediaPlayer(hit);
		gameSound.setVolume(1);
		gameSound.setAutoPlay(true);
		gameSound.setCycleCount(Animation.INDEFINITE);
		gameSound.play();
	}
	
	public static void stopGameSound() {
		gameSound.stop();
	}
	
	public static void enterSound() {
		Media hit = new Media(ClassLoader.getSystemResource("enterSound.wav").toString());
		enterSound = new MediaPlayer(hit);
		enterSound.setStopTime(Duration.seconds(0.7));
		enterSound.play();
	}
	
}
