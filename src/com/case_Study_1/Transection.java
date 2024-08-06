package com.case_Study_1;

public class Transection {

    int transactionNumber;
    int accNo;
    String transactionType;
    double amount;
    double totalBalance;
    static final String userName = "AsjadRaza";
    static final String password = "Asjad@123";

    public Transection() {
        // TODO Auto-generated constructor stub
    }

    public Transection(int transactionNumber, int accNo, String transactionType, double amount, double totalBalance) {
        super();
        this.transactionNumber = transactionNumber;
        this.accNo = accNo;
        this.transactionType = transactionType;
        this.amount = amount;
        this.totalBalance = totalBalance;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public static String getUsername() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "transactionNumber=" + transactionNumber + ", accNo=" + accNo + ", transactionType="
                + transactionType + ", amount=" + amount + ", totalBalance=" + totalBalance;
    }



}