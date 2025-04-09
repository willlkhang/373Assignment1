package Supplement;

import Exception.*;

public class Supplement {
    private String supplementName;
    private double weeklyCost;

    public Supplement(){
        this.supplementName = "Unknown item";
        this.weeklyCost = 0.0;
    }

    public Supplement(String supplementName, double weeklyCost) throws InvalidInputDataException {
        setItemName(supplementName);
        setWeeklyCost(weeklyCost);
    }

    public String getSupplementName() {
        return supplementName;
    }

    public void setItemName(String name) throws InvalidInputDataException {
        if(name == null || !isValidSupplementName(name)){
            throw new InvalidInputDataException("Invalid Item name");
        }
        else
            this.supplementName = name;
    }

    public double getWeeklyCost() {
        return weeklyCost;
    }

    public void setWeeklyCost(double cost) throws InvalidInputDataException {
        if(!isValidPrice(cost)){
            throw new InvalidInputDataException("Invalid supplement price");
        }
        else
            this.weeklyCost = cost;
    }

    private boolean isValidSupplementName(String name) {
        return name.replaceAll(" ", "").matches("^[a-zA-Z]+$");
    }

    private boolean isValidPrice(double price){
        return (price > 0);
    }
}
