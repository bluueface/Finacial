package com.financial.framework;

import com.financial.creditcard.CreditCardAccount;
import com.financial.framework.builder.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public abstract class Customer {
    private final List<Account> accounts;
    private final List<CreditCardAccount> creditCardAccounts;
    private long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;

    public Customer(Builder builder) {
        accounts = new ArrayList<>();
        creditCardAccounts = new ArrayList<>();
        name = builder.getName();
        street = builder.getStreet();
        city = builder.getCity();
        state = builder.getState();
        zip = builder.getZip();
        email = builder.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public abstract String getType();
    public abstract boolean match(String identity);

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addCreditCard(CreditCardAccount account) {
        creditCardAccounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<CreditCardAccount> getCreditCardAccounts() {
        return creditCardAccounts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
