package Character_Logic;

public class Bat extends Character{
	
	public Bat(String name,int damage, int defend, int maxhealth, int mana) {
		super(name,damage,defend,maxhealth,mana);
	}
	
	@Override
	public boolean attack(Character target) {
		if(super.attack(target))
			this.getHeal(getDamage()*20/100);
		return false;
	}
}
