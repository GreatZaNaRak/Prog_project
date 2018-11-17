package Character_Animate;

import javafx.geometry.Pos;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Cloud extends VBox{
	Label name, talent, weak, ultimate;
	
	public Cloud() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_LEFT);
		this.setStyle("-fx-font-size : 30");
		name = new Label("Name : Cloud");
		talent = new Label("Talent : He is good in Physical damage");
		weak = new Label("Weak ness : He is lack in Magical\ndamage");
		ultimate = new Label("Ultimate skill : Moon Blade Slash");
		
	}
	
	public void set() {
		this.getChildren().addAll(name, talent, weak, ultimate);
	}
	
	public void clear() {
		this.getChildren().removeAll(name, talent, weak, ultimate);
	}

}
