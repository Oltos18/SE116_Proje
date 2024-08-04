import java.util.ArrayList;

public abstract class Character {

    private String name;
    private int strength;
    private int vitality;
    private int intelligence;
    private boolean is_Alive=true;
    private boolean canAttack=true;
    private boolean isTaunt=true;
    public static int AliveİnLevel;

    private Armor initialArmor;
    private Weapon initialWeapon;


    public Armor getInitialArmor() {
        return initialArmor;
    }

    public Weapon getInitialWeapon() {
        return initialWeapon;
    }

    public void setInitialArmor(Armor initialArmor) {
        this.initialArmor = initialArmor;
    }

    public void setInitialWeapon(Weapon initialWeapon) {
        this.initialWeapon = initialWeapon;
    }

    private int hp;
    ArrayList<Item>ınventory;
    private int InventoryWeight;

    public abstract int Attack();
    public abstract void Pick(Item x);
    public abstract void Wear(Armor x);
    public abstract void Wield(Weapon x);
    public abstract void Examine(Item x);
    public void ShowInventory(){
        for(Item x : ınventory){
            x.PrintInfo();
        }
    }

    public int CalculateWeightOfInventory(){
        for(Item x: ınventory){
            InventoryWeight += x.getWeight();
        }
        /*We had to add the weight of weapon in his hand because if the player wants to change
        and ıtem in his hand with something heavier and the total weight become more
        than the weight he can carry it will be a problem */
        return InventoryWeight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public boolean Boolean_getis_Alive(){
        return is_Alive;
    }

    public String String_getis_Alive() {
        if(is_Alive) {
            return "alive";
        }
        else{
            return "not  alive";
        }
    }

    public void setAlive(boolean alive) {
        is_Alive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean getCanAttack() {
        return canAttack;
    }

    public void setCanAttack(boolean canAttack) {
        this.canAttack = canAttack;
    }

}
