import java.util.ArrayList;

public class Weapon extends Item {
    private int power;

    public Weapon() {
    }

    public Weapon(int tempPowerValue, double tempWeight, double tempValue) {
        super(tempWeight, tempValue);
        power = tempPowerValue;
    }

    public int getPower() {
        return power;
    }

    public void keepAwayEnemies(ArrayList<Enemy> p) {
        {
            for (Enemy y : p) {
                y.setCanAttack(false);
            }
        }
    }

    public void heal(Healer y, Character x) throws ExceptionInInitializerError {
        if (x.Boolean_getis_Alive() == false) {
            System.out.println("This character is death");
        } else {
            x.setHp(x.getHp() + (y.getIntelligence() * y.getInitialWeapon().getPower()));
            if (x.getHp() < (0.7 * x.getVitality()) + (0.2 * x.getStrength()) + (0.1 * x.getIntelligence())) {
                System.out.println("Healer healed " + (y.getIntelligence() * y.getInitialWeapon().getPower()) + " of " + x.getClass().getName());
            }
            if (x.getHp() > (0.7 * x.getVitality()) + (0.2 * x.getStrength()) + (0.1 * x.getIntelligence())) {
                int overHp = x.getHp();
                x.setHp((int) ((0.7 * x.getVitality()) + (0.2 * x.getStrength()) + (0.1 * x.getIntelligence())));
                System.out.println("Healer healed " + ((y.getIntelligence() * y.getInitialWeapon().getPower()) - (overHp - x.getHp())) + " of " + x.getClass().getName());
            }


        }
    }

    public void stunEnemies(ArrayList<Enemy> x) {
        for (Character y : x) {
            y.setCanAttack(false);
        }
    }
}