package com.financial.creditcard;

import com.financial.creditcard.facade.CreditCardService;
import com.financial.framework.AccountDAOImpl;
import com.financial.framework.Customer;
import com.financial.framework.CustomerDAOImpl;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.consumer.AccountSummaryConsumer;
import com.financial.framework.facade.AccountDAO;
import com.financial.framework.facade.CustomerDAO;
import com.financial.framework.factory.CreditCardFactory;

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
        customer.addCreditCard(account);
        customer.addAccount(account);
        accountDAO.saveAccount(account);
        customerDAO.saveCustomer(customer);

        return account;
    }

    @Override
    public String generateMonthlyBillingReport() {
        StringBuilder billString = new StringBuilder();

        customerDAO.getCustomers().forEach(customer -> {
            customer.getCreditCardAccounts().forEach(account -> {
                AccountSummaryConsumer summaryConsumer = new AccountSummaryConsumer(2024, 9);
                account.getEntryList().forEach(summaryConsumer);

                billString.append("Name= ").append(customer.getName()).append("\r\n");
                billString.append("CC number= ").append(account.getCardNumber()).append("\r\n");
                /**
                 * FIXME
                 */
                // billString.append("CC type= ").append(account.getAccountType()).append("\r\n");
                billString.append("Previous balance = $ ").append(summaryConsumer.getPreviousBalance()).append("\r\n");
                billString.append("Total Credits = $ ").append(summaryConsumer.getTotalCredits()).append("\r\n");
                billString.append("Total Charges = $ ").append(summaryConsumer.getTotalCharges()).append("\r\n");

                double newBalance = summaryConsumer.getPreviousBalance() + summaryConsumer.getTotalCharges() - summaryConsumer.getTotalCredits();
                billString.append("New balance = $ ").append(newBalance).append("\r\n");
                billString.append("\r\n");
            });
        });

        System.out.println(billString);


        return billString.toString();
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
