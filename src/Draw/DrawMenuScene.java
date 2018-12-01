package Draw;


import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class DrawMenuScene extends Canvas{
	
	public static void setBG(BorderPane centerPane) {
		
		MediaPlayer test = new MediaPlayer(new Media(ClassLoader.getSystemResource("BG.mp4").toString()));
		MediaView mm = new MediaView(test);
		mm.setFitWidth(1540);
		mm.setFitHeight(1540);
		mm.setManaged(true);
		
		
		test.setVolume(0);
		test.setStartTime(Duration.seconds(0.1));
		test.setStopTime(Duration.seconds(60));
		test.setAutoPlay(true);
		test.setCycleCount(Animation.INDEFINITE);
		test.play();
		centerPane.getChildren().add(mm);
		
		
	}
	
	
	public static void drawEnter(GraphicsContext gc) {
		new AnimationTimer() {
			double alpha = 0.1;
			boolean increase = true;
			@Override
			public void handle(long now) {
				double t = 200;
				if (increase)
					alpha += 1.0 / t;
				else
					alpha -= 1.0 / t;
				if (alpha > 1.0) {
					alpha = 2 - alpha;
					increase = false;
				} else if (alpha < 0.0) {
					alpha = Math.abs(alpha);
					increase = true;
				}
				gc.setFill(Color.BLACK);
				gc.setFont(Font.font(60));
				gc.setGlobalAlpha(alpha);
				gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
				gc.fillText(">> Press Enter To Start <<", gc.getCanvas().getWidth()/2 - 350 , 
						gc.getCanvas().getHeight()/2 + 70);
				
			}
		}.start();
	}
}
