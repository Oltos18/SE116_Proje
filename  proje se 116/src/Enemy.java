public class Enemy extends Character { // had to write if s in methods for is alive s
    static int enemy_count = 0;

    private boolean canAttack=true;

    private Armor initialArmor;
    private Weapon initialWeapon;

    public Enemy(){
        setName("Enemy" + Integer.toString(enemy_count+1));
        enemy_count++;
    }

    public Enemy(int tempStrength, int tempIntel, int tempVital,Armor tempArmor,Weapon tempWeapon){
        super.setName("Enemy" + Integer.toString(enemy_count+1));
        super.setStrength(tempStrength);
        super.setIntelligence(tempIntel);
        super.setVitality(tempVital);
        double x=(0.7*tempVital)+(0.2*tempStrength)+(0.1*tempIntel);
        super.setHp((int) x);
        initialArmor= tempArmor;
        initialWeapon= tempWeapon;
        enemy_count++;

    }
    @Override
    public int Attack(){
        return (super.getStrength()*initialWeapon.getPower());
    }

    public static int getEnemy_count(){
        return enemy_count;
    }



    @Override
    public void Pick(Item tempItem){
        if(super.CalculateWeightOfInventory()<((2*getStrength())+tempItem.getWeight())) {
            ınventory.add(tempItem);
        }
    }

    @Override
    public void Wear(Armor tempArmor) {
        if (initialArmor == null) {
            initialArmor = tempArmor;
        }
        if (initialArmor != null) {
            if (getStrength() < (CalculateWeightOfInventory() + initialArmor.getWeight())) {
                System.out.println("You can't change your armor because your ınventory is very heavy");
                // here it is going to check the weight if that items weight can be added to the ınventory
            } else if (getStrength() >= (CalculateWeightOfInventory() + initialArmor.getWeight())) {
                ınventory.add(initialArmor);
                initialArmor = tempArmor;
            }

        }
    }

    public void Wield(Weapon tempWeapon){
        if (initialWeapon == null) {
            initialWeapon = tempWeapon;
        }
        if (initialWeapon != null) {
            if (getStrength() < (CalculateWeightOfInventory() + initialWeapon.getWeight())) {
                System.out.println("You can't change your armor because your ınventory is very heavy");
                // here it is going to check the weight if that items weight can be added to the ınventory
            } else if (getStrength() >= (CalculateWeightOfInventory() + initialWeapon.getWeight())) {
                ınventory.add(initialWeapon);
                initialWeapon = tempWeapon;
            }

        }
    }
    @Override
    public void Examine(Item x){
        System.out.println("Name is: " + x.getName() + "   value is " + x.getValue() +"   weight is " + x.getWeight());
    }

}
