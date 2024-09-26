package com.financial.banking;

import com.financial.framework.*;

import java.util.Collection;

public class BankingServiceImpl implements BankingService {
    private AccountDAO accountDAO;
    BankingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account createAccount(String accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        accountDAO.saveAccount(account);
        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return null;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return null;
    }

    @Override
    public void deposit(String accountNumber, double amount) {

    }

    @Override
    public void withdraw(String accountNumber, double amount) {

    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {

    }

    @Override
    public void addInterest(String accountNumber, InterestStrategy strategy) {

    }

    @Override
    public void generateAccountsReport(String startOfMonth, String endOfMonth) {

    }
}
