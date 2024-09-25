package com.financial.creditcard;

import com.financial.framework.*;

public class CreditCardServiceImpl implements CreditCardService {
    private final AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public Account createCreditCard(String accountNumber, AccountType type) {
//        CreditCardFactory creditCardFactory = new CreditCardFactory();
//        Account account = creditCardFactory.createCreditCardAccount(accountNumber, type);
//        accountDAO.saveAccount(account);
//        return account;
        return null;
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);

    }

    @Override
    public void addInterest() {

    }

    @Override
    public void generateMonthlyBillingReport() {

    }
}
