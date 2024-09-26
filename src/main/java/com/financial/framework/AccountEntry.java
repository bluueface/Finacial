package com.financial.framework;

import java.util.Date;

public class AccountEntry {
    private final Date date;
    private final double amount;
    private final String description;
    private final double balance;

    public AccountEntry(double amount, String description) {
        super();
        this.date = new Date();
        this.amount = amount;
        this.description = description;
        balance = 0;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
