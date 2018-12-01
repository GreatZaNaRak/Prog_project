package application;

import SceneManage.SceneManagement;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class GAME extends Application {
	
	private SceneManagement sceneManage;
	
	@Override
	public void start(Stage primaryStage) {
		sceneManage = new SceneManagement(primaryStage);
		sceneManage.setUp();
		
		Image icon = new Image(ClassLoader.getSystemResource("FFII_PSP_Logo.jpg").toString());
		primaryStage.getIcons().add(icon);
		primaryStage.setTitle("FINAL FANTASY II");
		primaryStage.setWidth(900);
		primaryStage.setHeight(900);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
