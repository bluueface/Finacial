package com.financial.creditcard;

import com.financial.framework.Account;
import com.financial.framework.AccountType;

public interface CreditCardService {
    Account createCreditCard(String accountNumber, AccountType type);

    void generateMonthlyBillingReport();

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void addInterest();
}
