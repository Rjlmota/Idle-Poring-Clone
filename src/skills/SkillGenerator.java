package skills;

public abstract class SkillGenerator {
	
	public static Active generateSkill(String classe, String name) {
		
		
		if(classe.equalsIgnoreCase("Wizard"))
				return WizardSkill.generate(name);
		
		
		
		if(classe.equalsIgnoreCase("Swordsman")) 
				return SwordsmanSkill.generate(name);

		if(classe.equalsIgnoreCase("Archer"))
				return ArcherSkill.generate(name);
		
		
		
	System.out.println("Invalid Input");
	return null;
	}
	
	
	public static Buff generateBuff(String classe, String name) {
		
		
		if(classe.equalsIgnoreCase("Wizard"))
				return WizardSkill.generateBuff(name);
		
		
		
		if(classe.equalsIgnoreCase("Swordsman")) 
				return SwordsmanSkill.generateBuff(name);

		if(classe.equalsIgnoreCase("Archer"))
				return ArcherSkill.generateBuff(name);
		
		
		
	System.out.println("Invalid Input");
	return null;
	}
}
