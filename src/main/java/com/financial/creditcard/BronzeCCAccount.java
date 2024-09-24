package com.financial.creditcard;

import com.financial.banking.Customer;

public class BronzeCCAccount extends CreditCard {

    public BronzeCCAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    protected void charge(double amount) {

    }
}
