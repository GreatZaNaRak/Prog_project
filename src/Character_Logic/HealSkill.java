package Character_Logic;

public class HealSkill extends Skill{
	private int heal;
	
	public HealSkill(String name,int consuming,int heal) {
		super(name,consuming);
		this.heal = heal;
	}
	
	@Override
	public void skillTo(Character target) {
		// TODO Auto-generated method stub
		if(target.isAlive()==true)
			target.getHeal(heal);
	}
	
}
