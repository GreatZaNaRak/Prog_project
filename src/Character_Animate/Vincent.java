package Character_Animate;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class Vincent extends VBox{
	Label name, talent, weak, ultimate;
	
	public Vincent() {
		// TODO Auto-generated constructor stub
		this.setAlignment(Pos.CENTER_LEFT);
		this.setStyle("-fx-font-size : 30");
		name = new Label("Name : Vincent");
		talent = new Label("Talent : He is good in Magical damage");
		weak = new Label("Weak ness : He is lack in Physical\ndamage");
		ultimate = new Label("Ultimate skill : Five Star Forms");
		
	}
	
	public void set() {
		this.getChildren().addAll(name, talent, weak, ultimate);
	}
	
	public void clear() {
		this.getChildren().removeAll(name, talent, weak, ultimate);
	}

}