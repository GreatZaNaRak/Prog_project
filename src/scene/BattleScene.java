package scene;


import java.util.ArrayList;
import java.util.Random;

import Character_Animate.Character_Ani;
import Character_Logic.Character;
import Character_Logic.AllCharacter;
import SceneManage.SceneManagement;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sound.soundManagement;

public class BattleScene extends BorderPane{
	
	private static GraphicsContext bgGc, enermyGC;
	private static Image img, castle, enemy1, enemy2;
	private static Image enemy3, enemy4, enemy5;
	private static Button back, action, EndTurn, normalAttack, skill1, skill2;
	public static Label char1health, char2health, char3health, enemyHealth1, enemyHealth2;
	public static Label enemyHealth3, enemyHealth4, enemyHealth5;
	private static AllCharacter allChar;
	private static HBox box;
	private static AnimationTimer walk;
	private static VBox skill;
	public static int turn = 1, skillCount = 1, t1;

	public BattleScene() {
		
		// >>>>>>>>>>> stage <<<<<<<<<<<<<<<
		
		Canvas bgCavnas = new Canvas(900, 700);
		bgGc = bgCavnas.getGraphicsContext2D();
		
		Canvas enermyCanvas = new Canvas(900, 700);
		enermyGC = enermyCanvas.getGraphicsContext2D();
		
		img = new Image(ClassLoader.getSystemResource("bg.png").toString());
		castle = new Image(ClassLoader.getSystemResource("evil-castle.jpg").toString());
		enemy1 = new Image(ClassLoader.getSystemResource("ogre.png").toString());
		enemy2 = new Image(ClassLoader.getSystemResource("pyro_idle.gif").toString());
		enemy3 = new Image(ClassLoader.getSystemResource("skeleton.png").toString());
		enemy4 = new Image(ClassLoader.getSystemResource("Warlock.png").toString());
		enemy5 = new Image(ClassLoader.getSystemResource("boss.png").toString());
		
		allChar = new AllCharacter();
		
		
		StackPane bg = new StackPane();
		bg.getChildren().add(bgCavnas);
		bg.getChildren().add(enermyCanvas);
		this.setCenter(bg);
		
		// >>>>>>>>>>> stage <<<<<<<<<<<<<<<
		
		this.setBottom(box);
		
	}
	
	public static void update() {
		
		boolean check = false;
		action.setDisable(false);
		EndTurn.setDisable(true);
		normalAttack.setDisable(true);
		skill1.setDisable(true);
		skill2.setDisable(true);
		for (int i = 0 ; i < AllCharacter.getMyHero().size() ; i++) {
			if (!AllCharacter.getMyHero().get(i).isAlive()) {
				AllCharacter.getMyHero().remove(i);
				check = true;
			}
		}
		if (AllCharacter.getMyHero().size() == 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("GAME OVER, Please try again");
			alert.showAndWait();
			Platform.exit();
			return;
		}
		if (check) resetTurn();
		char1health.setText(""+AllCharacter.getCharacters().get(0).getHealth()+"/"+AllCharacter.getCharacters().get(0).getMana());
		char2health.setText(""+AllCharacter.getCharacters().get(1).getHealth()+"/"+AllCharacter.getCharacters().get(1).getMana());
		char3health.setText(""+AllCharacter.getCharacters().get(2).getHealth()+"/"+AllCharacter.getCharacters().get(2).getMana());
	}
	
