package scene;

import Character_Animate.Character_Ani;
import Character_Animate.Cloud;
import Character_Animate.Tifa;
import Character_Animate.Vincent;
import Character_Animate.ready;
import SceneManage.SceneManagement;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sound.soundManagement;

public class PlayScene extends BorderPane{
	
	private Label sceneLabel;
	private Cloud cloud;
	private Tifa tifa;
	private Vincent vincent;
	private ready ready;
	private VBox CharacterSelected;
	private HBox firstChar, secondChar, thirdChar;
	private GraphicsContext firstGC, secondGC, thirdGC;
	private Button playSceneToMenu, start;
	private Text label1, label2, label3;
	private BorderPane information;
	public static int CharToPlay = 0;
	
	
	public PlayScene() {
		
		// >>>>>>>>>>>>>>> Play Scene <<<<<<<<<<<<<<<<<<<<<
		
		this.setPlaySceneAction();
		information = new BorderPane();
		
		// >>>>>>>>>>> Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Top Center pane <<<<<<<<<<<<<<<<<<
		
		sceneLabel = new Label("Character Select");
		
		sceneLabel.setFont(Font.font("Comic Sans MS", 45));
		sceneLabel.setTextFill(Color.WHITE);
		sceneLabel.setAlignment(Pos.CENTER);
		sceneLabel.setPrefHeight(120);
		sceneLabel.setPrefWidth(600);
		sceneLabel.setStyle("-fx-background-color : black");
		
		information.setTop(sceneLabel);
		
		// >>>>>>>>>>> Top Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Center Center pane <<<<<<<<<<<<<<<<<<
		
	
		cloud = new Cloud();
		tifa = new Tifa();
		vincent = new Vincent();
		ready = new ready();
		
		// >>>>>>>>>>> Center Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Bottom Center pane <<<<<<<<<<<<<<<<<<
		
		HBox btn = new HBox();
		btn.setAlignment(Pos.CENTER);
		btn.setSpacing(20);
		btn.setPrefHeight(120);
		btn.setStyle("-fx-background-color : black");
		
		playSceneToMenu = new Button("Back");
		this.setBackAction();
		start = new Button("Start");
		this.setStartAction();
		btn.getChildren().add(start);
		btn.getChildren().add(playSceneToMenu);
		start.setVisible(false);
		
		// >>>>>>>>>>> Bottom Center pane <<<<<<<<<<<<<<<<<<
		
		information.setBottom(btn);
		
		// >>>>>>>>>>> Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> left pane <<<<<<<<<<<<<<<<<<
		
		CharacterSelected = new VBox();
		CharacterSelected.setAlignment(Pos.CENTER);
		CharacterSelected.setSpacing(20);
		CharacterSelected.setPrefWidth(350);
		CharacterSelected.setStyle("-fx-background-color : DarkBlue");
		
		firstChar = new HBox();
		firstChar.setAlignment(Pos.CENTER);
		firstChar.setSpacing(15);
		
		Canvas firstCanvas = new Canvas(200, 200);
		firstGC = firstCanvas.getGraphicsContext2D();
		label1 = new Text("Cloud ");
		label1.setFont(Font.font(30));
		
		firstChar.getChildren().addAll(firstCanvas, label1);
		String imageFirst = "file:image/Great.jpg";
		Image img1 = new Image(imageFirst);
		firstGC.drawImage(img1, 0, 0, 180, 180);
		this.setFirstCharAction();
		
		secondChar = new HBox();
		secondChar.setAlignment(Pos.CENTER);
		secondChar.setSpacing(15);
		
		Canvas secondCanvas = new Canvas(200, 200);
		secondGC = secondCanvas.getGraphicsContext2D();
		label2 = new Text("Tifa     ");
		label2.setFont(Font.font(30));
		
		secondChar.getChildren().addAll(secondCanvas, label2);
		String imageSecond = "file:image/Jiji.jpg";
		Image img2 = new Image(imageSecond);
		secondGC.drawImage(img2, 0, 0, 180, 180);
		this.setSecondCharAction();
		
		thirdChar = new HBox();
		thirdChar.setAlignment(Pos.CENTER);
		thirdChar.setSpacing(15);
		
		Canvas thirdCanvas = new Canvas(200, 200);
		thirdGC = thirdCanvas.getGraphicsContext2D();
		label3 = new Text("Vincent");
		label3.setFont(Font.font(30));
		
		thirdChar.getChildren().addAll(thirdCanvas, label3);
		String imageThird = "file:image/SoSo.jpg";
		Image img3 = new Image(imageThird);
		thirdGC.drawImage(img3, 0, 0, 180, 180);
		this.setThirdCharAction();
		
		
		CharacterSelected.getChildren().add(firstChar);
		CharacterSelected.getChildren().add(secondChar);
		CharacterSelected.getChildren().add(thirdChar);
		
		// >>>>>>>>>>> left pane <<<<<<<<<<<<<<<<<<
		
		this.setLeft(CharacterSelected);
		this.setCenter(information);
		
		
		// >>>>>>>>>>>>>>> Play Scene <<<<<<<<<<<<<<<<<<<<<
				
	}
	
