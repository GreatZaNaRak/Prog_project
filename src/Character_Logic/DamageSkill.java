package Character_Logic;

public class DamageSkill extends Skill {
	private int damage;
	
	public DamageSkill(String name,int consuming,int damage) {
		super(name,consuming);
		this.damage = damage;
	}

	@Override
	public void skillTo(Character target) {
		target.takeDamage(damage);
	}
	
}
