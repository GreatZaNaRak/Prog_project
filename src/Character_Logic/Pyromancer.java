package Character_Logic;

public class Pyromancer extends Character{
	
	public Pyromancer(String name,int damage, int defend, int maxhealth, int mana) {
		super(name,damage,defend,maxhealth,mana);
	}
	
	@Override
	public boolean attack(Character target) {
		// TODO Auto-generated method stub
		int attacktime = (int) (Math.random() * 3) + 1;
		for(int i=0;i<attacktime;i++) {		
			if(!super.attack(target))
				return false;
			else
				super.attack(target);
		}
		return true;
	}
}
