package com.financial.framework;

import com.financial.creditcard.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class Person implements Party {
    private String name;
    private List<Account> accounts;
    private List<CreditCard> creditCards;

    public Person(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.creditCards = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void addCreditCard(CreditCard creditCard) {
        creditCards.add(creditCard);
    }

    @Override
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }
}