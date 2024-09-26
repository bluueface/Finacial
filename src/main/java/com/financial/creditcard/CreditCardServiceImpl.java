package com.financial.creditcard;

import com.financial.creditcard.facade.CreditCardService;
import com.financial.framework.Customer;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.facade.AccountDAO;
import com.financial.framework.facade.CustomerDAO;
import com.financial.framework.factory.CreditCardFactory;

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
    public void deposit(double amount) {
        System.out.println("Deposit ");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw");
    }

    @Override
    public void addInterest() {
        System.out.println("Add Interest");
    }
}
