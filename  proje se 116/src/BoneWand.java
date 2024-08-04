public class BoneWand extends Wand{
    private String name_w="Bone Wand";

    public BoneWand(){
    }

    public BoneWand(int tempPowerValue,double tempWeight, double tempValue, int tempHealPower){
        super(tempPowerValue,tempWeight,tempValue,tempHealPower);
        super.setName(name_w);
    }
}