	private void setBackAction() {
		this.playSceneToMenu.setOnAction(e -> {
			SceneManagement.switchScene(SceneManagement.menuScene);
			soundManagement.music();
			firstChar.setVisible(true);
			secondChar.setVisible(true);
			thirdChar.setVisible(true);
			start.setVisible(false);
			CharacterSelected.setMouseTransparent(false);
			ready.clear();
		});
	}
	
	
	private void setPlaySceneAction() {
		this.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE) {
				CharacterSelected.setMouseTransparent(false);
				firstChar.setVisible(true);
				secondChar.setVisible(true);
				thirdChar.setVisible(true);
				start.setVisible(false);
				ready.clear();
			}
		});
	}
	
	private void setStartAction() {
		start.setOnMouseClicked(e -> {
			GameScene.drawChar(CharToPlay);
			switch (CharToPlay) {
			case 1: GameScene.setGameAction(Character_Ani.getChar1(), 
					Character_Ani.getChar2(), 
					Character_Ani.getChar3(), 
					Character_Ani.getChar4()); break;
					
			case 2: GameScene.setGameAction(Character_Ani.getCharII1(), 
					Character_Ani.getCharII2(), 
					Character_Ani.getCharII3(), 
					Character_Ani.getCharII4()); break;
			
			case 3: GameScene.setGameAction(Character_Ani.getCharIII1(), 
					Character_Ani.getCharIII2(), 
					Character_Ani.getCharIII3(), 
					Character_Ani.getCharIII4()); break;
			}
			SceneManagement.switchScene(SceneManagement.gameScene);
			soundManagement.gameSound1();
		});
	}
	
	private void setFirstCharAction() {
		firstChar.setOnMouseEntered(e -> {
			soundManagement.charSelect();
			label1.setFill(Color.RED);
			label1.setStyle("-fx-font-weight : bolder");
			information.setCenter(cloud);
			cloud.set();
		});
		
		firstChar.setOnMouseExited(e -> {
			label1.setFill(Color.BLACK);
			label1.setStyle("-fx-font-weight : normal");
			cloud.clear();
		});
		
		firstChar.setOnMouseClicked(e -> {
			CharToPlay = 1;
			soundManagement.confirmed();
			CharacterSelected.setMouseTransparent(true);
			secondChar.setVisible(false);
			thirdChar.setVisible(false);
			start.setVisible(true);
			information.setCenter(ready);
			ready.set();
		});
	}
	
	private void setSecondCharAction() {
		secondChar.setOnMouseEntered(e -> {
			soundManagement.charSelect();
			label2.setFill(Color.RED);
			label2.setStyle("-fx-font-weight : bolder");
			information.setCenter(tifa);
			tifa.set();
		});
		
		secondChar.setOnMouseExited(e -> {
			label2.setFill(Color.BLACK);
			label2.setStyle("-fx-font-weight : normal");
			tifa.clear();
		});
		
		secondChar.setOnMouseClicked(e -> {
			CharToPlay = 2;
			soundManagement.confirmed();
			CharacterSelected.setMouseTransparent(true);
			firstChar.setVisible(false);
			thirdChar.setVisible(false);
			start.setVisible(true);
			information.setCenter(ready);
			ready.set();
		});
	}

	private void setThirdCharAction() {
		thirdChar.setOnMouseEntered(e -> {
			soundManagement.charSelect();
			label3.setFill(Color.RED);
			label3.setStyle("-fx-font-weight : bolder");
			information.setCenter(vincent);
			vincent.set();
		});
		
		thirdChar.setOnMouseExited(e -> {
			label3.setFill(Color.BLACK);
			label3.setStyle("-fx-font-weight : normal");
			vincent.clear();
		});
		
		thirdChar.setOnMouseClicked(e -> {
			CharToPlay = 3;
			soundManagement.confirmed();
			CharacterSelected.setMouseTransparent(true);
			firstChar.setVisible(false);
			secondChar.setVisible(false);
			start.setVisible(true);
			information.setCenter(ready);
			ready.set();
		});
	}
	
}
