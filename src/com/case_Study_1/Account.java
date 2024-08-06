package com.case_Study_1;

public abstract class Account {

    private int accNo;
    private String holder_Name;
    private double balance;

    public Account() {
        // TODO Auto-generated constructor stub
    }

    public Account(int accNo, String holder_Name, double balance) {
        super();
        this.accNo = accNo;
        this.holder_Name = holder_Name;
        this.balance = balance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getholder_Name() {
        return holder_Name;
    }

    public void setholder_Name(String holder_Name) {
        this.holder_Name = holder_Name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account Number = " + accNo + "Name  = " + holder_Name + ", Balance = " + balance;
    }

    public abstract double withdraw();
    public abstract double deposit();
    public abstract void checkBalance();
    public abstract double calculateInterestRate();

}
