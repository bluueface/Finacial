package com.financial.creditcard;

import com.financial.banking.Customer;

public class GoldCCAccount extends CreditCard {

    public GoldCCAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    protected void charge(double amount) {

    }
}
