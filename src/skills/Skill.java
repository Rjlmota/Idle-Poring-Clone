package skills;

import java.util.Map;

import combat.Fighter;
import properties.Entity;

/*
 * Skills will be an abstract form to help manage some skill types: Active, Passive, ?.
 * The concrete form of theses skills will be instantiated and put inside a list of Skills. There we'll be able
 * to control the level of the skill, cooldown, and any other effects that may come to play.
 * 
 * 
 */

public class Skill {

	private String name;
	double accuracy;
	private int cooldown;
	private int last_usage = -100;
	private String type;
	class Effect {
		String name;
		String description;
		String type;
		double chance;

	}

	void applyStatus(Effect effect, Entity enemy) {
		if (effect.name == "Stun") {
			double random = Math.random() * 1 + 0;
			if (random < effect.chance) {
				enemy.status = "Stunned";
			}
		}
	}

	String effect;
	String effectDescription;
	int skillLevel;

	public Skill(String name, int cooldown_sec, double accuracy) {
		this.name = name;
		this.cooldown = cooldown_sec;
		this.accuracy = accuracy;

	}

	public int useSkill(Fighter self, Fighter target) {
		return 0;
	}

	public void useSkill(Map<String, Integer> attr) {

	}
	
	public String getName(){
		return this.name;
	}

	public int getCooldown(){
		return this.cooldown;
	}

	public int getLastUsage(){
		return this.last_usage;
	}

	public void setLastUsage(int x){
		this.last_usage = x;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type = type;
	}
	
	
	public void reset() {
		this.last_usage = -999;
	}

}
