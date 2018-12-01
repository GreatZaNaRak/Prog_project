package Character_Animate;

import javafx.scene.image.Image;

public class Character_Ani {

	private static Image char1, char2, char3, char4;
	private static Image charII1, charII2, charII3, charII4;
	private static Image charIII1, charIII2, charIII3, charIII4;
	private static Image enemy1, enemy2, enemy3, enemy4, boss;
	
	public Character_Ani() {
		// TODO Auto-generated constructor stub
		char1 = new Image(ClassLoader.getSystemResource("warrior_walking.gif").toString());
		char2 = new Image(ClassLoader.getSystemResource("warrior_walk_left.gif").toString());
		char3 = new Image(ClassLoader.getSystemResource("warrior_walk_down.gif").toString());
		char4 = new Image(ClassLoader.getSystemResource("warrior_walk_up.gif").toString());
		
		charII1 = new Image(ClassLoader.getSystemResource("priest_walk_right.gif").toString());
		charII2 = new Image(ClassLoader.getSystemResource("priest_walk_left.gif").toString());
		charII3 = new Image(ClassLoader.getSystemResource("priest_walk_down.gif").toString());
		charII4 = new Image(ClassLoader.getSystemResource("priest_walk_up.gif").toString());
		
		charIII1 = new Image(ClassLoader.getSystemResource("berserk_walk_right.gif").toString());
		charIII2 = new Image(ClassLoader.getSystemResource("berserk_walk_left.gif").toString());
		charIII3 = new Image(ClassLoader.getSystemResource("berserk_walk_down.gif").toString());
		charIII4 = new Image(ClassLoader.getSystemResource("berserk_walk_up.gif").toString());
		
		enemy1 = new Image(ClassLoader.getSystemResource("ogre.png").toString());
		enemy2 = new Image(ClassLoader.getSystemResource("pyro_idle.gif").toString());
		enemy3 = new Image(ClassLoader.getSystemResource("skeleton.png").toString());
		enemy4 = new Image(ClassLoader.getSystemResource("Warlock.png").toString());
		boss = new Image(ClassLoader.getSystemResource("boss.png").toString());
	}

	public static Image getEnemy1() {
		return enemy1;
	}

	public static Image getEnemy2() {
		return enemy2;
	}

	public static Image getEnemy3() {
		return enemy3;
	}

	public static Image getEnemy4() {
		return enemy4;
	}

	public static Image getBoss() {
		return boss;
	}

	public static Image getChar1() {
		return char1;
	}

	public static Image getChar2() {
		return char2;
	}

	public static Image getChar3() {
		return char3;
	}

	public static Image getChar4() {
		return char4;
	}

	public static Image getCharII1() {
		return charII1;
	}

	public static Image getCharII2() {
		return charII2;
	}

	public static Image getCharII3() {
		return charII3;
	}

	public static Image getCharII4() {
		return charII4;
	}

	public static Image getCharIII1() {
		return charIII1;
	}

	public static Image getCharIII2() {
		return charIII2;
	}

	public static Image getCharIII3() {
		return charIII3;
	}

	public static Image getCharIII4() {
		return charIII4;
	}
	
}
