package scene;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class creditScene {
	
	private Button back;
	
	// >>>>>>>>>>>>>>> Credit Scene <<<<<<<<<<<<<<<<<<<<<
	public creditScene() {
		
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
			
			back = new Button("Back");
			back.setPrefWidth(70);
			back.setPrefHeight(40);
			
			forCreditScene.getChildren().addAll(cre, monde, great, back);
			// >>>>>>>>>>>>>>> Credit Scene <<<<<<<<<<<<<<<<<<<<<
	}

	public Button getBack() {
		return back;
	}
	
}
