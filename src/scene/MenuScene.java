package scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.Optional;
import Draw.DrawMenuScene;
import SceneManage.SceneManagement;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sound.soundManagement;

public class MenuScene extends BorderPane {
	
	private static VBox buttons;
	private static Canvas playCanvas, creditCanvas, exitCanvas, enterCanvas;
	private static GraphicsContext playGC, creditGC, exitGC, enterGC;
	private static int count = 1;
	
	public MenuScene() {
		
		StackPane centerPane = new StackPane();
		
		buttons = new VBox();
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
		
		playCanvas = new Canvas(400, 100);
		playGC = playCanvas.getGraphicsContext2D();
		playGC.setFill(Color.BLACK);
		playGC.setTextAlign(TextAlignment.CENTER);
		playGC.setFont(Font.font("Comic Sans MS", 50));
		playGC.fillText("PLAY", 200, 50);
		this.setPlayCanvasAction();
		
		creditCanvas = new Canvas(400, 100);
		creditGC = creditCanvas.getGraphicsContext2D();
		creditGC.setFill(Color.BLACK);
		creditGC.setTextAlign(TextAlignment.CENTER);
		creditGC.setFont(Font.font("Comic Sans MS", 50));
		creditGC.fillText("CREDIT", 210, 50);
		this.setCreditCanvasAction();
		
		exitCanvas = new Canvas(400, 100);
		exitGC = exitCanvas.getGraphicsContext2D();
		exitGC.setFill(Color.BLACK);
		exitGC.setTextAlign(TextAlignment.CENTER);
		exitGC.setFont(Font.font("Comic Sans MS", 50));
		exitGC.fillText("EXIT", 200, 50);
		this.setExitCanvasAction();
		
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
		
		enterCanvas = new Canvas(760, 300);
		enterGC = enterCanvas.getGraphicsContext2D();
		DrawMenuScene.drawEnter(enterGC);
			
			
		
		DrawMenuScene.setBG(this);
		centerPane.getChildren().add(foreground);
		centerPane.getChildren().add(enterCanvas);
		this.setCenter(centerPane);
		
		soundManagement.music();
		
		
	}
	
	public static void setMenuAction() {
		SceneManagement.menuScene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER && count == 1) {
				soundManagement.gun();
				enterCanvas.setVisible(false);
				buttons.setVisible(true);
				count++;
			} else if (e.getCode() == KeyCode.ESCAPE && count != 1) {
				enterCanvas.setVisible(true);
				buttons.setVisible(false);
				count--;
			}
		});
	}
	
	private void setPlayCanvasAction() {
		playCanvas.setOnMouseEntered(e -> {
			playGC.setLineWidth(4);
			playGC.setStroke(Color.ORANGE);
			playGC.setFill(Color.WHITE);
			playGC.setFont(Font.font("Comic Sans MS", 50));
			playGC.setTextAlign(TextAlignment.CENTER);
			playGC.fillText("PLAY", 200, 50);
			playGC.moveTo(80, 20);
			playGC.lineTo(80, 50);
			playGC.lineTo(115, 35);
			playGC.closePath();
			playGC.stroke();
		});
		
		playCanvas.setOnMouseExited(e -> {
			playGC.setFill(Color.WHITE);
			playGC.clearRect(0, 0, 310, 80);
			playGC.setFill(Color.BLACK);
			playGC.setFont(Font.font("Comic Sans MS", 50));
			playGC.setTextAlign(TextAlignment.CENTER);
			playGC.fillText("PLAY", 200, 50);
		});
		
		playCanvas.setOnMouseClicked(e -> {
			soundManagement.confirmed();
			SceneManagement.switchScene(SceneManagement.playScene);
			soundManagement.stopMusic();
		});
	}
	
	private void setCreditCanvasAction() {
		creditCanvas.setOnMouseEntered(e -> {
			creditGC.setLineWidth(4);
			creditGC.setStroke(Color.ORANGE);
			creditGC.setFill(Color.WHITE);
			creditGC.setFont(Font.font("Comic Sans MS", 50));
			creditGC.setTextAlign(TextAlignment.CENTER);
			creditGC.fillText("CREDIT", 210, 50);
			creditGC.moveTo(60, 20);
			creditGC.lineTo(60, 50);
			creditGC.lineTo(95, 35);
			creditGC.closePath();
			creditGC.stroke();
		});
		
		creditCanvas.setOnMouseExited(e -> {
			creditGC.setFill(Color.WHITE);
			creditGC.clearRect(0, 0, 400, 80);
			creditGC.setFill(Color.BLACK);
			creditGC.setFont(Font.font("Comic Sans MS", 50));
			creditGC.setTextAlign(TextAlignment.CENTER);
			creditGC.fillText("CREDIT", 210, 50);
		});
		
		creditCanvas.setOnMouseClicked(e -> {
			soundManagement.confirmed();
			soundManagement.stopMusic();
			SceneManagement.switchScene(SceneManagement.creditScene);
		});
	}
	
	private void setExitCanvasAction() {
		exitCanvas.setOnMouseEntered(e -> {
			exitGC.setLineWidth(4);
			exitGC.setStroke(Color.ORANGE);
			exitGC.setFill(Color.WHITE);
			exitGC.setFont(Font.font("Comic Sans MS", 50));
			exitGC.setTextAlign(TextAlignment.CENTER);
			exitGC.fillText("EXIT", 200, 50);
			exitGC.moveTo(80, 20);
			exitGC.lineTo(80, 50);
			exitGC.lineTo(115, 35);
			exitGC.closePath();
			exitGC.stroke();
		});
		
		exitCanvas.setOnMouseExited(e -> {
			exitGC.setFill(Color.WHITE);
			exitGC.clearRect(0, 0, 400, 80);
			exitGC.setFill(Color.BLACK);
			exitGC.setFont(Font.font("Comic Sans MS", 50));
			exitGC.setTextAlign(TextAlignment.CENTER);
			exitGC.fillText("EXIT", 200, 50);
		});
		
		exitCanvas.setOnMouseClicked(e -> {
			soundManagement.gun();
			ButtonType foo = new ButtonType("YES", ButtonBar.ButtonData.OK_DONE);
			ButtonType bar = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);
			Alert alert = new Alert(AlertType.CONFIRMATION,
			        "Are you sure you want to exit the game?", foo, bar);
			alert.setTitle("Exit");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.orElse(bar) == foo) {
				Platform.exit();
			}
		});
	}
	
}