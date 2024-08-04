public class LongSword extends Sword {
    String name_x="Long Sword";

    public LongSword(){
    }

    public LongSword(int tempPowerValue,double tempWeight, double tempValue, double tempLength){
        super(tempPowerValue,tempWeight,tempValue,tempLength );
        super.setName(name_x);
    }
}
