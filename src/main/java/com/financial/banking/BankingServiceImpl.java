package com.financial.banking;

import com.financial.framework.*;

public class BankingServiceImpl implements BankingService {
//    private final AccountFactory accountFactory;
    private Command command;

    public BankingServiceImpl() {
//        accountFactory = new AccountFactory();
    }
    @Override
    public Account createAccount(AccountType type, String accountNumber) {
        Account account = null;
//        AccountFactory accountFactory = new AccountFactory();
//        account = accountFactory.createAccount(type, accountNumber);
        return account;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        AccountDAO accountDAO = new AccountDAOImpl();
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        AccountDAO accountDAO = new AccountDAOImpl();
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
    }

    @Override
    public void addInterest(String accountNumber, double interestRate) {
        AccountDAO accountDAO = new AccountDAOImpl();
        Account account = accountDAO.loadAccount(accountNumber);
//        account.addInterest(interestRate);
    }

    @Override
    public void generateAccountsReport() {
        // iterate over all customer accounts
    }
}
