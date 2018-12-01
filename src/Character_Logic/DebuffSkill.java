package Character_Logic;

public class DebuffSkill extends Skill{
	public String debuffType;
	public int total;
	
	public DebuffSkill(String name,int consuming,String debuffType,int total) {
		super(name, consuming);
		setDebuffType(debuffType);
		this.total = total;
	}
	
	public void setDebuffType(String type) {
		if(type=="attack" || type =="defense")
			this.debuffType = type;
		return;
	}

	@Override
	public void skillTo(Character target){
		if(debuffType == "attack") {
			target.setDamage(target.getDamage()*(100-total)/100);
		}
		if(debuffType == "defense") {
			target.setDefend(target.getDefend()*(100-total)/100);
		}
	}
	
}
