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

    public BankingServiceImpl() {
        this.accountFactory = new AccountFactory();
        this.accountDAO = new AccountDAOImpl();
        this.customerDAO = new CustomerDAOImpl();
    }

    @Override
    public Account createPersonalAccount(String accountNo, PersonBuilder personBuilder) {
        Account account = accountFactory.createPersonalAccount(accountNo, personBuilder);

        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(account.getCustomer());

        return account;
    }

    @Override
    public Account createSavingsAccount(String accountNo, CompanyBuilder companyBuilder) {
        Account account = accountFactory.createSavingsAccount(accountNo, companyBuilder);

        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(account.getCustomer());

        return account;
    }

    @Override
    public Account createCheckingAccount(String accountNo, CompanyBuilder companyBuilder) {
        Account account = accountFactory.createCheckingAccount(accountNo, companyBuilder);

        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(account.getCustomer());

        return account;
    }

    @Override
    public void deposit(String accountNo, double amount) {
        Account account = accountDAO.loadAccount(accountNo);
        if (account != null && amount > 0) {
            account.deposit(amount);
            accountDAO.saveAccount(account);
            if (account.getAccountStrategy().getName().equals("Company")) {
                //implement observer
                //EmailService.sendEmail("Company", "Account " + accountNumber + " had a deposit of $" + amount);
            } else if (amount > 500) {
                //implement observer
                //EmailService.sendEmail("Personal", "Account " + accountNumber + " had a deposit of $" + amount + ". New balance: $" + balance);
            } else {
                System.out.println("Invalid deposit or account not found.");
            }
        }
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        Account account = accountDAO.loadAccount(accountNo);
        if (account != null && amount > 0 && amount <= account.getBalance()) {
            account.withdraw(amount);
            accountDAO.saveAccount(account);
            if (account.getAccountStrategy().getName().equals("Company")) {
                //implement observer
                //EmailService.sendEmail("Company", "Account " + accountNumber + " had a withdrawal of $" + amount);
            } else if (amount > 500 || amount < 0) {
                //implement observer
                //EmailService.sendEmail("Personal", "Account " + accountNumber + " had a withdrawal of $" + amount + ". New balance: $" + balance);
            } else {
                System.out.println("Invalid withdrawal, insufficient funds, or account not found.");
            }
        }
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