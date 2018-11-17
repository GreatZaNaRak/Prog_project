package window;

import Draw.DrawMenuScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import scene.creditScene;
import sound.soundManagement;

public class SceneManager {
	
	private soundManagement sound;
	private DrawMenuScene draw;
	private creditScene creditScene;
	
	public SceneManager() {
		
	}
	
	public void setSceneManageMent() {
		
	}
	
	public void setOnCreditSceneManagement() {
		
		creditScene scene = new creditScene();
		
		scene.getBack().setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				stage.setScene(primarySene);
				sound.music();
				draw.drawCity(gc, image_path);
			}
		});
		
		creditCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.stopMusic();
				sound.gun();
				stage.setScene(creditScene);
			}
		});
	}
	
}
