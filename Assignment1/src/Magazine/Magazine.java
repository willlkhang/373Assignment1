package Magazine;

import Customer.*;

import java.util.*;

public class Magazine {

    public static final double copyCost = 5.0;
    private ArrayList<Customer> customers;

    public Magazine(){
        this.customers = new ArrayList<Customer>(); // suppose a magazine has default price of 5 bucks
    }

    public Magazine(ArrayList<Customer> customers){
        this.customers = customers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
}
