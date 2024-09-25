package com.financial.framework;

import com.financial.creditcard.CreditCard;

import java.util.List;

public interface Party {
    String getName();

    // Methods for managing accounts
    List<Account> getAccounts();
    void addAccount(Account account);
    void addCreditCard(CreditCard creditCard);
    List<CreditCard> getCreditCards();
}