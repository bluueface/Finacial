package com.financial.creditcard.facade;

import com.financial.creditcard.CreditCardType;
import com.financial.framework.Account;

public interface CreditCardService {
    Account createCreditCard(CreditCardType cardType);
    void generateMonthlyBillingReport();
    void deposit(String accountNo, double amount);
    void withdraw(String accountNo, double amount);
    void addInterest();
}
