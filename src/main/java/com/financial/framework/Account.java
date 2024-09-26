package com.financial.framework;

import com.financial.framework.strategy.AccountStrategy;

import java.util.*;

public class Account {
    private String accountNumber;
    private final AccountStrategy accountStrategy;
    private final Customer customer;
    private final List<AccountEntry> entryList = new LinkedList<>();

    public Account(String accountNumber, Customer customer, AccountStrategy accountStrategy) {
        this.accountNumber = accountNumber;
        this.accountStrategy = accountStrategy;
        this.customer = customer;
    }

    public Account(Customer customer, AccountStrategy accountStrategy) {
        this.accountNumber = generateAccountNo();
        this.accountStrategy = accountStrategy;
        this.customer = customer;
    }

    public boolean match(String accountNo) {
        return this.accountNumber.equals(accountNo);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount, String description) {
        AccountEntry entry = new AccountEntry(amount, description);
        entryList.add(entry);
    }

    public void deposit(double amount) {
        deposit(amount, "deposit");
    }

    public void withdraw(double amount, String description) {
        AccountEntry entry = new AccountEntry(-amount, description);
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        withdraw(amount, "withdraw");
    }

    public void addInterest() {
        double interest = accountStrategy.computeInterest(this);
        this.deposit(interest);
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

    public Customer getCustomer() {
        return customer;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private String generateAccountNo() {
        return String.valueOf(new Date().getTime()).substring(0, 10);
    }

    public AccountStrategy getAccountStrategy() {
        return accountStrategy;
    }
}
