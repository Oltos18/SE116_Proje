public class Warrior extends Character{

    private static boolean isWarriorAlive=true;

    public static boolean isIsWarriorAlive() {
        return isWarriorAlive;
    }

    public static void setIsWarriorAlive(boolean isWarriorAlive) {
        Warrior.isWarriorAlive = isWarriorAlive;
    }


    public Warrior(){
        setName("Warrior");
        AliveİnLevel++;
    }

    public Warrior(int tempStrength, int tempIntel, int tempVital,Armor tempArmor,Sword tempWeapon){
        super.setStrength(tempStrength);
        super.setIntelligence(tempIntel);
        super.setVitality(tempVital);
        double x=(0.7*tempVital)+(0.2*tempStrength)+(0.1*tempIntel);
        super.setHp((int) x);
        super.setName("Warrior");
        super.setInitialArmor(tempArmor);
        super.setInitialWeapon(tempWeapon);
        AliveİnLevel++;

    }

    @Override
    public int Attack() throws ExceptionInInitializerError{//we had to write a try catch for this because now it can still make attack while the character is dead
        return (super.getStrength()*super.getInitialWeapon().getPower());
    }

    @Override
    public void Pick(Item tempItem){
        if(Boolean_getis_Alive()) {
            if (super.CalculateWeightOfInventory() < ((2 * getStrength()) + tempItem.getWeight())) {
                ınventory.add(tempItem);
            }
        }
        else{
            System.out.println("This character is dead");
        }
    }

    @Override
    public void Wear(Armor tempArmor) {
        if(Boolean_getis_Alive()) {
            if (super.getInitialArmor() == null) {
                super.setInitialArmor(tempArmor);
            }
            if (super.getInitialArmor() != null) {
                if (getStrength() < (CalculateWeightOfInventory() + super.getInitialArmor().getWeight())) {
                    System.out.println("You can't change your armor because your ınventory is very heavy");
                    // here it is going to check the weight if that items weight can be added to the ınventory
                } else if (getStrength() >= (CalculateWeightOfInventory() + super.getInitialArmor().getWeight())) {
                    ınventory.add(super.getInitialArmor());
                    super.setInitialArmor(tempArmor);
                }

            }
        }

        else{
            System.out.println("This character is dead");
        }
    }

    public void Wield(Weapon tempWeapon){
        if(Boolean_getis_Alive()) {
            if (super.getInitialWeapon() == null) {
                super.setInitialWeapon(tempWeapon);
            }
            if (super.getInitialWeapon() != null) {
                if (getStrength() < (CalculateWeightOfInventory() + super.getInitialWeapon().getWeight())) {
                    System.out.println("You can't change your armor because your ınventory is very heavy");
                    // here it is going to check the weight if that items weight can be added to the ınventory
                } else if (getStrength() >= (CalculateWeightOfInventory() + super.getInitialWeapon().getWeight())) {
                    ınventory.add(super.getInitialWeapon());
                    super.setInitialWeapon(tempWeapon);
                }
            }
        }
        else{
            System.out.println("This character is dead");
        }
    }

    @Override
    public void Examine(Item x){
        if(Boolean_getis_Alive()) {
            System.out.println("Name is: " + x.getName() + "   value is " + x.getValue() +"   weight is " + x.getWeight());
        }
        else{
            System.out.println("This character is dead");
        }
    }

}