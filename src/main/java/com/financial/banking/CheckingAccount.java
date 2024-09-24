package com.financial.banking;

public class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void deposit(double amount) {
    }

    @Override
    public void withdraw(double amount) {
    }


}
