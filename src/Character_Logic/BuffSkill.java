package Character_Logic;

public class BuffSkill extends Skill {
	public String buffType;
	public int total;
	
	public BuffSkill(String name,int consuming,String buffType,int total) {
		super(name, consuming);
		setBuffType(buffType);
		this.total = total;
	}
	
	public void setBuffType(String buffType) {
		if(buffType=="attack" || buffType =="defense")
			this.buffType = buffType;
	}

	@Override
	public void skillTo(Character target) {
		if(buffType == "attack") {
			target.setDamage(target.getDamage()*(total+100)/100);
		}
		if(buffType == "defense") {
			target.setDefend(target.getDefend()*(total+100)/100);
		}
	}
	
}
