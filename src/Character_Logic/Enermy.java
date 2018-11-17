package Character_Logic;

public abstract class Enermy {
	
	private int health;
	private int physicalDefensePoint, magicalDefensePoint;
	private boolean isDead = false, isInturn;
	
	// abstract method is their skill
	
	public abstract void specialSkill();
	public abstract void updateStatus();
	
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

	
	// Getter and Setter Method
	
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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
