package Character_Animate;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class ready extends VBox{
	Label esc, go;
	
	public ready() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER);
		this.setSpacing(30);
		this.setStyle("-fx-font-size : 30");
		esc = new Label("If you want to select other\nCharacter press ESC");
		go = new Label("Press Start to play the game!!!");
		
	}
	
	public void set() {
		this.getChildren().addAll( esc, go);
	}
	
	public void clear() {
		this.getChildren().removeAll( esc, go);
	}

}