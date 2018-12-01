package Character_Logic;

public class Boss extends Character implements Reicarnation {
	private int life;
	
	public Boss(String name,int damage, int defend, int maxhealth, int mana) {
		super(name,damage,defend,maxhealth,mana);
		this.life = 2;
	}
	
	@Override
	public boolean takeDamage(int damage) {
		// TODO Auto-generated method stub
		int totaldamage = damage - getDefend();
		if (totaldamage > getHealth()) {
			if(life!=0)
				this.reicarnate();
			else
				return super.takeDamage(damage);
		}
		else
			 return super.takeDamage(damage);
		return true;
	}
	
	@Override
	public void reicarnate() {
		// TODO Auto-generated method stub
		this.life--;
		this.setHealth(this.getMAXHEALTH());
		this.setDamage(getDamage()*2);
		this.setDefend(getDefend()*2);
		this.setMana(getMAXMANA());
	}
	
}
