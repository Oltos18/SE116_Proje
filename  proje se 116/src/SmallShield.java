public class SmallShield extends Shield{
    private String name_ş="Small Shield";

    public SmallShield(){
    }

    public SmallShield(int tempPowerValue,double tempWeight, double tempValue, double tempDefence){
        super(tempPowerValue,tempWeight,tempValue,tempDefence);
        super.setName(name_ş);
    }
}
