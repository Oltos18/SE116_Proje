public class BucklerShield extends Shield {
    private String name_ş="Buckler Shield";

    public BucklerShield(){
    }

    public BucklerShield(int tempPowerValue,double tempWeight, double tempValue, double tempDefence){
        super(tempPowerValue,tempWeight,tempValue,tempDefence);
        super.setName(name_ş);
    }
}
