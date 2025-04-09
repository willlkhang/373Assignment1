package Supplement;

public class Supplement {
    private String itemName;
    private double weeklyCost;

    public Supplement(){
        this.itemName = "Unknown item";
        this.weeklyCost = 0.0;
    }

    public Supplement(String itemName, double weeklyCost){
        this.itemName = itemName;
        this.weeklyCost = weeklyCost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getWeeklyCost() {
        return weeklyCost;
    }

    public void setWeeklyCost(double weeklyCost) {
        this.weeklyCost = weeklyCost;
    }
}
