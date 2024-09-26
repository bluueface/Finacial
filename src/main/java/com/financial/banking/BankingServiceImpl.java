package com.financial.banking;

import com.financial.banking.facade.BankingService;
import com.financial.framework.*;
import com.financial.framework.builder.CompanyBuilder;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.facade.AccountDAO;
import com.financial.framework.facade.CustomerDAO;
import com.financial.framework.factory.AccountFactory;

import java.util.ArrayList;
import java.util.List;

public class BankingServiceImpl implements BankingService {
    private final List<Customer> customers = new ArrayList<>();
    private final AccountFactory accountFactory;
    private final AccountDAO accountDAO;
    private final CustomerDAO customerDAO;

    public BankingServiceImpl(AccountFactory accountFactory, AccountDAO accountDAO, CustomerDAO customerDAO) {
        this.accountFactory = accountFactory;
        this.accountDAO = accountDAO;
        this.customerDAO = customerDAO;
    }

    @Override
    public Account createPersonalAccount(String accountNo) {
        Account account = accountFactory.createPersonalAccount(accountNo, new PersonBuilder());
        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(account.getCustomer());

        return account;
    }

    @Override
    public Account createSavingsAccount(String accountNo) {
        Account account = accountFactory.createSavingsAccount(accountNo, new CompanyBuilder());
        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(account.getCustomer());

        return account;
    }

    @Override
    public Account createCheckingAccount(String accountNo) {
        Account account = accountFactory.createCheckingAccount(accountNo, new CompanyBuilder());
        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(account.getCustomer());

        return account;
    }

    @Override
    public void deposit(String accountNo, double amount) {
        Account account = accountDAO.loadAccount(accountNo);
        account.deposit(amount);
        accountDAO.saveAccount(account);
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        Account account = accountDAO.loadAccount(accountNo);
        account.withdraw(amount);
        accountDAO.saveAccount(account);
    }

    @Override
    public void addInterest() {
        customerDAO.getCustomers().stream()
                .flatMap(customer -> customer.getAccounts().stream())
                .forEach(Account::addInterest);
    }

    @Override
    public void generateAccountsReport() {
        customerDAO.getCustomers().stream()
                .flatMap(customer -> customer.getAccounts().stream())
                .forEach(System.out::println);
    }
}
