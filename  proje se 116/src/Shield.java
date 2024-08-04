import java.util.ArrayList;

public class Shield extends Weapon implements Stun {
    private double defence;

    public Shield(){
    }

    public Shield(int tempPowerValue,double tempWeight, double tempValue, double tempDefence){
        super(tempPowerValue,tempWeight,tempValue);
        defence=tempDefence;
    }

    @Override
    public void stunEnemies(ArrayList<Enemy>x){
        for(Character y:x){
            y.setCanAttack(false);
        }
    }

}
