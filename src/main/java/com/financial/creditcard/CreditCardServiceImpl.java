package com.financial.creditcard;

import com.financial.creditcard.facade.BillingReport;
import com.financial.creditcard.facade.CreditCardService;
import com.financial.framework.Account;
import com.financial.framework.AccountDAOImpl;
import com.financial.framework.Customer;
import com.financial.framework.CustomerDAOImpl;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.facade.AccountDAO;
import com.financial.framework.facade.CustomerDAO;
import com.financial.framework.factory.CreditCardFactory;

import java.time.LocalDate;

public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardFactory factory;
    private final AccountDAO accountDAO;
    private final CustomerDAO customerDAO;

    public CreditCardServiceImpl() {
        this.factory = new CreditCardFactory();
        this.accountDAO = new AccountDAOImpl();
        this.customerDAO = new CustomerDAOImpl();
    }

    @Override
    public CreditCardAccount createCreditCard(CreditCardType type, PersonBuilder builder) {
        CreditCardAccount account = factory.createCreditCard(type, builder);
        Customer customer = account.getCustomer();
        customer.addAccount(account);
        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(customer);

        return account;
    }

    @Override
    public String generateMonthlyBillingReport() {
        StringBuilder billString = new StringBuilder();

        customerDAO.getCustomers().stream()
                .flatMap(customer -> customer.getCreditCardAccounts().stream())
                .forEach(account -> {
                    Customer customer = account.getCustomer();
                    LocalDate date = LocalDate.now();
                    BillingReport report = account.generateMonthlyReport();
                    billString.append("Name = ").append(customer.getName()).append("\r\n");
                    billString.append("CC number = ").append(account.getCardNumber()).append("\r\n");
                    billString.append("CC type= ").append(account.getAccountType()).append("\r\n");
                    billString.append(String.format("Previous balance = $%.2f%n", report.getPreviousBalance()));
                    billString.append(String.format("Total Credits = $%.2f%n", report.getTotalCredits()));
                    billString.append("Total Charges = $ ").append(report.getTotalCharges()).append("\r\n");
                    billString.append("New balance = $ ").append(report.getBalance()).append("\r\n");
                    billString.append("Charge Due = $ ").append(report.getChargeDue()).append("\r\n");
                    billString.append("\r\n");
                });

        System.out.println(billString);

        return billString.toString();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        if (account != null && amount > 0) {
            account.deposit(amount);
            accountDAO.updateAccount(account);
            account.notifyObservers("Payment of $" + amount + " received for credit card account: " + accountNumber);
        } else {
            System.out.println("Invalid payment amount or account not found.");
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        if (account != null && amount > 0) {
            account.withdraw(amount);
            accountDAO.updateAccount(account);
            if (amount > 400) {
                account.notifyObservers("Alert: A charge of $" + amount + " was made on your credit card account: " + accountNumber);
            }
        } else {
            System.out.println("Invalid charge amount or account not found.");
        }
    }

    @Override
    public void addInterest() {
        customerDAO.getCustomers().stream()
                .flatMap(customer -> customer.getAccounts().stream())
                .forEach(Account::addInterest);
    }
}
