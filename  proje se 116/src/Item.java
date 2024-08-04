public class Item {
    private double weight;
    private double value;
    private String name;

    public void PrintInfo(){
        System.out.println("The name of the ıtem is " + name +"   " + "weight is " + weight + "   " + "value is " + value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Item(){
    }

    public Item(double tempWeight, double tempValue){
        setValue(tempWeight);
        setWeight(tempValue);
    }

    public Item(double tempWeight, double tempValue, String tempName){
        setName(tempName);
        setWeight(tempWeight);
        setValue(tempValue);
    }
}
