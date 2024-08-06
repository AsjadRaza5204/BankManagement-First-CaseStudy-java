package com.case_Study_1;


import java.util.Scanner;

import com.case_Study_1.Account;

public class LoanAccount extends Account{

    double loanGiven;
    double loanPaid;
    static double interestRate;
    static Scanner sc = new Scanner(System.in);

    static {
        interestRate = 2.7;
    }

    public LoanAccount() {
        super();
    }

    public LoanAccount(int accNo, String holder_Name, double balance, double loanGiven, double loanPaid) {
        super(accNo, holder_Name, balance);
        this.loanGiven = loanGiven;
        this.loanPaid = loanPaid;
    }

    public double getLoanGiven() {
        return loanGiven;
    }

    public void setLoanGiven(double loanGiven) {
        this.loanGiven = loanGiven;
    }

    public double getLoanPaid() {
        return loanPaid;
    }

    public void setLoanPaid(double loanPaid) {
        this.loanPaid = loanPaid;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        LoanAccount.interestRate = interestRate;
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        LoanAccount.sc = sc;
    }

    @Override
    public double withdraw() {

        if(this.getBalance() == 0) {
            double amount;
            System.out.println("Enter the amount you want to withdrwa:");
            amount = sc.nextDouble();

            this.loanGiven = amount;
            this.setBalance(0-(amount + calculateInterestRate()));
            this.loanPaid = 0;
            System.out.println("Rps " + amount + " has been successfully witdrwa");
            return amount;
        }
        else {
            System.out.println("PREVIOUS LOAN HAS NOT BEEN YET REPAID");
            System.out.println("CAN'T WITHDRAW MONEY FROM BANK UNTIL ALL AMOUNT REPAID");
            return -1;
        }
    }

    @Override
    public double deposit() {

        double amount;
        System.out.println("Enter amount you want to deposit");
        amount = sc.nextDouble();

        if(this.getBalance() < 0) {
            if((this.getBalance() + amount) <= 0) {
                this.setBalance(this.getBalance() + amount);
                this.loanPaid += amount;
                System.out.println("RUPEE " + amount + "SUCCESSFULLY DEPOSITED!!");
                return amount;
            }
            else {
                System.out.println("NO NEED TO REPAY ALL AMOUNT");
                double depAmt = amount - (amount + this.getBalance());
                System.out.println("YOU NEED TO PAY ONLY RUPEE " + depAmt);
                System.out.println("RUPEE " + depAmt + "SUCCESSFULLY DEPOSITED!!");
                this.setBalance(0);
                return depAmt;
            }
        }
        else {
            System.out.println("YOU HAVE REPAID ALL YOUR LOAN AMOUNT");
            return 0;
        }
    }

    @Override
    public void checkBalance() {

        if(this.getBalance() < 0) {
            System.out.println("RUPEE " + (this.loanGiven - this.loanPaid) + "NEED TO BE REPAID");
        }
        else {
            System.out.println("Repaid all loan amount.");
        }
    }

    @Override
    public double calculateInterestRate() {
        double amount = 0 - (this.getBalance() + (this.getBalance()*interestRate));
        return amount;
    }

}
