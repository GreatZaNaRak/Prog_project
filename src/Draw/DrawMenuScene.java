package Draw;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DrawMenuScene extends Canvas{
	
	public void drawCity(GraphicsContext gc, String image_path) {
		Image javafx_logo = new Image(image_path);
		new AnimationTimer() {
			double a = 0;
			double check = gc.getCanvas().getWidth();
			double d = 0;
			@Override
			public void handle(long arg0) {
				a -= 1;
				check += 1;
				gc.drawImage(javafx_logo, a, 0, gc.getCanvas().getWidth()+2000, gc.getCanvas().getHeight());
				if (check==gc.getCanvas().getWidth()+2000+d) {
					d = a = -30;
					check = gc.getCanvas().getWidth();
					gc.drawImage(javafx_logo, a, 0, gc.getCanvas().getWidth()+2000, gc.getCanvas().getHeight());
				};
			}
		}.start();
		
	}
	
	
	public void drawEnter(GraphicsContext gc) {
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
