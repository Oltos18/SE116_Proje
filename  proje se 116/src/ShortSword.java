public class ShortSword extends Sword{
    String name_x="Short Sword";

    public ShortSword(){
    }

    public ShortSword(int tempPowerValue,double tempWeight, double tempValue, double tempLength){
        super(tempPowerValue,tempWeight,tempValue,tempLength );
        super.setName(name_x);
    }
}
