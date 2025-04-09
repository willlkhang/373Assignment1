package Client;

import Customer.*;
import Magazine.*;
import Payment.Implement.CreditCard;
import Payment.Implement.DebitCard;
import Payment.Interface.PaymentMethod;
import Supplement.Supplement;

import java.util.ArrayList;
import java.util.Collections;

import Exception.*;

public class ClientServiceConstructor {
    private ArrayList<Customer> customerList;
    private ArrayList<Supplement> supplementList;
    private ArrayList<PaymentMethod> paymentList;
    private Magazine magazine;
    private MagazineOperator MO;


    public ClientServiceConstructor(){
        this.customerList = new ArrayList<>();
        this.supplementList = new ArrayList<>();
        this.paymentList = new ArrayList<>();
        this.magazine = new Magazine();
        this.MO = new MagazineOperator();
    }

    public ClientServiceConstructor(ArrayList<Customer> customerList, ArrayList<Supplement> supplementList, ArrayList<PaymentMethod> paymentList, Magazine magazine){
        this.customerList = customerList;
        this.supplementList = supplementList;
        this.paymentList = paymentList;
        this.magazine = magazine;
    }

    public String[] paymentDataArray = {   "C,1234 5678 9123 4567 0001,05/26,123",
                                            "C,1234 5678 9123 4567 0002,06/27,124",
                                            "C,1234 5678 9123 4567 0003,07/28,135",
                                            "D,1111 2222 3333 1111,01/26,321",
                                            "D,1111 2222 3333 2222,02/27,322",
                                            "D,1111 2222 3333 3333,04/28,323"};

    public String[] customerDataArray = {  "aaa AAA,aaa@ict373.com",
                                    "bbb BBB,bbb@ict373.com",
                                    "ccc CCC,ccc@ict373.com",
                                    "ddd DDD,ddd@ict373.com",
                                    "eee EEE,eee@ict373.com",
                                    "jjj JJJ,jjj@ict373.com",
                                    "mmm MMM,mmm@ict373.com",
                                    "ooo OOO,ooo@ict373.com",
                                    "ppp PPP,ppp@ict373.com",
                                    "qqq QQQ,qqq@ict373.com",
                                    "rrr RRR,rrr@ict373.com",
                                    "sss SSS,sss@ict373.com",
                                    "ttt TTT,ttt@ict373.com"};

    public String[] supplementDataArray = {"Soft Drink,2.99",
                                    "Tech,3.99",
                                    "Health and Wellness,4.99",
                                    "Travel Explorer,5.99",
                                    "Gourmet Food,6.99",
                                    "Fitness Pro,7.99",
                                    "Finance Weekly,8.99",
                                    "Gaming Zone,9.99",
                                    "Education,10.99",
                                    "Fashion,11.99"};

    public ArrayList<PaymentMethod> constructPaymentListPro() throws InvalidInputDataException {
        ArrayList<PaymentMethod> PaymentList = new ArrayList<>();
        int index = 0;
        for(String data : paymentDataArray) {
            String[] tmp = data.split(",");
            try {
                int cardCcv = Integer.parseInt(tmp[3]);
                if(tmp[0].equals("D")){
                    DebitCard dc = new DebitCard(tmp[1], tmp[2], cardCcv);
                    PaymentList.add(dc);
                }
                else if(tmp[0].equals("C")){
                    CreditCard cc = new CreditCard(tmp[1], tmp[2], cardCcv);
                    PaymentList.add(cc);
                }
                else{
                    System.err.println("Unknown Card type in card date at line " + index + " --> IGNORED");
                }
            } catch (InvalidInputDataException e) {
                System.err.println("Error processing data in payment method information at " + index + ": " + e.getMessage() + " --> IGNORED");
            }
            ++index;
        }

        return PaymentList;
    }

