package com.case_Study_1;

import java.util.Scanner;

import com.case_Study_1.Account;

public class SavingAccount extends Account{

    static double minBalance ;
    static double interestRate;
    static Scanner sc = new Scanner(System.in);

    static {
        interestRate = 4.5;
        minBalance = 10000;
    }

    public SavingAccount() {
        super();
    }

    public SavingAccount(int accNo, String holder_Name, double balance) {
        super(accNo, holder_Name, balance);
    }


    public static double getMinBalance() {
        return minBalance;
    }


    public static void setMinBalance(double minBalance) {
        SavingAccount.minBalance = minBalance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        SavingAccount.interestRate = interestRate;
    }

    @Override
    public double withdraw() {

        double amount;
        System.out.println("Enter the amount you want to withdraw:");
        amount = sc.nextDouble();

        if(this.getBalance() - amount >= minBalance) {
            System.out.println("The required amount Rps" + amount + " has been successfully withdraw");
            this.setBalance(this.getBalance() - amount);
            return amount;
        }
        else if(this.getBalance() > minBalance){
            System.out.println("THE MAXIMUM AMOUNT YOU CAN WITHDRAW IS RUPEE " + (this.getBalance() - minBalance) + "AS WE HAVE TO MAINTAIN MINIMUM BALANCE TO BE AT LEAST RUPEE " + minBalance);
            System.out.println("Do you want to continue?");
            System.out.println("1. Yes\n2. No");
            int choice = sc.nextInt();

            if(choice == 1) {
                System.out.println("Rps " + (this.getBalance() - minBalance) + " Hhas been successfully withdraw");

                this.setBalance(this.getBalance() - (this.getBalance() - minBalance));
                return this.getBalance() - minBalance;
            }
            else {
                System.out.println("SORRY!! THEN YOU CAN'T WITHDRAW MONEY");
                return -1;
            }
        }
        else {
            System.out.println("SORRY!! CAN'T WITHDRAW MONEY. Your current balance is less than minimub balance " + minBalance);
            return -1;
        }
    }

    @Override
    public double deposit() {

        double amount;
        System.out.println("Enter the amount to deposite:");
        amount = sc.nextDouble();

        this.setBalance(this.getBalance() + amount);

        System.out.println("RUPEE " + amount + " SUCCESSFULLY DEPOSITED TO YOUR ACCOUNT");

        return amount;
    }

    @Override
    public void checkBalance() {
        System.out.println("YOUR CURRENT BALANCE IS RUPEE " + this.getBalance());
    }

    @Override
    public double calculateInterestRate() {

        int time;
        System.out.println("How long you are going to keep your money in our bank?(In month)");
        time = sc.nextInt();
        double interest = (this.getBalance()*interestRate*time)/12;
        System.out.println("This much interest Rps " +interest+ " you will be recieiving from our bank till this " + time + " Month time peroid");
        System.out.print("Your total balance in Rps " + this.getBalance() + interest);
        return this.getBalance() + interest;

    }
}
