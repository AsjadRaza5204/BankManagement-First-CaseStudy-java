package com.case_Study_1;

import java.time.LocalDate;
import java.util.Scanner;

public class Bank_Management {

    static Account[] acc = new Account[300];
    static int index = -1;
    static int idx = 100;
    static Transection transactionArray[] = new Transection[500];
    static int tId = 0;
    static Scanner sc = new Scanner(System.in);

    public static void createAccount() {
        int type, flag = 0;
        String holder_Name;
        double balance;

        System.out.println();

        System.out.println("+===================================================================+");
        System.out.println("|                         Account Types                             |");
        System.out.println("|===================================================================+");
        System.out.println("|                        1. Savings Account                         |");
        System.out.println("|                        2. Salary Account                          |");
        System.out.println("|                        3. Current Account                         |");
        System.out.println("|                        4. Loan Account                            |");
        System.out.println(" +==================================================================+");
        System.out.println("\nSelect one of the choice you want to create the account: ");
        type = sc.nextInt();

        switch(type) {

            case 1 :
            {
                while(flag != 1) {
                    System.out.println("\nEnter your name :");
                    sc.nextLine();
                    holder_Name = sc.nextLine();

                    System.out.println("\nEnter the balance for creating account :");
                    System.out.println("Balance must be in Rps "+ SavingAccount.getMinBalance() + " minimum" );

                    balance = sc.nextDouble();

                    if(balance >= SavingAccount.getMinBalance()) {
                        SavingAccount s = new SavingAccount(idx, holder_Name, balance);
                        transactionArray[tId] = new Transection(++tId, idx++,"Savings Account Created", balance, balance);
                        acc[++index] = s;
                        System.out.println("CONGRATS!! Your account has been successfully created in our SBI Bank");
                        System.out.println("\n Your account number is" + (idx-1));
                        flag = 1;
                    }
                    else {
                        System.out.println("Your account number is : " + SavingAccount.getMinBalance());

                    }
                }
                break;
            }

            case 2 :
            {

                while(flag != 1) {
                    System.out.println("\nEnter your name :");
                    sc.nextLine();
                    holder_Name = sc.nextLine();

                    System.out.println("Enter the balance for creating account :");
                    balance = sc.nextDouble();

                    if(balance >= 10000) {
                        SalaryAccount s = new SalaryAccount(idx, holder_Name, balance, LocalDate.now(), "Active");
                        transactionArray[tId] = new Transection(++tId, idx++,"Salary Account Created", balance, balance);
                        acc[++index] = s;
                        System.out.println("CONGRATS!! Your account has been successfully created in our SBI Bank");
                        System.out.println("\n Your account number is : " + (idx-1));
                        flag = 1;
                    }
                    else {
                        System.out.println("YOUR AMOUNT IS LESS THAN " + SavingAccount.getMinBalance());
                    }
                }
                break;
            }

            case 3 :
            {
                System.out.println("\nEnter your name :");
                sc.nextLine();
                holder_Name = sc.nextLine();

                System.out.println("Enter the balance for creating account :");
                balance = sc.nextDouble();

                CurrentAccount c = new CurrentAccount(idx, holder_Name, balance, 50000, 0);
                transactionArray[tId] = new Transection(++tId, idx++,"Current Account Created", balance, balance);

                System.out.println("CONGRATS!! Your account has been successfully created in our SBI Bank");
                System.out.println("\n Your account number is : " + (idx-1));

                acc[++index] = c;
                break;
            }

            case 4 :
            {
                System.out.println("\nEnter your name:");
                sc.nextLine();
                holder_Name = sc.nextLine();

                System.out.println("Enter the amount to withdraw :");
                balance = sc.nextDouble();

                LoanAccount la = new LoanAccount(idx, holder_Name, 0-(balance + balance*LoanAccount.getInterestRate()), balance, 0);
                transactionArray[tId] = new Transection(++tId, idx++,"Loan Account Created", balance, 0-(balance + balance*LoanAccount.getInterestRate()));
                la.calculateInterestRate();

                System.out.println("CONGRATS!! Your account has been successfully created in our SBI Bank");
                System.out.println("\n Your account number is : " + (idx-1));

                acc[++index] = la;
                break;
            }

            default : {
                System.out.println("Invalid Choice.");
                break;
            }
        }
    }

    public static void closeAccount() {
        int accNo;
        System.out.println("Enter the account number :");
        accNo = sc.nextInt();

        int i;
        for(i=0; i<=index; i++) {
            if(accNo == acc[i].getAccNo()) {
                for(int j=i; j<=index-1; j++) {
                    acc[j] = acc[j+1];
                }
                break;
            }
        }
        if(i == index+1) {
            System.out.println("SORRY!! Account number is not found.");
        }
        else {
            System.out.println("Account has been successfully deleted.");
            index--;
        }
    }

    public static void withdraw() {
        int accNo, i;
        double amount = -1;
        System.out.println("Enter account number :");
        accNo = sc.nextInt();

        for(i=0; i<=index; i++) {
            if(acc[i].getAccNo() == accNo) {
                amount = acc[i].withdraw();
                break;
            }
        }

        if(i == index+1) {
            System.out.println("SORRY!! Account number not found.");
        }
        else if(amount > 0){
            transactionArray[tId] = new Transection(++tId, accNo, "WITHDRAW", amount, acc[i].getBalance());
        }
    }

    public static void deposit() {

        int accNo, i;
        double amount = 0;
        System.out.println("Enter account number :");
        accNo = sc.nextInt();

        for(i=0; i<=index; i++) {
            if(acc[i].getAccNo() == accNo) {
                amount = acc[i].deposit();
                break;
            }
        }

        if(i == index+1) {
            System.out.println("SORRY!! Account number not found.");
        }
        else{
            transactionArray[tId] = new Transection(++tId, accNo, "DEPOSIT", amount, acc[i].getBalance());
        }
    }

    public static void checkBalance() {
        int accNo, i;
        System.out.println("Enter account number :");
        accNo = sc.nextInt();

        for(i=0; i<=index; i++) {
            if(acc[i].getAccNo() == accNo) {
                acc[i].checkBalance();
                break;
            }
        }

        if(i == index+1) {
            System.out.println("SORRY!! Account number not found");
        }
    }

    public static void generateTransactionReport() {

        System.out.println("+==========================================================================================================+");
        System.out.println("|                                          DAILY TRANSACTION REPORT                                        |");
        System.out.println("+==========================================================================================================+");
        System.out.printf("|%10s %12s %27s %15s %17s", "TRANSACTION NO",   "ACCOUNT NO",  "TRANSACTION TYPE", "AMOUNT", "TOTAL BALANCE");
        System.out.println();
        System.out.println("|----------------------------------------------------------------------------------------------------------|");

        for(int i=0; i<tId; i++)
        {
            System.out.format("%9s %10s %35s %15s %17s", transactionArray[i].getTransactionNumber(),
                    transactionArray[i].getAccNo(), transactionArray[i].getTransactionType(), transactionArray[i].getAmount(),
                    transactionArray[i].getTotalBalance());
            System.out.println();
            System.out.println("|-------------------------------------------------------------------------------------------------------+");
        }

    }

    public static void calculateInterestRate() {
        {
            int accNo, i;
            System.out.println("Enter account number :");
            accNo = sc.nextInt();
            for(i=0; i<=index; i++) {
                if(acc[i].getAccNo() == accNo) {
                    acc[i].calculateInterestRate();
                    break;
                }
            }

            if(i == index+1) {
                System.out.println("SORRY!! Account number not found");
            }
        }

    }

}
