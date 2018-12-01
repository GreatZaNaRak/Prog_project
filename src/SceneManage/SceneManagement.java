package SceneManage;

import Character_Animate.Character_Ani;
import javafx.scene.Scene;
import javafx.stage.Stage;
import scene.BattleScene;
import scene.CreditScene;
import scene.GameScene;
import scene.MenuScene;
import scene.PlayScene;
import scene.stage_1;

public class SceneManagement {
	
	private static Stage primaryStage;
	private static Character_Ani Char = new Character_Ani();
	private static MenuScene menu = new MenuScene();
	private static CreditScene Credit = new CreditScene();
	private static PlayScene play = new PlayScene();
	public static GameScene game = new GameScene();
	public static stage_1 stage1 = new stage_1();
	public static BattleScene battle = new BattleScene();
	
	public static Scene menuScene = new Scene(menu);
	public static Scene creditScene = new Scene(Credit);
	public static Scene playScene = new Scene(play);
	public static Scene gameScene = new Scene(game);
	public static Scene stage1Scene = new Scene(stage1);
	public static Scene battleScene = new Scene(battle);
	
	public SceneManagement(Stage stage) {
		primaryStage = stage;
	}
	
	public void setUp() {
		
		primaryStage.setWidth(900);
		primaryStage.setHeight(900);
		primaryStage.setResizable(false);
		switchScene(menuScene);
		MenuScene.setMenuAction();
	}
	
	public static void switchScene(Scene scene) {
		primaryStage.setScene(scene);
	}
	
}
