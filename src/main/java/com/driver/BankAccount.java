package com.driver;

public class BankAccount {

    //attributes
    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {

    }

    public String getName() {
        return name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    //Constructor to the attributes
    public BankAccount(String name, double balance, double minBalance) {

        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception // Actually throws exception
     {
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
         if(sum>9*digits)
         {
             throw new Exception("Account Number cannot be generated");
         }
         int quotient=sum/9;
         int remainder=sum%9;

         String accNo="";
         while (quotient-->0)
         {
             accNo+=9;
         }
         if (remainder>0)
         {
             accNo+=remainder;
         }
         int remainingDigit=digits-accNo.length();
         while (remainingDigit-->0)
         {
             accNo+="0";
         }
         return accNo;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if((balance-amount)>minBalance)
        {
            balance-=amount;
        }
        else
        {
            throw new Exception("Insufficient Balance");
        }

    }

}