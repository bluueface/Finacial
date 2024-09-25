package com.financial.banking;

import com.financial.framework.Account;

import java.util.Observable;

public class CompanyCheckingAccount extends Account {
    private Observable observable = new Observable() {};

    public CompanyCheckingAccount(String accountNumber) {
        super(accountNumber);
    }

    @Override
    public void withdraw(double amount) {
//        observable.
    }

//    public notifyObservers()

}
