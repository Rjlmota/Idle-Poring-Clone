package items;

import java.util.Random;

public class EquipmentFactory {

    private static final String[] index = {"Sword", "Bow", "Staff", "Helmet", "BodyArmor", "LegArmor", "Gloves", "Boots", "Necklace", "Ring"};

    public static Equipment getRandomEquipment(int level){

        Random rnd = new Random();
        int choice = rnd.nextInt(10);
        return getEquipmentByType(index[choice], level);
    }
    
    public static Equipment getEquipmentByType(String type, int level){

        if (type.equalsIgnoreCase("Sword")){
            int[] attr = {3*level, 0, 0, 1*level, 0, 0};
            return new Equipment("Sword", "Sword", attr);
        }

        else if (type.equalsIgnoreCase("Bow")){
            int[] attr = {0, 1*level, 0, 3*level, 0, 0};
            return new Equipment("Bow", "Bow", attr);
        }

        else if (type.equalsIgnoreCase("Staff")){
            int[] attr = {1*level, 0, 0, 0, 3*level, 0};
            return new Equipment("Rod", "Rod", attr);
        }

        else if (type.equalsIgnoreCase("Helmet")){
            int[] attr = {0, 0, 2*level, 0, 2*level, 0};
            return new Equipment("Helmet", "Helmet", attr);
        }

        else if (type.equalsIgnoreCase("BodyArmor")){
            int[] attr = {2*level, 0, 2*level, 0, 0, 0};
            return new Equipment("BodyArmor", "BodyArmor", attr);
        }

        else if (type.equalsIgnoreCase("LegArmor")){
            int[] attr = {0, 0, 2*level, 0, 0, 2*level};
            return new Equipment("LegArmor", "LegArmor", attr);
        }

        else if (type.equalsIgnoreCase("Gloves")){
            int[] attr = {2*level, 0, 0, 2*level, 0, 0};
            return new Equipment("Gloves", "Gloves", attr);
        }

        else if (type.equalsIgnoreCase("Boots")){
            int[] attr = {0, 2*level, 0, 2*level, 0, 0};
            return new Equipment("Boots", "Boots", attr);
        }

        else if (type.equalsIgnoreCase("Necklace")){
            int[] attr = {0, 0, 0, 0, 2*level, 2*level};
            return new Equipment("Necklace", "Necklace", attr);
        }

        else if (type.equalsIgnoreCase("Ring")){
            int[] attr = {0, 2*level, 0, 0, 2*level, 0};
            return new Equipment("Ring", "Ring", attr);
        }
        
        else{
            return null;
        }

    }

}
