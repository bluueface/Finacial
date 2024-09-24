package com.financial.banking;

import com.financial.framework.Account;
import com.financial.framework.AccountFactory;

import java.util.ArrayList;
import java.util.List;

public class BankingServiceImpl implements BankingService {
    private final List<Customer> customers;
    private final AccountFactory accountFactory;

    public BankingServiceImpl() {
        accountFactory = new AccountFactory();
        customers = new ArrayList<>();
    }

    @Override
    public Account createAccount() {
        return null;
    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void addInterest() {

    }

    @Override
    public void generateAccountsReport() {
        // iterate over all customer accounts
    }
}
