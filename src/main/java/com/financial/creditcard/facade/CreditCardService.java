package com.financial.creditcard.facade;

import com.financial.creditcard.CreditCardType;
import com.financial.framework.Account;
import com.financial.framework.builder.PersonBuilder;

public interface CreditCardService {
    Account createCreditCard(CreditCardType cardType, PersonBuilder builder);

    String generateMonthlyBillingReport();

    void deposit(String accountNumber,double amount);

    void withdraw(String accountNumber,double amount);

    void addInterest();
}
