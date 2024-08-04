public class HardArmor extends Armor {
    private String name= "Hard Armor";

    public HardArmor(){

    }

    public HardArmor(int tempWeight, int tempValue,int protectionvalue ){
        super(tempWeight,tempValue,protectionvalue);
        super.setName(name);
    }

}
