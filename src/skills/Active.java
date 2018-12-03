package skills;

import combat.Fighter;

public class Active extends Skill {

	int raw_damage;
	String damageType;

	public Active(String name, int damage, int cooldown_sec, double accuracy, String type) {
		super(name, cooldown_sec, accuracy);
		this.raw_damage = damage;
		this.damageType = type;

	}

	@Override
	public void useSkill(Fighter target) {
		int damage = raw_damage - target.stats.get("def");
		if(damage < 0) damage = 0;
		target.stats.replace("hp", target.stats.get("hp") - damage);
		System.out.println("delt " + damage + " damage");
	}
}
