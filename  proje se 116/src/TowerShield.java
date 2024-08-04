public class TowerShield extends Shield {
    private String name_ş="Tower Shield";

    public TowerShield(){
    }

    public TowerShield(int tempPowerValue,double tempWeight, double tempValue, double tempDefence){
        super(tempPowerValue,tempWeight,tempValue,tempDefence);
        super.setName(name_ş);
    }
}
