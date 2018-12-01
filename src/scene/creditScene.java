package scene;


import SceneManage.SceneManagement;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sound.soundManagement;



public class CreditScene extends VBox{

	private Button back;

	public CreditScene() {
		
		this.setSpacing(100);
		this.setStyle("-fx-background-color : black");
		this.setAlignment(Pos.CENTER);
		
		
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
		this.setButtonAction();
		this.getChildren().addAll(cre, monde, great, back);
		
		
		// >>>>>>>>>>>>>>> Credit Scene <<<<<<<<<<<<<<<<<<<<<
		
	}

	private void setButtonAction() {
		this.back.setOnAction(e -> {
			SceneManagement.switchScene(SceneManagement.menuScene);
			soundManagement.music();
		});
	}
	
	
}
