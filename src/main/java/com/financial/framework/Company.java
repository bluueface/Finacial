package com.financial.framework;


import com.financial.creditcard.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class Company implements Party {
    private String companyName;
    private String taxID;
    private List<Account> accounts;
    private List<Person> people;
    private List<CreditCard> creditCards;

    public Company(String companyName, String taxID) {
        this.companyName = companyName;
        this.taxID = taxID;
        this.people = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.creditCards = new ArrayList<>();
    }

    @Override
    public String getName() {
        return companyName;
    }

    public String getTaxID() {
        return taxID;
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

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }
}