package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Label;
import java.util.Optional;
import Character_Animate.*;
import Draw.DrawMenuScene;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import scene.creditScene;
import sound.soundManagement;


public class Final_Fantasy_II extends Application {
	
	private static int count = 1;
	static BorderPane root;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)  {
		
		soundManagement sound = new soundManagement();
		DrawMenuScene draw = new DrawMenuScene();
		
		root = new BorderPane();
		
		
		Scene primarySene = new Scene(root, 300, 300);
		
		
		// >>>>>>>>>>>>>>> Credit Scene <<<<<<<<<<<<<<<<<<<<<
		
		VBox forCreditScene = new VBox();
		forCreditScene.setSpacing(100);
		forCreditScene.setStyle("-fx-background-color : black");
		forCreditScene.setAlignment(Pos.CENTER);
		
		Scene creditScene = new Scene(forCreditScene);
		
		Text great = new Text("Great");
		great.setStyle("-fx-font-size : 50");
		great.setStroke(Color.BLACK);
		great.setStrokeWidth(3);
		great.setFill(Color.WHITE);
		great.setFont(Font.font("Comic Sans MS"));
		
		Text monde = new Text("Monde");
		monde.setStyle("-fx-font-size : 50");
		monde.setStroke(Color.BLACK);
		monde.setStrokeWidth(3);
		monde.setFill(Color.WHITE);
		monde.setFont(Font.font("Comic Sans MS"));
		
		Text cre = new Text("This is a game from CP44\nstudent! hope you enjoy!!\nDone by:");
		cre.setTextAlignment(TextAlignment.CENTER);
		cre.setStyle("-fx-font-size : 50");
		cre.setStroke(Color.BLACK);
		cre.setStrokeWidth(3);
		cre.setFill(Color.WHITE);
		cre.setFont(Font.font("Comic Sans MS"));
		
		Button back = new Button("Back");
		back.setPrefWidth(70);
		back.setPrefHeight(40);
		
		forCreditScene.getChildren().addAll(cre, monde, great, back);
		
		// >>>>>>>>>>>>>>> Credit Scene <<<<<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>>>>>> Play Scene <<<<<<<<<<<<<<<<<<<<<
		
		
		BorderPane BorderPlayScene = new BorderPane();
		BorderPane information = new BorderPane();
		
		// >>>>>>>>>>> Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Top Center pane <<<<<<<<<<<<<<<<<<
		
		Label sceneLabel = new Label("Character Select");
		sceneLabel.setFont(Font.font("Comic Sans MS", 45));
		sceneLabel.setTextFill(Color.WHITE);
		sceneLabel.setAlignment(Pos.CENTER);
		sceneLabel.setPrefHeight(120);
		sceneLabel.setPrefWidth(600);
		sceneLabel.setStyle("-fx-background-color : black");
		
		information.setTop(sceneLabel);
		
		
		// >>>>>>>>>>> Top Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Center Center pane <<<<<<<<<<<<<<<<<<
		
	
		Cloud cloud = new Cloud();
		Tifa tifa = new Tifa();
		Vincent vincent = new Vincent();
		ready ready = new ready();
		
		// >>>>>>>>>>> Center Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> Bottom Center pane <<<<<<<<<<<<<<<<<<
		
		HBox btn = new HBox();
		btn.setAlignment(Pos.CENTER);
		btn.setSpacing(20);
		btn.setPrefHeight(120);
		btn.setStyle("-fx-background-color : black");
		
		Button playSceneToMenu = new Button("Back");
		Button start = new Button("Start");
		btn.getChildren().add(start);
		btn.getChildren().add(playSceneToMenu);
		start.setVisible(false);
		
		// >>>>>>>>>>> Bottom Center pane <<<<<<<<<<<<<<<<<<
		
		information.setBottom(btn);
		
		// >>>>>>>>>>> Center pane <<<<<<<<<<<<<<<<<<
		
		// >>>>>>>>>>> left pane <<<<<<<<<<<<<<<<<<
		
		VBox CharacterSelected = new VBox();
		CharacterSelected.setAlignment(Pos.CENTER);
		CharacterSelected.setSpacing(20);
		CharacterSelected.setPrefWidth(350);
		CharacterSelected.setStyle("-fx-background-color : DarkBlue");
		
		HBox firstChar = new HBox();
		firstChar.setAlignment(Pos.CENTER);
		firstChar.setSpacing(15);
		
		Canvas firstCanvas = new Canvas(200, 200);
		GraphicsContext firstGC = firstCanvas.getGraphicsContext2D();
		Text label1 = new Text("Cloud ");
		label1.setFont(Font.font(30));
		
		firstChar.getChildren().addAll(firstCanvas, label1);
		String imageFirst = "file:image/Great.jpg";
		Image img1 = new Image(imageFirst);
		firstGC.drawImage(img1, 0, 0, 180, 180);
		
		HBox secondChar = new HBox();
		secondChar.setAlignment(Pos.CENTER);
		secondChar.setSpacing(15);
		
		Canvas secondCanvas = new Canvas(200, 200);
		GraphicsContext secondGC = secondCanvas.getGraphicsContext2D();
		Text label2 = new Text("Tefa   ");
		label2.setFont(Font.font(30));
		
		secondChar.getChildren().addAll(secondCanvas, label2);
		String imageSecond = "file:image/Jiji.jpg";
		Image img2 = new Image(imageSecond);
		secondGC.drawImage(img2, 0, 0, 180, 180);
		
		HBox thirdChar = new HBox();
		thirdChar.setAlignment(Pos.CENTER);
		thirdChar.setSpacing(15);
		
		Canvas thirdCanvas = new Canvas(200, 200);
		GraphicsContext thirdGC = thirdCanvas.getGraphicsContext2D();
		Text label3 = new Text("Vincent");
		label3.setFont(Font.font(30));
		
		thirdChar.getChildren().addAll(thirdCanvas, label3);
		String imageThird = "file:image/SoSo.jpg";
		Image img3 = new Image(imageThird);
		thirdGC.drawImage(img3, 0, 0, 180, 180);
		
		
		
		CharacterSelected.getChildren().add(firstChar);
		CharacterSelected.getChildren().add(secondChar);
		CharacterSelected.getChildren().add(thirdChar);
		
		// >>>>>>>>>>> left pane <<<<<<<<<<<<<<<<<<
		
		BorderPlayScene.setLeft(CharacterSelected);
		BorderPlayScene.setCenter(information);
		
		Scene playScene = new Scene(BorderPlayScene);
		
		
		// >>>>>>>>>>>>>>> Play Scene <<<<<<<<<<<<<<<<<<<<<
		
		
		
		Image icon = new Image("file:image/FFII_PSP_Logo.jpg");
		stage.getIcons().add(icon);
		stage.setTitle("FINAL FANTASY II");
		stage.setScene(primarySene);
		stage.setResizable(false);
		stage.setMinHeight(400);
		stage.setMinWidth(400);
		stage.setHeight(900);
		stage.setWidth(900);
		stage.show();
		
		// >>>>>>>>>>>>>>> Menu Scene <<<<<<<<<<<<<<<<<<<<<
		
		StackPane centerPane = new StackPane();
		
		Canvas canvas = new Canvas();
		canvas.setWidth(900);
		canvas.setHeight(900);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		VBox buttons = new VBox();
		buttons.setSpacing(0);
		buttons.setAlignment(Pos.BOTTOM_CENTER);
		buttons.setPadding(new Insets(50, 50, 50, 50));
		
		Text gameTitle = new Text("FINAL FANTASY X2");
		gameTitle.setTextAlignment(TextAlignment.CENTER);
		gameTitle.setStyle("-fx-font-weigt: bold; -fx-font-size : 75; -fx-fill :"
				+ "linear-gradient(from 0% 0% to 100% 200%, repeat, orange 30%, red 50%);");
		gameTitle.setStroke(Color.BLACK);
		gameTitle.setStrokeWidth(3);
		gameTitle.setFill(Color.WHITE);
		gameTitle.setFont(Font.font("Comic Sans MS"));
		
		Canvas playCanvas = new Canvas(400, 100);
		GraphicsContext playGC = playCanvas.getGraphicsContext2D();
		playGC.setFill(Color.BLACK);
		playGC.setTextAlign(TextAlignment.CENTER);
		playGC.setFont(Font.font("Comic Sans MS", 35));
		playGC.fillText("PLAY", 200, 50);
		
		Canvas creditCanvas = new Canvas(400, 100);
		GraphicsContext creditGC = creditCanvas.getGraphicsContext2D();
		creditGC.setFill(Color.BLACK);
		creditGC.setTextAlign(TextAlignment.CENTER);
		creditGC.setFont(Font.font("Comic Sans MS", 35));
		creditGC.fillText("CREDIT", 210, 50);
		
		Canvas exitCanvas = new Canvas(400, 100);
		GraphicsContext exitGC = exitCanvas.getGraphicsContext2D();
		exitGC.setFill(Color.BLACK);
		exitGC.setTextAlign(TextAlignment.CENTER);
		exitGC.setFont(Font.font("Comic Sans MS", 35));
		exitGC.fillText("EXIT", 200, 50);
		
		//buttons.getChildren().add(textCanvas);
		buttons.getChildren().add(gameTitle);
		buttons.getChildren().add(playCanvas);
		buttons.getChildren().add(creditCanvas);
		buttons.getChildren().add(exitCanvas);
		
		buttons.setVisible(false);
		
		
		VBox foreground = new VBox();
		foreground.setAlignment(Pos.CENTER);
		foreground.setSpacing(230);
		foreground.getChildren().add(gameTitle);
		foreground.getChildren().add(buttons);
		
		Canvas enterCanvas = new Canvas(760, 300);
		GraphicsContext enterGC = enterCanvas.getGraphicsContext2D();
		draw.drawEnter(enterGC);
			
			
		centerPane.getChildren().add(canvas);
		centerPane.getChildren().add(foreground);
		centerPane.getChildren().add(enterCanvas);
		
		root.setCenter(centerPane);
		
		// >>>>>>>>>>>>>>> Menu Scene <<<<<<<<<<<<<<<<<<<<<
		
		
		String image_path = "file:image/finalx2.jpg";
		
		sound.music();
		draw.drawCity(gc, image_path);
		
		
		// >>>>>>>>>>>>>>> action <<<<<<<<<<<<<<<<<<<<<<<<<<
		

		primarySene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ENTER && count == 1) {
					sound.gun();
					count++;
					enterCanvas.setVisible(false);
					buttons.setVisible(true);
				}
				else if (ke.getCode() == KeyCode.ESCAPE && buttons.isVisible()) {
					enterCanvas.setVisible(true);
					buttons.setVisible(false);
					count--;
				}
			}
		});
		
		
		playScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					CharacterSelected.setMouseTransparent(false);
					firstChar.setVisible(true);
					secondChar.setVisible(true);
					thirdChar.setVisible(true);
					start.setVisible(false);
					ready.clear();
				}
			}
		});
		
		
		
		playCanvas.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				
				
				playGC.setLineWidth(4);
				playGC.setStroke(Color.ORANGE);
				playGC.setFill(Color.WHITE);
				playGC.setFont(Font.font("Comic Sans MS", 35));
				playGC.setTextAlign(TextAlignment.CENTER);
				playGC.fillText("PLAY", 200, 50);
				playGC.moveTo(98, 20);
				playGC.lineTo(98, 50);
				playGC.lineTo(133, 35);
				playGC.closePath();
				playGC.stroke();
				
			}
		});
		
		playCanvas.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				playGC.setFill(Color.WHITE);
				playGC.clearRect(0, 0, 310, 80);
				playGC.setFill(Color.BLACK);
				playGC.setFont(Font.font("Comic Sans MS", 35));
				playGC.setTextAlign(TextAlignment.CENTER);
				playGC.fillText("PLAY", 200, 50);
				
			}
		});
		
		playCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.stopMusic();
				stage.setScene(playScene);
			}
		});
		
		creditCanvas.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				creditGC.setLineWidth(4);
				creditGC.setStroke(Color.ORANGE);
				creditGC.setFill(Color.WHITE);
				creditGC.setFont(Font.font("Comic Sans MS", 35));
				creditGC.setTextAlign(TextAlignment.CENTER);
				creditGC.fillText("CREDIT", 210, 50);
				//creditGC.strokeRect(0, 0, 150, 75);
				//creditGC.drawImage(img, 50, 15, 75, 55);
				creditGC.moveTo(90, 20);
				creditGC.lineTo(90, 50);
				creditGC.lineTo(125, 35);
				creditGC.closePath();
				//creditGC.moveTo(325, 20);
				//creditGC.lineTo(325, 50);
				//creditGC.lineTo(290, 34);
				//creditGC.closePath();
				creditGC.stroke();
				
			}
		});
		
		creditCanvas.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				creditGC.setFill(Color.WHITE);
				creditGC.clearRect(0, 0, 400, 80);
				creditGC.setFill(Color.BLACK);
				creditGC.setFont(Font.font("Comic Sans MS", 35));
				creditGC.setTextAlign(TextAlignment.CENTER);
				creditGC.fillText("CREDIT", 210, 50);
			}
		});
		
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			
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
		
		
		exitCanvas.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				exitGC.setLineWidth(4);
				exitGC.setStroke(Color.ORANGE);
				exitGC.setFill(Color.WHITE);
				exitGC.setFont(Font.font("Comic Sans MS", 35));
				exitGC.setTextAlign(TextAlignment.CENTER);
				exitGC.fillText("EXIT", 200, 50);
				//exitGC.strokeRect(0, 0, 150, 75);
				//exitGC.drawImage(img, 50, 15, 75, 55);
				exitGC.moveTo(100, 20);
				exitGC.lineTo(100, 50);
				exitGC.lineTo(135, 35);
				exitGC.closePath();
				//exitGC.moveTo(300, 20);
				//exitGC.lineTo(300, 50);
				//exitGC.lineTo(265, 34);
				//exitGC.closePath();
				exitGC.stroke();
			}
		});
		
		exitCanvas.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				exitGC.setFill(Color.WHITE);
				exitGC.clearRect(0, 0, 400, 80);
				exitGC.setFill(Color.BLACK);
				exitGC.setFont(Font.font("Comic Sans MS", 35));
				exitGC.setTextAlign(TextAlignment.CENTER);
				exitGC.fillText("EXIT", 200, 50);
			}
		});
		
		exitCanvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.gun();
				ButtonType foo = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
				ButtonType bar = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
				Alert alert = new Alert(AlertType.CONFIRMATION,
				        "Are you sure you want to exit the game?", foo, bar);
				alert.setTitle("Exit");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.orElse(bar) == foo) {
					stage.close();
				}
			}
		});
		
		playSceneToMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				stage.setScene(primarySene);
				sound.music();
				firstChar.setVisible(true);
				secondChar.setVisible(true);
				thirdChar.setVisible(true);
				start.setVisible(false);
				CharacterSelected.setMouseTransparent(false);
			}
		});
		
		firstChar.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.charSelect();
				label1.setFill(Color.RED);
				label1.setStyle("-fx-font-weight : bolder");
				information.setCenter(cloud);
				cloud.set();
			}
		});
		
		firstChar.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				label1.setFill(Color.BLACK);
				label1.setStyle("-fx-font-weight : normal");
				cloud.clear();
			}
		});
		
		firstChar.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.confirmed();
				sound.cloudVoice();
				CharacterSelected.setMouseTransparent(true);
				secondChar.setVisible(false);
				thirdChar.setVisible(false);
				start.setVisible(true);
				ready ready = new ready();
				information.setCenter(ready);
				ready.set();
			}
		});
		
		secondChar.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.charSelect();
				label2.setFill(Color.RED);
				label2.setStyle("-fx-font-weight : bolder");
				information.setCenter(tifa);
				tifa.set();
			}
		});
		
		secondChar.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				label2.setFill(Color.BLACK);
				label2.setStyle("-fx-font-weight : normal");
				tifa.clear();
			}
		});
		
		secondChar.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.confirmed();
				sound.tifaVoice();
				CharacterSelected.setMouseTransparent(true);
				firstChar.setVisible(false);
				thirdChar.setVisible(false);
				start.setVisible(true);
				ready ready = new ready();
				information.setCenter(ready);
				ready.set();
			}
		});
		
		thirdChar.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.charSelect();
				label3.setFill(Color.RED);
				label3.setStyle("-fx-font-weight : bolder");
				information.setCenter(vincent);
				vincent.set();
			}
		});
		
		thirdChar.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				label3.setFill(Color.BLACK);
				label3.setStyle("-fx-font-weight : normal");
				vincent.clear();
			}
		});
		
		thirdChar.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				sound.confirmed();
				sound.zackVoice();
				CharacterSelected.setMouseTransparent(true);
				secondChar.setVisible(false);
				firstChar.setVisible(false);
				start.setVisible(true);
				ready ready = new ready();
				information.setCenter(ready);
				ready.set();
			}
		});
		
	}


	
}