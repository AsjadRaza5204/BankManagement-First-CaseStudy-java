package com.case_Study_1;

import java.util.Scanner;

import com.case_Study_1.Bank_Management;
import com.case_Study_1.Transection;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            choice = giveMenu();

            switch(choice) {
                case 1 :
                {
                    Bank_Management.createAccount();
                    break;
                }

                case 2 : {
                    Bank_Management.closeAccount();
                    break;
                }

                case 3 : {
                    Bank_Management.withdraw();
                    break;
                }

                case 4 : {
                    Bank_Management.deposit();
                    break;
                }

                case 5 : {
                    Bank_Management.checkBalance();
                    break;
                }

                case 6 : {
                    System.out.println("ONLY ADMINS ARE ALLOWED TO USE THIS. SO FIRST LET US VERIFY YOU");
                    String uname, password;
                    System.out.println("ENTER USERNAME");
                    uname = sc.next();

                    System.out.println("ENTER PASSWORD");
                    password = sc.next();

                    if(uname.equals(Transection.getUsername()) && password.equals(Transection.getPassword())) {
                        Bank_Management.generateTransactionReport();
                    }
                    else if(!uname.equals(Transection.getUsername()) && password.equals(Transection.getPassword())){
                        System.out.println("INCORRECT USERNAME");

                    }
                    else if(uname.equals(Transection.getUsername()) && !password.equals(Transection.getPassword())) {
                        System.out.println("INCORRECT PASSWORD");
                    }
                    else {
                        System.out.println("BOTH USERNAME AND PASSWORD ARE INVALID");
                    }
                    break;
                }

                case 7:{
                    Bank_Management.calculateInterestRate();
                    break;
                }

                case 8 : {
                    System.out.println("THANK YOU !!! TO VISIT OUR BANK.");
                    break;
                }

                default : {
                    System.out.println("INVALID CHOICE!!");
                    break;
                }
            }
        }while(choice != 0);
    }

    public static int giveMenu() {
        System.out.println("+===================================================================+");
        System.out.println("|               +++++  WELCOME TO UOR SBI BANK    +++++             |");
        System.out.println("+===================================================================+");
        System.out.println("|                        1. Create Account                          |");
        System.out.println("|                        2. Close Account                           |");
        System.out.println("|                        3. Withdraw Money                          |");
        System.out.println("|                        4. Deposit Money                           |");
        System.out.println("|                        5. Check Balance                           |");
        System.out.println("|                        6. Show Transaction Report                 |");
        System.out.println("|                        7. Calculate Interest                      |");
        System.out.println("|                        8. Exit                                    |");
        System.out.println("+===================================================================+");

        System.out.println("Enter Your Choice :");

        return sc.nextInt();

    }
}
