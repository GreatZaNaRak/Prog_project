package Character_Logic;

import java.util.ArrayList;

public class AllCharacter {
	
	private static ArrayList<Character> Characters = new ArrayList<>();
	private static ArrayList<Character> myHero = new ArrayList<>();

	public AllCharacter() {
		
		Character cloud = new Character("Cloud", 35, 15, 200, 100);
		cloud.addSkill("slash", 25, "damage", 30, "???");
		cloud.addSkill("warcry", 50, "Debuff", 30, "???");
		
		Character tifa = new Character("Tifa", 20, 7, 120, 200);
		tifa.addSkill("heal", 30, "heal", 30, "???");
		tifa.addSkill("fear", 50, "Debuff", 30, "???");
		
		Character vincent = new Character("Vincent", 30, 10, 150, 150);
		vincent.addSkill("tackle", 30, "damage", 50, "???");
		vincent.addSkill("resist", 50, "Debuff", 40, "???");
		
		myHero.add(cloud);
		myHero.add(tifa);
		myHero.add(vincent);
		
		Character ogre = new Character("ogre", 40, 20, 200, 100);
		Character pyro = new Character("pyro", 40, 20, 120, 200);
		Character skeleton = new Character("skeleton", 0, 10, 200, 0);
		Character warlock = new Character("warlock", 60, 10, 120, 250);
		Character boss = new Character("boss", 100, 50, 400, 400);
		
		Characters.add(cloud);
		Characters.add(tifa);
		Characters.add(vincent);
		Characters.add(ogre);
		Characters.add(pyro);
		Characters.add(skeleton);
		Characters.add(warlock);
		Characters.add(boss);
		
	}

	public static ArrayList<Character> getCharacters() {
		return Characters;
	}

	public static ArrayList<Character> getMyHero() {
		return myHero;
	}
}
