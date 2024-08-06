package com.case_Study_1;

import java.util.Scanner;

public class CurrentAccount extends Account{

    double overDraftLimit;
    double overDraftAmount;
    static double interestRate;
    static Scanner sc = new Scanner(System.in);

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(int accNo, String accHolderName, double balance, double overDraftLimit, double overDraftAmount) {
        super(accNo, accHolderName, balance);
        this.overDraftLimit = overDraftLimit;
        this.overDraftAmount = overDraftAmount;
    }


    @Override
    public double withdraw() {

        double amount;
        System.out.println("Enter the Amount you Want to Withdraw:");
        amount = sc.nextDouble();

        if(amount > this.getBalance()) {
            if(this.getBalance() + this.overDraftLimit >= amount) {
                this.overDraftAmount += (amount - this.getBalance());
                this.overDraftLimit -= (amount - this.getBalance());
                this.setBalance(0);
                System.out.println("Rupees " + amount + "Mony Withdraw successfully");
                System.out.println("Overdraft Amount is Rupees " + this.overDraftAmount);
                return amount;
            }
            else if(this.overDraftLimit > 0){
                System.out.println("Sorry You Cant Withdraw Amount!!!!!!");
                System.out.println("The Maximum Amount You Withdraw " + (this.overDraftLimit+this.getBalance()));
                System.out.println("Do you want to continue");
                System.out.println("1. Yes \n2. No");
                int choice = sc.nextInt();

                if(choice == 1) {
                    this.overDraftAmount += this.overDraftLimit;
                    this.overDraftLimit = 0;
                    System.out.println("Rupees " + this.overDraftLimit + " Withdraw Successfully......");
                    System.out.println("Overdraft amount is " + this.overDraftAmount);
                    return this.overDraftLimit;
                }
                else if(choice == 2){
                    System.out.println("Sorry You Cant Withdraw Amount!!!!!!");
                    return -1;
                }
                else {
                    System.out.println("Invalid Option!!!!");
                    return -1;
                }
            }
            else {
                System.out.println("Over Draft Limit is Extend");
                return -1;
            }
        }
        else {
            this.setBalance(this.getBalance() - amount);
            System.out.println("Rupees " + amount + " Withdraw Successfully......");
            return amount;
        }

    }

    @Override
    public double deposit() {

        double amount;
        System.out.println("Enter Deposit Amount");
        amount = sc.nextDouble();

        if(this.overDraftAmount > 0) {
            if(amount >= this.overDraftAmount) {
                this.overDraftLimit += this.overDraftAmount;
                this.setBalance(amount - this.overDraftAmount);
                this.overDraftAmount = 0;
                System.out.println("Rupees " + amount + " Deposit Successfully.....");
            }
            else {
                this.overDraftLimit += amount;
                this.overDraftAmount -= amount;
                System.out.println("Rupees " + amount + " Deposit Successfully");
            }
        }
        else {
            this.setBalance(this.getBalance() + amount);
            System.out.println("Rupees " + amount + " Deposit Successfully");
        }
        return amount;
    }

    @Override
    public void checkBalance() {

        if(this.overDraftAmount > 0) {
            System.out.println("CURRENTLY, YOU DO NOT HAVE ANY BALANCE IN YOUR ACCOUNT");
            if(this.overDraftLimit > 0) {
                System.out.println("BUT YOU HAVE GOT THE BENEFIT OF USING OVERDRAFT FACILITY");
            }
            else {
                System.out.println("ALSO YOUR OVERDRAFT LIMIT HAS BEEN EXCEEDED");
            }
        }
        else {
            System.out.println("YOUR CURRENT ACCOUNT BALANCE IS " + this.getBalance());
        }

    }

    @Override
    public double calculateInterestRate() {
        System.out.println("AS YOU ARE A CURRENT ACCOUNT USER, BANK DOES NOT PROVIDE ANY INTEREST ON ANY AMOUNT");
        return 0;
    }

}