    public ArrayList<Supplement> constructSupplementListPro() throws InvalidInputDataException{
        ArrayList<Supplement> supplementList = new ArrayList<>();
        int index = 0;
        for(String data : supplementDataArray){
            try{
                String[] tmp = data.split(",");
                double price = Double.parseDouble(tmp[1]);
                Supplement sup = new Supplement(tmp[0], price);
                supplementList.add(sup);
            } catch (InvalidInputDataException e) {
                System.err.println("Error processing data in supplement information at " + index + ": " + e.getMessage() + " --> IGNORED");
            }
            ++index;
        }

        return supplementList;
    }

//    public ArrayList<PaymentMethod> constructPaymentList(){
//        ArrayList<PaymentMethod> paymentList = new ArrayList<>();
//        PaymentMethod credit1 = new CreditCard("1234 5678 9123 4567 0001", "05/09", 123);
//        PaymentMethod credit2 = new CreditCard("1234 5678 9123 4567 0002", "05/09", 124);
//        PaymentMethod credit3 = new CreditCard("1234 5678 9123 4567 0003", "05/09", 125);
//        paymentList.add(credit1);
//        paymentList.add(credit2);
//        paymentList.add(credit3);
//
//        PaymentMethod debit1 = new DebitCard("1111 2222 3333 1111", "01/02", 321);
//        PaymentMethod debit2 = new DebitCard("1111 2222 3333 2222", "01/02", 321);
//        PaymentMethod debit3 = new DebitCard("1111 2222 3333 3333", "01/02", 321);
//        paymentList.add(debit1);
//        paymentList.add(debit2);
//        paymentList.add(debit3);
//
//        return paymentList;
//    }

    public ArrayList<Customer> constructCustomerList(ArrayList<PaymentMethod> paymentList) throws InvalidInputDataException {
        ArrayList<Customer> customerList = new ArrayList<>();

        try {
            PayingCustomer payer1 = new PayingCustomer("aaa AAA", "aaa@ict373.com", paymentList.get(0));
            PayingCustomer payer2 = new PayingCustomer("bbb BBB", "bbb@ict373.com", paymentList.get(1));
            PayingCustomer payer3 = new PayingCustomer("ccc CCC", "ccc@ict373.com", paymentList.get(2));
            PayingCustomer payer4 = new PayingCustomer("ddd DDD", "ddd@ict373.com", paymentList.get(3));
            PayingCustomer payer5 = new PayingCustomer("eee EEE", "eee@ict373.com", paymentList.get(4));
            PayingCustomer payer6 = new PayingCustomer("jjj JJJ", "jjj@ict373.com", paymentList.get(5));

            customerList.add(payer1);
            customerList.add(payer2);
            customerList.add(payer3);
            customerList.add(payer4);
            customerList.add(payer5);
            customerList.add(payer6);

            AssociateCustomer associate1 = new AssociateCustomer("mmm MMM", "mmm@ict373.com", payer1);
            AssociateCustomer associate2 = new AssociateCustomer("nnn NNN", "nnn@ict373.com", payer1);
            AssociateCustomer associate3 = new AssociateCustomer("ooo OOO", "ooo@ict373.com", payer2);
            AssociateCustomer associate4 = new AssociateCustomer("ppp PPP", "ppp@ict373.com", payer2);
            AssociateCustomer associate5 = new AssociateCustomer("qqq QQQ", "qqq@ict373.com", payer3);
            AssociateCustomer associate6 = new AssociateCustomer("rrr RRR", "rrr@ict373.com", payer4);
            AssociateCustomer associate7 = new AssociateCustomer("sss SSS", "sss@ict373.com", payer5);
            AssociateCustomer associate8 = new AssociateCustomer("ttt TTT", "ttt@ict373.com", payer6);

            customerList.add(associate1);
            customerList.add(associate2);
            customerList.add(associate3);
            customerList.add(associate4);
            customerList.add(associate5);
            customerList.add(associate6);
            customerList.add(associate7);
            customerList.add(associate8);
        } catch (InvalidInputDataException e) {
            System.err.println("Error processing data  in customer information " + ": " + e.getMessage() + " --> IGNORED");
        }

        return customerList;
    }

//    public ArrayList<Supplement> constructSupplementList(){
//        ArrayList<Supplement> supplementList = new ArrayList<>();
//
//        Supplement softDrink = new Supplement("Soft Drink", 2.99);
//        Supplement fashion = new Supplement("Fashion", 3.99);
//        Supplement tech = new Supplement("Tech", 4.99);
//        Supplement health = new Supplement("Health & Wellness", 5.99);
//        Supplement travel = new Supplement("Travel Explorer", 6.99);
//        Supplement food = new Supplement("Gourmet Food", 7.99);
//        Supplement fitness = new Supplement("Fitness Pro", 8.99);
//        Supplement finance = new Supplement("Finance Weekly", 9.99);
//        Supplement gaming = new Supplement("Gaming Zone", 10.99);
//        Supplement education = new Supplement("Edu Digest", 11.99);
//
//        supplementList.add(softDrink);
//        supplementList.add(fashion);
//        supplementList.add(tech);
//        supplementList.add(health);
//        supplementList.add(travel);
//        supplementList.add(food);
//        supplementList.add(fitness);
//        supplementList.add(finance);
//        supplementList.add(gaming);
//        supplementList.add(education);
//
//        return supplementList;
//    }

