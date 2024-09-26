package com.financial.creditcard;

import com.financial.creditcard.facade.CreditCardService;
import com.financial.framework.Account;
import com.financial.framework.AccountEntry;
import com.financial.framework.AccountDAOImpl;
import com.financial.framework.Customer;
import com.financial.framework.CustomerDAOImpl;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.consumer.AccountSummaryConsumer;
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
