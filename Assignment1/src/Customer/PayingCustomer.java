package Customer;

import java.util.ArrayList;

import Payment.Interface.PaymentMethod;
import Supplement.Supplement;

public class PayingCustomer extends Customer{
    private PaymentMethod paymentMethod;
    private ArrayList<AssociateCustomer> associateCustomers;

    public PayingCustomer(){
        super();
        this.paymentMethod = paymentMethod;
        this.associateCustomers = new ArrayList<>();
    }

    public PayingCustomer(String customerName, String email,
                          ArrayList<Supplement> supplementList, PaymentMethod paymentMethod,
                          ArrayList<AssociateCustomer> associateCustomers){
        super(customerName, email, supplementList);
        this.paymentMethod = paymentMethod;
        this.associateCustomers = new ArrayList<>();
    }

    public PayingCustomer(String customerName, String email,
                          PaymentMethod paymentMethod){
        super(customerName, email);
        this.paymentMethod = paymentMethod;
        this.associateCustomers = new ArrayList<>();
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<AssociateCustomer> getAssociateCustomers() {
        return associateCustomers;
    }

    public void setAssociateCustomers(ArrayList<AssociateCustomer> associateCustomers) {
        this.associateCustomers = associateCustomers;
    }

    public void addAssociateCustomer(AssociateCustomer assCus){

        associateCustomers.add(assCus);
    }

    public void removeAssociateCustomer(AssociateCustomer assCus){

        associateCustomers.remove(assCus);
    }

    public String magazineMonthlyEmail(){
        StringBuilder message = new StringBuilder();
        message.append("Hi ").append(this.getCustomerName()).append(",\n");
        message.append("This is your magazines billing this month.\n");
        message.append("The payment is made by" ).append(this.getPaymentMethod().paymentDetail()).append(".\n");

        int monthWeek = 4;
        double amount = calCost(monthWeek);// assume each month has 4 weeks
        message.append("Your own monthly cost of magazine subscription is: ");
        message.append("$").append(String.format("%.3f",(calWeeklyMagazineCost()))).append(" x ").append(monthWeek).append(" = ").append("$").append(String.format("%.3f",(amount))).append("\n");
        message.append("Your listing of item subscription along with cost is (weekly ---> monthly): \n");
        for(Supplement sup : supplementList){
            message.append("+ " ).append(sup.getItemName()).append(": $").append(sup.getWeeklyCost()).append(" ---> ");
            message.append("$").append(String.format("%.3f",(sup.getWeeklyCost()*monthWeek))).append("\n");
        }

        for(AssociateCustomer a : associateCustomers){
            double assCusCost = a.calWeeklyMagazineCost() * monthWeek;
            amount += assCusCost;
            message.append("\nYou pay for ").append(a.getCustomerName()).append(" for $");
            message.append(String.format("%.3f",(assCusCost))).append("\n");
            message.append("Their list of item subscription is: \n");
            for(Supplement sup : a.getSupplementList()){
                message.append("+ " ).append(sup.getItemName()).append(": $").append(sup.getWeeklyCost()).append(" ---> ").append("$").append(sup.getWeeklyCost()*4).append("\n");
            }
        }

        message.append("\nYour total billing is: ").append("$").append(String.format("%.3f",(amount)));
        return message.toString();
    }

    @Override
    public double calCost(int numberOfWeek) {
        double amount = calWeeklyMagazineCost() * numberOfWeek;

        return amount;
    }

    @Override
    public void magazineEmail() {
    }
}
