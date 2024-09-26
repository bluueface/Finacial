package com.financial.banking;

import com.financial.banking.facade.BankingService;
import com.financial.framework.*;
import com.financial.framework.builder.CompanyBuilder;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.facade.AccountDAO;
import com.financial.framework.factory.AccountFactory;

import java.util.ArrayList;
import java.util.List;

public class BankingServiceImpl implements BankingService {
    private final List<Customer> customers = new ArrayList<>();
    private final AccountFactory accountFactory;
    private final AccountDAO accountDAO;

    public BankingServiceImpl(AccountFactory accountFactory, AccountDAO accountDAO) {
        this.accountFactory = accountFactory;
        this.accountDAO = accountDAO;
    }

    @Override
    public Account createPersonalAccount(String accountNo) {
        return accountFactory.createPersonalAccount(accountNo, new PersonBuilder());
    }

    @Override
    public Account createSavingsAccount(String accountNo) {
        return accountFactory.createSavingsAccount(accountNo, new CompanyBuilder());
    }

    @Override
    public Account createCheckingAccount(String accountNo) {
        Account account = accountFactory.createCheckingAccount(accountNo, new CompanyBuilder());
        accountDAO.saveAccount(account);
        Customer customer = account.getCustomer();
        customer.addAccount(account);
        //customerDAO.saveCustomer(customer);

        return account;
    }

    @Override
    public void deposit(String accountNo, double amount) {

    }

    @Override
    public void withdraw(String accountNo, double amount) {

    }

    @Override
    public void addInterest() {

    }

    @Override
    public void generateAccountsReport() {
        // iterate over all customer accounts
    }

    private void saveCustomer(Account account) {

    }
}
