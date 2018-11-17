package Character_Logic;

public abstract class Hero {
	
	private static final int MAXHEALTH = 300;
	private int health, magic;
	private int physicalDefensePoint, magicalDefensePoint;
	private boolean isDead = false, isInturn;
	
	
	// abstract Method
	
	public abstract void specialSkill(Enermy target);
	public abstract void takeSpecialSkill();
	
	
	// update method
	
	public void updateStatus() {
		if (this.health > MAXHEALTH) this.health = MAXHEALTH;
		if (this.health <= 0) {
			this.health = 0;
			setDead(true);
		}
	}
	
	
	// method
	
	
	
	public void takePhysicalDamage(int damage) {
		damage -= this.physicalDefensePoint;
		this.health -= damage;
		updateStatus();
	}
	
	public void takeMagicalDamage(int damage) {
		damage -= this.magicalDefensePoint;
		this.health -= damage;
		updateStatus();
	}
	
	public void getHeal(int healPoint) {
		if (healPoint >= 0) {
			this.health += healPoint;
		}
	}
	
	public void getRevive() {
		this.setDead(false);
		this.setHealth(50);
	}
	
	
	// Getter and Setter Method
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getMagic() {
		return magic;
	}
	
	public void setMagic(int magic) {
		this.magic = magic;
	}
	
	
	public int getPhysicalDefensePoint() {
		return physicalDefensePoint;
	}
	
	public void setPhysicalDefensePoint(int physicalDefensePoint) {
		this.physicalDefensePoint = physicalDefensePoint;
	}
	
	public int getMagicalDefensePoint() {
		return magicalDefensePoint;
	}
	
	public void setMagicalDefensePoint(int magicalDefensePoint) {
		this.magicalDefensePoint = magicalDefensePoint;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public boolean isInturn() {
		return isInturn;
	}
	
	public void setInturn(boolean isInturn) {
		this.isInturn = isInturn;
	}
}

	
			