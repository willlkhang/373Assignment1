package Magazine;

import Customer.*;

import java.util.ArrayList;

public class MagazineOperator {
    private Magazine magazine;
    private ArrayList<Customer> customerList;

    public MagazineOperator(){
        this.magazine = new Magazine();
        this. customerList = new ArrayList<>();
    }

    public MagazineOperator(Magazine magazine){
        this.magazine = magazine;
        this.customerList = new ArrayList<Customer>();
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addCustomer(Customer cus){
        this.customerList.add(cus);
    }

    public void removeCustomer(Customer cus){
        if(cus instanceof PayingCustomer){
            PayingCustomer pCus = (PayingCustomer)cus;

            for(AssociateCustomer assCus : pCus.getAssociateCustomers()){
                assCus.setSponsor(null);
                customerList.remove(assCus);
            }
        }
        else{
            AssociateCustomer assCus = (AssociateCustomer) cus;

            PayingCustomer pCus = assCus.getSponsor();

            if(pCus != null)
                pCus.removeAssociateCustomer(assCus);
        }

        customerList.remove(cus);
    }

    public void weekEmail(){
        for(Customer c : customerList){
            System.out.println("================================================Email=========================================================");
            System.out.println("Emailing to " + c.getEmail());
            System.out.println(c.weeklyEmailNotificationReceive() + "\n");
        }
    }

    public void monthlyEmail(){
        for(Customer c : customerList){
            if(c instanceof PayingCustomer){
                System.out.println("================================================Email========================================================");
                System.out.println("Emailing to " + c.getEmail());
                System.out.println(((PayingCustomer)c).magazineMonthlyEmail() + "\n");
            }
        }
    }
}
