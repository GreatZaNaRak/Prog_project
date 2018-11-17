package Character_Animate;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Tifa extends VBox{
	Label name, talent, weak, ultimate;
	
	public Tifa() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_LEFT);
		this.setStyle("-fx-font-size : 30");
		name = new Label("Name : Tifa");
		talent = new Label("Talent : She can heal and good at\nMegical damage");
		weak = new Label("Weak ness : She is low in Defense");
		ultimate = new Label("Ultimate skill : Revive");
		
	}
	
	public void set() {
		this.getChildren().addAll(name, talent, weak, ultimate);
	}
	
	public void clear() {
		this.getChildren().removeAll(name, talent, weak, ultimate);
	}

}