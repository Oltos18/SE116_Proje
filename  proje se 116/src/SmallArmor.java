public class SmallArmor extends Armor {
    private String name= "Small Armor";

    public SmallArmor(){

    }

    public SmallArmor(double tempWeight, double tempValue,int protectionvalue ){
        super(tempWeight,tempValue,protectionvalue);
        super.setName(name);
    }
}
