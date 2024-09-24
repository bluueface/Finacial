package com.financial.creditcard;

import com.financial.banking.Account;
import com.financial.banking.Customer;

public abstract class CreditCard extends Account {
    public CreditCard(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    protected abstract void charge(double amount);

    public void withdraw(double amount) {
        charge(amount);
    }
}