    public void addSupplementsToCustomer(ArrayList<Supplement> supplementList, ArrayList<Customer> customerList){
        //add supplements to customer
        for(Customer c : customerList){

            ArrayList<Supplement> subSupplementList = new ArrayList<>(supplementList); // copy the original list
            Collections.shuffle(subSupplementList);

            if(c instanceof PayingCustomer){
                int suppleNum = 1 + (int)(Math.random() * 5);

                for(int i = 0; i < suppleNum; i++){
                    c.addSupplement(subSupplementList.get(i));
                }
            }
            else{
                int suppleNum = 2 + (int)(Math.random() * 8);

                for(int i = 0; i < suppleNum; i++){
                    c.addSupplement(subSupplementList.get(i));
                }
            }
        } //end adding supplement
    }

    public MagazineOperator addCustomerToMagazine(Magazine magazineS, ArrayList<Customer> customerList){
        MagazineOperator magazine = new MagazineOperator(magazineS);
        for(Customer c : customerList){
            magazine.addCustomer(c);
        }

        return magazine;
    }

    public void printWeeklyEmailAccordingNumOfWeek(int weekNum, MagazineOperator MO){
        System.out.printf("Weekly email for all customer for %d weeks: \n", weekNum);
        for(int i = 0; i < weekNum; i++){
            System.out.printf("================================================Week %d=========================================================\n", (i+1));
            MO.weekEmail();
        }
    }

    public void printMonhtlyEmail(MagazineOperator MO){
        System.out.println("\n\n\nMonthly email to all sponsor customer: ");
        MO.monthlyEmail();
    }

    public PayingCustomer newCustomerGenerator(MagazineOperator magazine, ArrayList<Supplement> supplementList, ArrayList<PaymentMethod> paymentList, String name, String email ) throws InvalidInputDataException {
        System.out.println("Adding new customer:");
        PayingCustomer newPayer = new PayingCustomer(name, email, paymentList.get(0));
        newPayer.addSupplement(supplementList.get(2));  // Health
        magazine.addCustomer(newPayer);
        System.out.println("Added new customer: " + newPayer.getCustomerName());

        return newPayer;
    }


    public AssociateCustomer TestAddingAssociateCustomer(PayingCustomer cus, ArrayList<Supplement> supplementList, MagazineOperator magazine, String name, String email, int assignItemCode) throws InvalidInputDataException {
        AssociateCustomer newAssociate = new AssociateCustomer(name, email, cus);
        if(assignItemCode == 1)
            for(int i = 0; i < supplementList.size(); i++){
                if(i % 2 == 0){
                    newAssociate.addSupplement(supplementList.get(i));
                }
            }
        else{
            for(int i = 0; i < supplementList.size(); i++){
                if(i % 2 == 1){
                    newAssociate.addSupplement(supplementList.get(i));
                }
            }
        }
        magazine.addCustomer(newAssociate);

        return newAssociate;
    }

    public void finalPrint(MagazineOperator magazine){
        System.out.println("================================================================================================================================");
        System.out.println("========================================Final weekly and monthly bills after changes============================================");
        System.out.println("================================================================================================================================\n");
        magazine.weekEmail();
        magazine.monthlyEmail();
    }
}
