public class Armor extends Item {
    private int protection;

    public int getProtection() {
        return protection;
    }

    public Armor(){
    }

    public Armor(double tempWeight, double tempValue, int protectionvalue ){
        super(tempWeight,tempValue);
        protection= protectionvalue;
    }

}