	public static void drawCommandBox(int enermyID) {
		
		if (GameScene.enermyID <= 4) {
			bgGc.drawImage(img, 0, 0, 900, 700);
		} else {
			bgGc.drawImage(castle, 0, 0, 900, 700);
		}
		
		bgGc.drawImage(Character_Ani.getChar1(), 250, 240, 70, 70);
		bgGc.drawImage(Character_Ani.getCharII1(), 250, 370, 70, 70);
		bgGc.drawImage(Character_Ani.getCharIII1(), 250, 500, 70, 70);
		
		box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setPrefHeight(200);
		box.setStyle("-fx-background-color : blue");
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>> Enermy Information <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		switch (enermyID) {
		case 3:
			VBox enermyBox1 = new VBox();
			enermyBox1.setPrefWidth(280);
			enermyBox1.setAlignment(Pos.CENTER);
			enermyBox1.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
			
			HBox enermyInfo1 = new HBox();
			enermyInfo1.setSpacing(20);
			enermyInfo1.setPadding(new Insets(0, 0, 0, 30));
			
			Label enermy1Label = new Label("Enemy A");
			enermy1Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			
			enemyHealth1 = new Label();
			enemyHealth1.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth1.setText(""+AllCharacter.getCharacters().get(3).getHealth()+"/"+AllCharacter.getCharacters().get(3).getMana());
			
			enermyInfo1.getChildren().addAll(enermy1Label, enemyHealth1);
			
			enermyBox1.getChildren().add(enermyInfo1);
			box.getChildren().add(enermyBox1);
			break;
		case 4:
			VBox enermyBox2 = new VBox();
			enermyBox2.setAlignment(Pos.CENTER);
			enermyBox2.setPrefWidth(280);
			enermyBox2.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
			
			HBox enermyInfo2 = new HBox();
			enermyInfo2.setSpacing(20);
			enermyInfo2.setPadding(new Insets(0, 0, 0, 30));
			
			Label enermy2Label = new Label("Enemy B");
			enermy2Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			
			enemyHealth2 = new Label();
			enemyHealth2.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth2.setText(""+AllCharacter.getCharacters().get(4).getHealth()+"/"+AllCharacter.getCharacters().get(4).getMana());
			
			enermyInfo2.getChildren().addAll(enermy2Label, enemyHealth2);
			
			enermyBox2.getChildren().add(enermyInfo2);
			
			
			box.getChildren().add(enermyBox2);
			break;
		case 5:
			VBox enermyBox3 = new VBox();
			enermyBox3.setAlignment(Pos.CENTER);
			enermyBox3.setPrefWidth(280);
			enermyBox3.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
			
			HBox enermyInfo3 = new HBox();
			enermyInfo3.setSpacing(20);
			enermyInfo3.setPadding(new Insets(0, 0, 0, 30));
			
			Label enermy3Label = new Label("Enemy C");
			enermy3Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			
			enemyHealth3 = new Label();
			enemyHealth3.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth3.setText(""+AllCharacter.getCharacters().get(5).getHealth()+"/"+AllCharacter.getCharacters().get(5).getMana());
			
			enermyInfo3.getChildren().addAll(enermy3Label, enemyHealth3);
			
			enermyBox3.getChildren().add(enermyInfo3);
			
			
			box.getChildren().add(enermyBox3);
			break;
		case 6:
			VBox enermyBox4 = new VBox();
			enermyBox4.setAlignment(Pos.CENTER);
			enermyBox4.setPrefWidth(280);
			enermyBox4.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
			
			HBox enermyInfo4 = new HBox();
			enermyInfo4.setSpacing(20);
			enermyInfo4.setPadding(new Insets(0, 0, 0, 30));
			
			Label enermy4Label = new Label("Enemy D");
			enermy4Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			
			enemyHealth4 = new Label();
			enemyHealth4.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth4.setText(""+AllCharacter.getCharacters().get(6).getHealth()+"/"+AllCharacter.getCharacters().get(6).getMana());
			
			enermyInfo4.getChildren().addAll(enermy4Label, enemyHealth4);
			
			enermyBox4.getChildren().add(enermyInfo4);
			
			
			box.getChildren().add(enermyBox4);
			break;
		case 7:
			VBox enermyBox5 = new VBox();
			enermyBox5.setAlignment(Pos.CENTER);
			enermyBox5.setPrefWidth(280);
			enermyBox5.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
			
			HBox enermyInfo5 = new HBox();
			enermyInfo5.setSpacing(20);
			enermyInfo5.setPadding(new Insets(0, 0, 0, 30));
			
			Label enermy5Label = new Label("Enemy E");
			enermy5Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			
			enemyHealth5 = new Label();
			enemyHealth5.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
			enemyHealth5.setText(""+AllCharacter.getCharacters().get(7).getHealth()+"/"+AllCharacter.getCharacters().get(7).getMana());
			
			enermyInfo5.getChildren().addAll(enermy5Label, enemyHealth5);
			
			enermyBox5.getChildren().add(enermyInfo5);
			
			
			box.getChildren().add(enermyBox5);
			break;
		default:
			break;
		}
		
		// >>>>>>>>>>>>>>>>>>>>> Character Information <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		VBox charInfo = new VBox();
		charInfo.setAlignment(Pos.CENTER);
		charInfo.setPrefWidth(300);
		charInfo.setSpacing(10);
		charInfo.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
		
		HBox char1Info = new HBox();
		char1Info.setSpacing(30);
		char1Info.setPadding(new Insets(0, 0, 0, 30));
		Label char1Label = new Label("CLOUD");
		char1Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
		char1health = new Label();
		char1health.setText(""+AllCharacter.getCharacters().get(0).getHealth()+"/"+AllCharacter.getCharacters().get(0).getMana());
		char1health.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
		char1Info.getChildren().addAll(char1Label, char1health);
		
		HBox char2Info = new HBox();
		char2Info.setSpacing(30);
		char2Info.setPadding(new Insets(0, 0, 0, 30));
		Label char2Label = new Label("TIFA");
		char2Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
		char2health = new Label();
		char2health.setText(""+AllCharacter.getCharacters().get(1).getHealth()+"/"+AllCharacter.getCharacters().get(1).getMana());
		char2health.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
		char2Info.getChildren().addAll(char2Label, char2health);
		
		HBox char3Info = new HBox();
		char3Info.setSpacing(30);
		char3Info.setPadding(new Insets(0, 0, 0, 30));
		Label char3Label = new Label("VINCENT");
		char3Label.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
		char3health = new Label();
		char3health.setText(""+AllCharacter.getCharacters().get(2).getHealth()+"/"+AllCharacter.getCharacters().get(2).getMana());
		char3health.setStyle("-fx-font-size : 25;-fx-font-weight: bold");
		char3Info.getChildren().addAll(char3Label, char3health);
		
		charInfo.getChildren().addAll(char1Info, char2Info, char3Info);
		
		// >>>>>>>>>>>>>>>>>> command <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		VBox command = new VBox();
		command.setSpacing(15);
		command.setPrefWidth(150);
		command.setAlignment(Pos.CENTER);
		command.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
		
		action = new Button("Action");
		action.setPrefWidth(80);
		back = new Button("Escape");
		back.setPrefWidth(80);
		EndTurn = new Button("EndTurn");
		EndTurn.setPrefWidth(80);
		EndTurn.setDisable(true);
		
		command.getChildren().addAll(action, EndTurn, back);
		
		box.getChildren().add(charInfo);
		box.getChildren().add(command);
		
		// >>>>>>>>>>>>>>>> skill <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		
		skill = new VBox();
		skill.setSpacing(15);
		skill.setPrefWidth(170);
		skill.setAlignment(Pos.CENTER);
		skill.setStyle("-fx-border-color: white;-fx-border-width: 5;-fx-border-style: solid;");
		
		normalAttack = new Button("N-atk"); normalAttack.setPrefWidth(80);
		skill1 = new Button(); skill1.setPrefWidth(80);
		skill2 = new Button(); skill2.setPrefWidth(80);
		
		
		
		// >>>>>>>>>>>>>>>> handle button <<<<<<<<<<<<<<<<<<<<<<<<<<
		
		box.getChildren().add(skill);
		
		action.setOnMouseClicked(e -> {
			eiei();
			t1 = turn % (AllCharacter.getMyHero().size()+1);
			switch (t1) {
			case 1 :
				if (skillCount == 1);
				else skill.getChildren().remove(0, 3);
				if (AllCharacter.getMyHero().get(t1-1).getName().equalsIgnoreCase("cloud")) cloudSkill();
				else if (AllCharacter.getMyHero().get(t1-1).getName().equalsIgnoreCase("tifa")) tifaSkill();
				else vincentSkill();
				skillCount++;
				break;
			case 2 :
				skill.getChildren().remove(0, 3);
				if (AllCharacter.getMyHero().get(t1-1).getName().equalsIgnoreCase("cloud")) cloudSkill();
				else if (AllCharacter.getMyHero().get(t1-1).getName().equalsIgnoreCase("tifa")) tifaSkill();
				else vincentSkill();
				break;
			case 3:
				skill.getChildren().remove(0, 3);
				if (AllCharacter.getMyHero().get(t1-1).getName().equalsIgnoreCase("cloud")) cloudSkill();
				else if (AllCharacter.getMyHero().get(t1-1).getName().equalsIgnoreCase("tifa")) tifaSkill();
				else vincentSkill();
				break;		
			}
			action.setDisable(true);
			EndTurn.setDisable(false);
		});
		
		back.setOnMouseClicked(e -> {
			enermyGC.clearRect(0, 0, 2000, 900);
			skillCount = 1;
			resetTurn();
			if (enermyID <= 4) {
				soundManagement.stopGameSound();
				SceneManagement.switchScene(SceneManagement.gameScene);
				soundManagement.gameSound1();
			} else {
				soundManagement.stopGameSound();
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.gameSound2();
			}
		});
		
		EndTurn.setOnMouseClicked(e -> {
			walk.stop();
			if (turn % (AllCharacter.getMyHero().size()+1) == 0) {
				action.setDisable(true);
				int target = new Random().nextInt(AllCharacter.getMyHero().size());
				switch (GameScene.enermyID) {
				case 3:
					AllCharacter.getMyHero().get(target).takeDamage(AllCharacter.getCharacters().get(3).getDamage());
					break;
				case 4:
					AllCharacter.getMyHero().get(target).takeDamage(AllCharacter.getCharacters().get(4).getDamage());
					break;
				case 5:
					AllCharacter.getMyHero().get(target).takeDamage(AllCharacter.getCharacters().get(5).getDamage());
					break;
				case 6:
					AllCharacter.getMyHero().get(target).takeDamage(AllCharacter.getCharacters().get(6).getDamage());
					break;
				case 7:
					AllCharacter.getMyHero().get(target).takeDamage(AllCharacter.getCharacters().get(7).getDamage());
					break;
				default:
					break;
				}
			}
			turn++;
			update();
		});
		
	}
	
