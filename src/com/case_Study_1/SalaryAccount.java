package com.case_Study_1;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import com.case_Study_1.SavingAccount;


public class SalaryAccount extends SavingAccount{

        LocalDate lastTranDate;
        String status;
        static double interestRate;
        static double minBalance;
        static Scanner sc = new Scanner(System.in);

        static {
                interestRate = 2.0;
                minBalance = 10000;
        }

        public SalaryAccount() {
                super();
        }

        public SalaryAccount(int accNo, String accHolderName, double balance,LocalDate lastTranDate, String status) {
                super(accNo, accHolderName, balance);
                this.lastTranDate = lastTranDate;
                this.status = status;
        }


        public double deposit() {
                return super.deposit();
        }

        public double withdraw() {

                String currDate;
                System.out.println("Enterdate in YYYY-MM-DD format:");
                currDate = sc.next();

                LocalDate curDate = LocalDate.parse(currDate);

                if(checkStatus(curDate)) {
                        double result = super.withdraw();
                        if(result > 0) {
                                status = "active";
                                this.lastTranDate = LocalDate.now();
                                return result;
                        }
                }
                else {
                        //System.out.println("TRANSACTION NOT PERFORMED MORE THAN 2 MONTHS");
                        status = "freeze";
                        return -1;
                }
                return -1;
        }

        public boolean checkStatus(LocalDate date) {

                long days = ChronoUnit.DAYS.between(this.lastTranDate, date);
                System.out.println("Difference in days: " + days);

                if(days >= 61) {
                        activateAccount();
                        //return false;
                }
                return true;
        }

        public void activateAccount()
        {
                int choice=0;
                System.out.println("Your Salary account is Freez.\nBecause of there is no trasuction is done since from last 60 dayes.\n Do you want to activate your frozen account.");
                System.out.println("\n1. Yes \n2. No");
                choice=sc.nextInt();
                if(choice==1)
                {
                        System.out.println("To activate your account you have to pay 150 rps");
                        System.out.println("Do you want to pay 150 rps to ARVIND Bank? \n1. Yes \n2. Exit");
                        int m=sc.nextInt();
                        if(m==1)
                        {
                                if((getBalance()-150)< minBalance)
                                {
                                        System.out.println("Sorry...Your amount is insufficient!!!");
                                }
                                else
                                {
                                        System.out.println("150 rps is deducted from your account.\nCONGRATULATIONS...!!!Your account activate sucessfully");
                                        System.out.println("Your remaining balance is :" +(getBalance()-150));
                                }
                        }
                        else if(m==2)
                        {
                                System.out.println("Ok exit...Thnak you.!!!");
                        }
                }
                else if(choice==2)
                {
                        System.out.println("THANK YOU...Exit");
                }
        }

        public void checkBalance() {
                System.out.println("Your salary balance is Rps " + this.getBalance());
        }

        public double calculateInterest() {
                return super.calculateInterestRate();
        }
}

