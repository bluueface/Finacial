package com.financial.creditcard;

import com.financial.framework.Account;

public interface CreditCardService {
    Account createCreditCard();
    void generateMonthlyBillingReport();
    void deposit(double amount);
    void withdraw(double amount);
    void addInterest();
}