	public static void enemyDied() {
		switch (GameScene.enermyID) {
		case 3:
			if (AllCharacter.getCharacters().get(3).getHealth() <= 0) {
				AllCharacter.getCharacters().get(3).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("YOU WIN !!!");
				alert.showAndWait();
				enermyGC.clearRect(0, 0, 2000, 900);
				GameScene.enemy1GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.gameScene);
				soundManagement.stopGameSound();
				soundManagement.gameSound1();
				resetTurn();
				skillCount = 1;
			}
			break;
		case 4:
			if (AllCharacter.getCharacters().get(4).getHealth() <= 0) {
				AllCharacter.getCharacters().get(4).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("YOU WIN !!!");
				alert.showAndWait();
				enermyGC.clearRect(0, 0, 2000, 900);
				GameScene.enemy2GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.gameScene);
				soundManagement.stopGameSound();
				soundManagement.gameSound1();
				resetTurn();
				skillCount = 1;
			}
			break;
		case 5:
			if (AllCharacter.getCharacters().get(5).getHealth() <= 0) {
				AllCharacter.getCharacters().get(5).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("YOU WIN !!!");
				alert.showAndWait();
				enermyGC.clearRect(0, 0, 2000, 900);
				stage_1.enemy1GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.stopGameSound();
				soundManagement.gameSound2();
				resetTurn();
				skillCount = 1;
			}
			break;
		case 6:
			if (AllCharacter.getCharacters().get(6).getHealth() <= 0) {
				AllCharacter.getCharacters().get(6).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("YOU WIN !!!");
				alert.showAndWait();
				enermyGC.clearRect(0, 0, 2000, 900);
				stage_1.enemy2GC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.stopGameSound();
				soundManagement.gameSound2();
				resetTurn();
				skillCount = 1;
			}
			break;
		case 7:
			if (AllCharacter.getCharacters().get(7).getHealth() <= 0) {
				AllCharacter.getCharacters().get(7).setIsAlive(false);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("YOU WIN !!!");
				alert.showAndWait();
				enermyGC.clearRect(0, 0, 2000, 900);
				stage_1.bossGC.clearRect(0, 0, 2000, 900);
				SceneManagement.switchScene(SceneManagement.stage1Scene);
				soundManagement.stopGameSound();
				soundManagement.gameSound2();
				resetTurn();
				skillCount = 1;
			}
			break;
		default:
			break;
		}
	}
	
	public static void eiei() {
		
		int du = turn % (AllCharacter.getMyHero().size()+1);
		du--;
		if (du >= 0) {
			switch (du) {
			case 0:
				walk = new AnimationTimer() {
					int i = 250;
					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						i++;
						if (i == 400) walk.stop();
						bgGc.clearRect(0, 0, 2000, 900);
						if (GameScene.enermyID <= 4) {
							bgGc.drawImage(img, 0, 0, 900, 700);
						} else {
							bgGc.drawImage(castle, 0, 0, 900, 700);
						}
						bgGc.drawImage(Character_Ani.getChar1(), i, 240, 70, 70);
						bgGc.drawImage(Character_Ani.getCharII1(), 250, 370, 70, 70);
						bgGc.drawImage(Character_Ani.getCharIII1(), 250, 500, 70, 70);
					}
				};walk.start(); 
				break;
			case 1:
				walk = new AnimationTimer() {
					int i = 250;
					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						i++;
						if (i == 400) walk.stop();
						bgGc.clearRect(0, 0, 2000, 900);
						if (GameScene.enermyID <= 4) {
							bgGc.drawImage(img, 0, 0, 900, 700);
						} else {
							bgGc.drawImage(castle, 0, 0, 900, 700);
						}
						bgGc.drawImage(Character_Ani.getChar1(), 250, 240, 70, 70);
						bgGc.drawImage(Character_Ani.getCharII1(), i, 370, 70, 70);
						bgGc.drawImage(Character_Ani.getCharIII1(), 250, 500, 70, 70);
					}
				};walk.start();
				break;
			case 2:
				walk = new AnimationTimer() {
					int i = 250;
					@Override
					public void handle(long now) {
						// TODO Auto-generated method stub
						i++;
						if (i == 400) walk.stop();
						bgGc.clearRect(0, 0, 2000, 900);
						if (GameScene.enermyID <= 4) {
							bgGc.drawImage(img, 0, 0, 900, 700);
						} else {
							bgGc.drawImage(castle, 0, 0, 900, 700);
						}
						bgGc.drawImage(Character_Ani.getChar1(), 250, 240, 70, 70);
						bgGc.drawImage(Character_Ani.getCharII1(), 250, 370, 70, 70);
						bgGc.drawImage(Character_Ani.getCharIII1(), i, 500, 70, 70);
					}
				};walk.start();
				break;
			}
		} else {
			bgGc.clearRect(0, 0, 2000, 900);
			if (GameScene.enermyID <= 4) {
				bgGc.drawImage(img, 0, 0, 900, 700);
			} else {
				bgGc.drawImage(castle, 0, 0, 900, 700);
			}
			bgGc.drawImage(Character_Ani.getChar1(), 250, 240, 70, 70);
			bgGc.drawImage(Character_Ani.getCharII1(), 250, 370, 70, 70);
			bgGc.drawImage(Character_Ani.getCharIII1(), 250, 500, 70, 70);
		}
	}
	
	public static void drawEnermy() {
		switch (GameScene.enermyID) {
		case 3:
			enermyGC.drawImage(enemy1, 650, 370, 70, 70);
			break;
		case 4:
			enermyGC.drawImage(enemy2, 650, 370, 70, 70);
			break;
		case 5:
			enermyGC.drawImage(enemy3, 650, 370, 70, 70);
			break;
		case 6:
			enermyGC.drawImage(enemy4, 650, 370, 70, 70);
			break;
		case 7:
			enermyGC.drawImage(enemy5, 650, 300, 150, 150);
			break;
		default:
			System.out.println("..");
			break;
		}
	}
	
	public static void updateEnemyInfo() {
		switch (GameScene.enermyID) {
		case 3:
			enemyHealth1.setText(""+AllCharacter.getCharacters().get(GameScene.enermyID)
					.getHealth()+"/"+AllCharacter.getCharacters().get(GameScene.enermyID).getMana());
			break;
		case 4:
			enemyHealth2.setText(""+AllCharacter.getCharacters().get(GameScene.enermyID)
					.getHealth()+"/"+AllCharacter.getCharacters().get(GameScene.enermyID).getMana());
			break;
		case 5:
			enemyHealth3.setText(""+AllCharacter.getCharacters().get(GameScene.enermyID)
					.getHealth()+"/"+AllCharacter.getCharacters().get(GameScene.enermyID).getMana());
			break;
		case 6:
			enemyHealth4.setText(""+AllCharacter.getCharacters().get(GameScene.enermyID)
					.getHealth()+"/"+AllCharacter.getCharacters().get(GameScene.enermyID).getMana());
			break;
		case 7:
			enemyHealth5.setText(""+AllCharacter.getCharacters().get(GameScene.enermyID)
					.getHealth()+"/"+AllCharacter.getCharacters().get(GameScene.enermyID).getMana());
			break;
		}
	}
	
	public static void cloudSkill() {
		skill1.setText("Slash");
		skill2.setText("Warcry");
		normalAttack.setDisable(false);
		skill1.setDisable(false);
		skill2.setDisable(false);
		normalAttack.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(GameScene.enermyID).takeDamage(AllCharacter.getCharacters().get(t1-1).getDamage());
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill1.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(GameScene.enermyID).takeDamage(100);
			updateEnemyInfo();
			enemyDied();
			AllCharacter.getMyHero().get(t1-1).setMana(AllCharacter.getMyHero().get(t1-1).getMana() - 50);
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill2.setOnMouseClicked(e -> {
			//do something
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill.getChildren().addAll(normalAttack, skill1, skill2);
	}
	
	public static void tifaSkill() {
		skill1.setText("Heal");
		skill2.setText("Fear");
		normalAttack.setDisable(false);
		skill1.setDisable(false);
		skill2.setDisable(false);
		normalAttack.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(GameScene.enermyID).takeDamage(AllCharacter.getCharacters().get(t1-1).getDamage());
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill1.setOnMouseClicked(e -> {
			for (int i = 0 ; i < AllCharacter.getMyHero().size() ; i++) {
				AllCharacter.getMyHero().get(i).getHeal(40);
			}
			updateEnemyInfo();
			AllCharacter.getMyHero().get(t1-1).setMana(AllCharacter.getMyHero().get(t1-1).getMana() - 50);
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill2.setOnMouseClicked(e -> {
			//do something
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill.getChildren().addAll(normalAttack, skill1, skill2);
	}

	public static void vincentSkill() {
		skill1.setText("Tackle");
		skill2.setText("Resist");
		normalAttack.setDisable(false);
		skill1.setDisable(false);
		skill2.setDisable(false);
		normalAttack.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(GameScene.enermyID).takeDamage(AllCharacter.getCharacters().get(t1-1).getDamage());
			updateEnemyInfo();
			enemyDied();
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill1.setOnMouseClicked(e -> {
			AllCharacter.getCharacters().get(GameScene.enermyID).takeDamage(100);
			updateEnemyInfo();
			enemyDied();
			AllCharacter.getMyHero().get(t1-1).setMana(AllCharacter.getMyHero().get(t1-1).getMana() - 50);
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill2.setOnMouseClicked(e -> {
			//do something
			normalAttack.setDisable(true);
			skill1.setDisable(true);
			skill2.setDisable(true);
		});
		
		skill.getChildren().addAll(normalAttack, skill1, skill2);
	}
	
	public static HBox getBox() {
		return box;
	}
	
	public static void resetTurn() {
		turn = 1;
	}

}
