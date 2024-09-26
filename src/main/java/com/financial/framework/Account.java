package com.financial.framework;

import com.financial.banking.InterestStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Account {
    private String accountNumber;
    private Party customer;
    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();
    private InterestStrategy interestStrategy;
    private double balance;

    public Account(String accountNumber, Party customer) {
        this.balance = 1000;
        this.accountNumber = accountNumber;
        this.customer = customer;
    }
    public Account(String accountNumber) {
        this.balance = 1000;
        this.accountNumber = accountNumber;
    }
    public double getBalance() {;
        return balance;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void addInterest(InterestStrategy interest) {
        this.interestStrategy = interest;
    }

    public InterestStrategy getInterestStrategy() {
        return this.interestStrategy;
    }

    public double calculateInterest() {
        return this.balance = this.balance + interestStrategy.calculateInterest(balance);
    }
}
