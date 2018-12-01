package Character_Logic;

public abstract class Skill {
	private String name;
	private int consuming;
	
	public Skill(String name,int consuming) {
		this.name = name;
		this.consuming = consuming;
	}
	
	public abstract void skillTo(Character target);

	public String getName() {
		return name;
	}

	public int getConsuming() {
		return consuming;
	}
	
}
