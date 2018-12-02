package combat;

import java.util.Map;

import characters.Entity;

public class Buff extends Skill {

	int buff;
	String stat;
	int duration;
	int turn_used;

	public Buff(String name, int buff, int duration, String stat, int cooldown_sec) {
		super(name, cooldown_sec, 1);
		this.buff = buff;
		this.stat = stat;
		this.duration = duration;
		super.type = "passive";

	}

	@Override
	public void useSkill(Map<String, Integer> attr) {
		attr.put(this.stat, attr.get(stat) + buff);

	}
}
