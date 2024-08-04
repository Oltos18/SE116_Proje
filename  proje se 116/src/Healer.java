public class Healer extends Character {

    private static boolean isHealerAlive=true;


    public static boolean isIsHealerAlive() {
        return isHealerAlive;
    }

    public static void setIsHealerAlive(boolean isHealerAlive) {
        Healer.isHealerAlive = isHealerAlive;
    }

    public Healer() {
        setName("Healer");
        AliveİnLevel++;
    }

    public Healer(int tempStrength, int tempIntel, int tempVital, Armor tempArmor, Wand tempWeapon) {
        super.setStrength(tempStrength);
        super.setIntelligence(tempIntel);
        super.setVitality(tempVital);
        double x=(0.7*tempVital)+(0.2*tempStrength)+(0.1*tempIntel);
        super.setHp((int) x);
        super.setName("Healer");
        super.setInitialArmor(tempArmor);
        super.setInitialWeapon(tempWeapon);
        AliveİnLevel++;
    }

    @Override
    public int Attack() throws ExceptionInInitializerError {
        return (super.getStrength() * super.getInitialWeapon().getPower());
    }

    // we need to make an interface class in order to implement the method heal >> as it is said in the file, the healer will heal other characters or himself

    @Override
    public void Pick(Item tempItem) {
        if (Boolean_getis_Alive()) {
            if (super.CalculateWeightOfInventory() < ((2 * getStrength()) + tempItem.getWeight())) {
                ınventory.add(tempItem); //according to special action method , healer uses a WAND along his INTELLIGENCE in order to heal
            }
        } else {
            System.out.println("This character is dead");
        }
    }

    @Override
    public void Wear(Armor tempArmor) {
        if (Boolean_getis_Alive()) {
            if (super.getInitialArmor() == null) {
                super.setInitialArmor(tempArmor);
            }
            if (super.getInitialArmor() != null) {
                if (getStrength() < (CalculateWeightOfInventory() + super.getInitialArmor().getWeight())) {
                    System.out.println("You can't change your armor because your inventory is very heavy");
                } else if (getStrength() >= (CalculateWeightOfInventory() + super.getInitialArmor().getWeight())) {
                    ınventory.add(super.getInitialArmor());
                    super.setInitialArmor(tempArmor);
                }

            }
        } else {
            System.out.println("This character is dead");
        }

    }
    @Override
    public void Wield(Weapon tempWeapon) {
        if (Boolean_getis_Alive()) {
            if (super.getInitialWeapon() == null) {
                super.setInitialWeapon(tempWeapon);
            }
            if (super.getInitialWeapon() != null) {
                if (getStrength() < (CalculateWeightOfInventory() + super.getInitialWeapon().getWeight())) {
                    System.out.println("You can't change your armor because your inventory is very heavy");
                } else if (getStrength() >= (CalculateWeightOfInventory() + super.getInitialWeapon().getWeight())) {
                    ınventory.add(super.getInitialWeapon()); // ( Healer can wear small armor? )
                    super.setInitialWeapon(tempWeapon);
                }
            }
        } else {
            System.out.println("This character is dead");
        }
    }

    @Override
    public void Examine(Item x) {
        if (Boolean_getis_Alive()) {
            System.out.println("Name is: " + x.getName() + "   value is " + x.getValue() + "   weight is " + x.getWeight());
        } else {
            System.out.println("This character is dead");
        }
    }
}
