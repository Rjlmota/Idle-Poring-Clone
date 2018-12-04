package skills;

import combat.Fighter;

public class Active extends Skill {

	int raw_damage;
	String damageType;

	public Active(String name, int damage, int cooldown_sec, double accuracy, String type) {
		super(name, cooldown_sec, accuracy);
		this.raw_damage = damage;
		this.damageType = type;
		this.setType("active");

	}

	@Override
	public int useSkill(Fighter self, Fighter target) {
		int damage = raw_damage - target.stats.get("def");
		if(damage < 0) damage = 0;

		return damage;
	}
}
