package scene;

import java.util.Optional;

import Draw.DrawMenuScene;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MenuScene {
	
	private Canvas canvas, playCanvas, creditCanvas, exitCanvas, enterCanvas;
	private GraphicsContext gc, playGC, creditGC, exitGC, enterGC;
	private DrawMenuScene draw;
	private StackPane centerPane;
	private VBox buttons, foreground;
	
	public MenuScene() {
		// >>>>>>>>>>>>>>> Menu Scene <<<<<<<<<<<<<<<<<<<<<
	
		centerPane = new StackPane();
		
		canvas = new Canvas();
		canvas.setWidth(900);
		canvas.setHeight(900);
		gc = canvas.getGraphicsContext2D();
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
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
		playGC.setFont(Font.font("Comic Sans MS", 35));
		playGC.fillText("PLAY", 200, 50);
		
		creditCanvas = new Canvas(400, 100);
		creditGC = creditCanvas.getGraphicsContext2D();
		creditGC.setFill(Color.BLACK);
		creditGC.setTextAlign(TextAlignment.CENTER);
		creditGC.setFont(Font.font("Comic Sans MS", 35));
		creditGC.fillText("CREDIT", 210, 50);
		
		exitCanvas = new Canvas(400, 100);
		exitGC = exitCanvas.getGraphicsContext2D();
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
		
		
		foreground = new VBox();
		foreground.setAlignment(Pos.CENTER);
		foreground.setSpacing(230);
		foreground.getChildren().add(gameTitle);
		foreground.getChildren().add(buttons);
		
		enterCanvas = new Canvas(760, 300);
		enterGC = enterCanvas.getGraphicsContext2D();
		draw.drawEnter(enterGC);
			
			
		centerPane.getChildren().add(canvas);
		centerPane.getChildren().add(foreground);
		centerPane.getChildren().add(enterCanvas);
		
		
			
		// >>>>>>>>>>>>>>> Menu Scene <<<<<<<<<<<<<<<<<<<<<
	}

	public VBox getButtons() {
		return buttons;
	}

	public VBox getForeground() {
		return foreground;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public Canvas getPlayCanvas() {
		return playCanvas;
	}

	public Canvas getCreditCanvas() {
		return creditCanvas;
	}

	public Canvas getExitCanvas() {
		return exitCanvas;
	}

	public DrawMenuScene getDraw() {
		return draw;
	}

	public StackPane getCenterPane() {
		return centerPane;
	}
	
	public Canvas getEnterCanvas() {
		return enterCanvas;
	}

	public GraphicsContext getGc() {
		return gc;
	}

	public GraphicsContext getPlayGC() {
		return playGC;
	}

	public GraphicsContext getCreditGC() {
		return creditGC;
	}

	public GraphicsContext getExitGC() {
		return exitGC;
	}

	public GraphicsContext getEnterGC() {
		return enterGC;
	}
	
}
/*
menuScene.getPlayCanvas().setOnMouseEntered(new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent me) {
		
		
		menuScene.getPlayGC().setLineWidth(4);
		menuScene.getPlayGC().setStroke(Color.ORANGE);
		menuScene.getPlayGC().setFill(Color.WHITE);
		menuScene.getPlayGC().setFont(Font.font("Comic Sans MS", 35));
		menuScene.getPlayGC().setTextAlign(TextAlignment.CENTER);
		menuScene.getPlayGC().fillText("PLAY", 200, 50);
		menuScene.getPlayGC().moveTo(98, 20);
		menuScene.getPlayGC().lineTo(98, 50);
		menuScene.getPlayGC().lineTo(133, 35);
		menuScene.getPlayGC().closePath();
		menuScene.getPlayGC().stroke();
		
	}
});

menuScene.getPlayCanvas().setOnMouseExited(new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent me) {
		menuScene.getPlayGC().setFill(Color.WHITE);
		menuScene.getPlayGC().clearRect(0, 0, 310, 80);
		menuScene.getPlayGC().setFill(Color.BLACK);
		menuScene.getPlayGC().setFont(Font.font("Comic Sans MS", 35));
		menuScene.getPlayGC().setTextAlign(TextAlignment.CENTER);
		menuScene.getPlayGC().fillText("PLAY", 200, 50);
		
	}
});

menuScene.getPlayCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent me) {
		sound.stopMusic();
		stage.setScene(playScene);
	}
});

menuScene.getCreditCanvas().setOnMouseEntered(new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent me) {
		menuScene.getCreditGC().setLineWidth(4);
		menuScene.getCreditGC().setStroke(Color.ORANGE);
		menuScene.getCreditGC().setFill(Color.WHITE);
		menuScene.getCreditGC().setFont(Font.font("Comic Sans MS", 35));
		menuScene.getCreditGC().setTextAlign(TextAlignment.CENTER);
		menuScene.getCreditGC().fillText("CREDIT", 210, 50);
		menuScene.getCreditGC().moveTo(90, 20);
		menuScene.getCreditGC().lineTo(90, 50);
		menuScene.getCreditGC().lineTo(125, 35);
		menuScene.getCreditGC().closePath();
		menuScene.getCreditGC().stroke();
		
	}
});

menuScene.getCreditCanvas().setOnMouseExited(new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent me) {
		menuScene.getCreditGC().setFill(Color.WHITE);
		menuScene.getCreditGC().clearRect(0, 0, 400, 80);
		menuScene.getCreditGC().setFill(Color.BLACK);
		menuScene.getCreditGC().setFont(Font.font("Comic Sans MS", 35));
		menuScene.getCreditGC().setTextAlign(TextAlignment.CENTER);
		menuScene.getCreditGC().fillText("CREDIT", 210, 50);
	}
});


menuScene.getExitCanvas().setOnMouseEntered(new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent me) {
		menuScene.getExitGC().setLineWidth(4);
		menuScene.getExitGC().setStroke(Color.ORANGE);
		menuScene.getExitGC().setFill(Color.WHITE);
		menuScene.getExitGC().setFont(Font.font("Comic Sans MS", 35));
		menuScene.getExitGC().setTextAlign(TextAlignment.CENTER);
		menuScene.getExitGC().fillText("EXIT", 200, 50);
		menuScene.getExitGC().moveTo(100, 20);
		menuScene.getExitGC().lineTo(100, 50);
		menuScene.getExitGC().lineTo(135, 35);
		menuScene.getExitGC().closePath();
		menuScene.getExitGC().stroke();
	}
});

menuScene.getExitCanvas().setOnMouseExited(new EventHandler<MouseEvent>() {
	@Override
	public void handle(MouseEvent me) {
		menuScene.getExitGC().setFill(Color.WHITE);
		menuScene.getExitGC().clearRect(0, 0, 400, 80);
		menuScene.getExitGC().setFill(Color.BLACK);
		menuScene.getExitGC().setFont(Font.font("Comic Sans MS", 35));
		menuScene.getExitGC().setTextAlign(TextAlignment.CENTER);
		menuScene.getExitGC().fillText("EXIT", 200, 50);
	}
});

menuScene.getExitCanvas().setOnMouseClicked(new EventHandler<MouseEvent>() {
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
}); */