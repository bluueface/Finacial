package com.financial.framework;

import com.financial.banking.Customer;
import com.financial.banking.InterestStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account {
    private String accountNumber;
    private InterestStrategy interestStrategy;
    // private AccountStrategy accountStrategy;
    private Customer customer;
    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
    }

    public double getBalance() {
        // double balance = 0;
        // for (AccountEntry entry : entryList) {
        // balance += entry.getAmount();
        // }
        // return balance;

        return 0;
    }

    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void addInterest(double interestRate){
        double interest = this.getBalance() * interestRate;
        withdraw(interest);
        addEntry(new AccountEntry(interest, "interest", "", accountNumber));
    }
}
