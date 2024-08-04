public class Scimitar extends Sword{
    String name_x="Scimitar";

    public Scimitar(){
    }

    public Scimitar(int tempPowerValue,double tempWeight,double tempValue,double tempLength){
        super(tempPowerValue,tempWeight,tempValue,tempLength );
        super.setName(name_x);
    }
}
