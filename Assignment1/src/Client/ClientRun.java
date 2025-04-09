package Client;

import Customer.*;
import Magazine.*;
import Payment.Interface.PaymentMethod;
import Supplement.Supplement;

import java.util.ArrayList;

import Exception.*;

import static sun.text.normalizer.UTF16.append;

public class ClientRun {
    public static void run(String[] Args) throws InvalidInputDataException {
        ClientServiceConstructor client = new ClientServiceConstructor();

        ArrayList<PaymentMethod> paymentList = client.constructPaymentListPro();
        ArrayList<Customer> customerList = client.constructCustomerList(paymentList);
        ArrayList<Supplement> supplementList = client.constructSupplementListPro();

        client.addSupplementsToCustomer(supplementList, customerList);

        Magazine magazine = new Magazine();
        MagazineOperator mo = client.addCustomerToMagazine(magazine, customerList);

        client.printWeeklyEmailAccordingNumOfWeek(4, mo);
        client.printMonhtlyEmail(mo);

        magazineDroppingTets(mo, customerList, client);
        addingAndRemovingCustomerTest(mo, supplementList, paymentList, client);

    }

    public static void magazineDroppingTets(MagazineOperator mo, ArrayList<Customer> customerList, ClientServiceConstructor client){
        System.out.println("====================================================Magazine Dropping=========================================================");
        mo.removeCustomer(customerList.get(customerList.size() - 1));
        mo.removeCustomer(customerList.get(customerList.size() - 2));
        mo.removeCustomer(customerList.get(customerList.size() - 3));
        mo.removeCustomer(customerList.get(1));
        mo.removeCustomer(customerList.get(2));
        mo.removeCustomer(customerList.get(3));

        client.printWeeklyEmailAccordingNumOfWeek(4, mo);
        client.printMonhtlyEmail(mo);
    }

    public static void addingAndRemovingCustomerTest(MagazineOperator mo, ArrayList<Supplement> supplementList, ArrayList<PaymentMethod> paymentList, ClientServiceConstructor client) throws InvalidInputDataException {
        System.out.println("\n\n====================================================Add=========================================================");
        PayingCustomer newCus = client.newCustomerGenerator(mo, supplementList, paymentList, "Minh Khang Nguyen", "34739531@student.murdoch.edu.au");
        AssociateCustomer newAssCus1 = client.TestAddingAssociateCustomer(newCus, supplementList, mo, "Haha AAA", "haha@ict373.com", 1);
        AssociateCustomer newAssCus2 = client.TestAddingAssociateCustomer(newCus, supplementList, mo, "Hehe EEE", "hehe@ict373.com", 2);

        StringBuilder message = new StringBuilder();
        message.append("Emailing to ").append(newCus.getEmail());
        System.out.println(message.toString());
        System.out.println(newCus.weeklyEmailNotificationReceive());


        System.out.println(newCus.magazineMonthlyEmail());

        System.out.println("\n\n====================================================Remove=========================================================");
        System.out.printf("Removing %s\n",newAssCus2.getCustomerName());
        newCus.removeAssociateCustomer(newAssCus2);
        System.out.println(newCus.magazineMonthlyEmail());
    }
}