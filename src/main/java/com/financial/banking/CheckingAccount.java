package com.financial.banking;

import com.financial.framework.Account;
import com.financial.framework.Company;

import java.util.Observable;

public class CheckingAccount extends Account {
    private Observable observable = new Observable() {};

    public CheckingAccount(String accountNumber, Company company) {
        super(accountNumber, company);
    }

    @Override
    public void withdraw(double amount) {
//        observable.
    }

//    public notifyObservers()

}
