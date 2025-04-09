package Customer;

import Magazine.Magazine;
import Supplement.Supplement;

import Exception.*;

import java.util.ArrayList;

public class AssociateCustomer extends Customer{
    private PayingCustomer sponsor;

    public AssociateCustomer(){
        super();
    }

    public AssociateCustomer(String name, String email, PayingCustomer sponsor) throws InvalidInputDataException {
        super(name, email);
        this.sponsor = sponsor;
        sponsor.addAssociateCustomer(this); // the associate only exist when paying customer exist
        // composition relationship.
    }

    public AssociateCustomer(String name, String email,
                             ArrayList<Supplement> list, PayingCustomer sponsor){
        super(name, email, list);
        this.sponsor = sponsor;
        sponsor.addAssociateCustomer(this); // the associate only exist when paying customer exist
                                                    // composition relationship.
    }

    public PayingCustomer getSponsor() {
        return sponsor;
    }

    public void setSponsor(PayingCustomer sponsor) {
        this.sponsor = sponsor;
    }

    @Override
    public double calCost(int numberOfWeek) {
        return 0;
    }

    @Override
    public void magazineEmail() {

    }
}
