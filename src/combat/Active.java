package combat;

import characters.Entity;

public class Active extends Skill{
	
	int raw_damage;
	String damageType;
	
	public Active(String name, int damage,int cooldown_sec, double accuracy,  String type){
		super(name, cooldown_sec, accuracy);
		this.raw_damage = damage;
		this.damageType = type;
		
		
	}
	@Override
	public int useSkill(Entity target) {
		//Use more complex damage calculation
		//this.last_usage = System.currentTimeMillis()/1000;
		
		int delt_damage = raw_damage - target.stats.getStats().get("def");
		System.out.println("DAMAGE: " + delt_damage);
		if(delt_damage > 0) 
			return delt_damage;
		else 
			return 0;
		
		
	}

}
