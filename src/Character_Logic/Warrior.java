package Character_Logic;

public class Warrior extends Hero {
	
	private int physicalAttack;
	
	// Constructor for warrior
	
	public Warrior() {
		
		this.setHealth(200);
		this.setMagic(20);
		this.setPhysicalDefensePoint(150);
		this.setPhysicalAttack(60);
		this.setMagicalDefensePoint(75);
		
	}
	
	// Override Method from Hero
	
	@Override
	public void specialSkill(Enermy target) {
		// do some animation
		target.takeMagicalDamage(physicalAttack*2);
	}
	
	@Override
	public void takeSpecialSkill() {
		
	}
	
	// Method for warrior
	
	public void attack(Enermy target) {
		target.takePhysicalDamage(this.physicalAttack);
	}
	
	
	// getter and setter for warrior
	
	public int getPhysicalAttack() {
		return this.physicalAttack;
	}
	
	public void setPhysicalAttack(int attack) {
		this.physicalAttack = attack;
	}
	
	
}
