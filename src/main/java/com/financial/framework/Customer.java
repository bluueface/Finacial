package com.financial.framework;

import com.financial.framework.builder.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Customer {
    private final List<Account> accounts;
    private long id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Customer(Builder builder) {
        accounts = new ArrayList<>();
        name = builder.getName();
        street = builder.getStreet();
        city = builder.getCity();
        state = builder.getState();
        zip = builder.getZip();
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

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
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
}
