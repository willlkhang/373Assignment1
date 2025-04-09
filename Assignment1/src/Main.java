import Customer.AssociateCustomer;
import Customer.Customer;
import Customer.PayingCustomer;
import Magazine.*;
import Payment.Implement.CreditCard;
import Payment.Implement.DebitCard;
import Payment.Interface.PaymentMethod;
import Supplement.Supplement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

import Exception.*;

import Client.*;

public class Main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] Args) throws InvalidInputDataException {
        ClientRun Run = new ClientRun();

        Run.run(Args);
    }// end main
}   // end class

