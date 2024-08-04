public class WoodWand extends Wand {
    private String name_w="Wood Wand";

    public WoodWand(){
    }

    public WoodWand(int tempPowerValue,double tempWeight,double tempValue, int tempHealPower){
        super(tempPowerValue,tempWeight,tempValue,tempHealPower);
        super.setName(name_w);
    }
}
