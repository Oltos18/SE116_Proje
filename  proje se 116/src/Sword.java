import java.util.ArrayList;

public class Sword extends Weapon implements KeepAway {
    private double length;

    public Sword(){
    }

    public Sword(int tempPowerValue,double tempWeight, double tempValue, double tempLength){
        super(tempPowerValue,tempWeight,tempValue);
        length=tempLength;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public void keepAwayEnemies(ArrayList<Enemy> x){
        for(Enemy y:x){
            y.setCanAttack(false);
        }
    }
}
