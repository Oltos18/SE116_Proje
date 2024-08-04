public class MediumArmor extends Armor{
    private String name= "Medium Armor";

    public MediumArmor(){

    }

    public MediumArmor(double tempWeight, double tempValue,int protectionvalue ){
        super(tempWeight,tempValue,protectionvalue);
        super.setName(name);
    }
}
