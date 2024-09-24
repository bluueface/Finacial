package com.financial.creditcard;

import com.financial.banking.Customer;

public class SilverCCAccount extends CreditCard{

    public SilverCCAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    protected void charge(double amount) {

    }
}
