package com.financial.creditcard;

import com.financial.creditcard.facade.CreditCardService;
import com.financial.framework.Account;
import com.financial.framework.AccountEntry;
import com.financial.framework.Customer;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.facade.AccountDAO;
import com.financial.framework.facade.CustomerDAO;
import com.financial.framework.factory.CreditCardFactory;

import java.time.LocalDate;

public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardFactory factory;
    private final AccountDAO accountDAO;
    private final CustomerDAO customerDAO;

    public CreditCardServiceImpl(CreditCardFactory factory, AccountDAO accountDAO, CustomerDAO customerDAO) {
        this.factory = factory;
        this.accountDAO = accountDAO;
        this.customerDAO = customerDAO;
    }

    @Override
    public CreditCardAccount createCreditCard(CreditCardType type) {
        CreditCardAccount account = factory.createCreditCard(type, new PersonBuilder());
        Customer customer = account.getCustomer();
        customer.addCreditCard(account);
        customer.addAccount(account);
        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(customer);

        return account;
    }

    @Override
    public void generateMonthlyBillingReport() {
        customerDAO.getCustomers().stream()
                .flatMap(customer -> customer.getCreditCardAccounts().stream())
                .forEach(System.out::println);
    }

    @Override
    public void deposit(String accountNo, double amount) {
        Account account = accountDAO.loadAccount(accountNo);
        if (account != null && amount > 0) {
            account.deposit(amount);
            accountDAO.updateAccount(account);
            // Notify the customer about the payment
            //implement observer
//            EmailService.sendEmail(account.getCustomer().getEmail(),
//                    "Payment of $" + amount + " received for credit card account: " + accountNo);
        } else {
            System.out.println("Invalid payment amount or account not found.");
        }
    }

    @Override
    public void withdraw(String accountNo, double amount) {
        Account account = accountDAO.loadAccount(accountNo);
        if (account != null && amount > 0) {
            account.withdraw(amount);
            accountDAO.updateAccount(account);
            // Notify the customer if the charge is over $400
            if (amount > 400) {
                // implement observer
               /* EmailService.sendEmail(account.getCustomer().getEmail(),
                        "Alert: A charge of $" + amount + " was made on your credit card account: " + accountNo +
                              ". Description: " + description);*/
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
