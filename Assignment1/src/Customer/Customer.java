package Customer;

import Supplement.*;
import Magazine.*;
import java.util.ArrayList;

import Exception.*;

public abstract class Customer {
    protected String customerName;
    protected String email;
    protected ArrayList<Supplement> supplementList = new ArrayList<>();

    public Customer(){
        this.customerName = "No name";
        this.email = "No email";
        this.supplementList = new ArrayList<>();
    }


    public Customer(String customerName, String email) throws InvalidInputDataException {
        setCustomerName(customerName);
        setEmail(email);
    }

    public Customer(String customerName, String email, ArrayList<Supplement> supplementList){
        this.customerName = customerName;
        this.email = email;
        this.supplementList = new ArrayList<>();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidInputDataException {
        if(email == null || !isValidEmail(email)){
            throw new InvalidInputDataException("Invalid email");
        }
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) throws InvalidInputDataException {
        if(customerName == null || !isValidName(customerName))
            throw new InvalidInputDataException("Invalid Customer name");
        else
            this.customerName = customerName;
    }

    public ArrayList<Supplement> getSupplementList() {
        return supplementList;
    }

    public void setSupplementList(ArrayList<Supplement> supplementList) {
        this.supplementList = supplementList;
    }

    public void addSupplement(Supplement supplement){
        this.supplementList.add(supplement);
    }

    public void removeSupplement(Supplement supplement){
        this.supplementList.remove(supplement);
    }

    public double calWeeklyMagazineCost(){
        double total = Magazine.copyCost;
        for(Supplement sup : this.supplementList){
            total += sup.getWeeklyCost();
        }

        return total;
    }

    boolean isValidEmail(String email){
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    }

    boolean isValidName(String name){
        return name.replaceAll(" ", "").matches("^[a-zA-Z]+$");
    }

    //use the stringBuilder as stringBuilder doesn't create copy while implementing loop.
    //which cause unnecessary memory waste.
    public String weeklyEmailNotificationReceive(){
        StringBuilder message = new StringBuilder();
        message.append("Dear ").append(this.getCustomerName()).append(",\n");
        message.append("Your magazine for this week is ready to look at.\n");
        message.append("Your cost this week is: $").append(String.format("%.3f",(this.calWeeklyMagazineCost()))).append("\n");
        message.append("Here are the listing of supplements you have currently subscribed: \n");
        if(this.supplementList.isEmpty()){
            message.append("You have not subscribed for any items for the magazines.\n ");
        }
        else{
            int count = 1;
            for(Supplement sup : this.supplementList){
                message.append(count).append(". ").append(sup.getSupplementName()).append(".\n");
            }
        }
        return message.toString();
    }

    public abstract double calCost(int numberOfWeek);

    public abstract void magazineEmail();
}
