package com.financial.creditcard;

import com.financial.framework.Account;
import com.financial.framework.AccountType;
import com.financial.framework.PersonBuilder;

public interface CreditCardService {
    Account createCreditCard(String accountNumber, PersonBuilder builder, AccountType type);

    void generateMonthlyBillingReport();

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void addInterest();
}
