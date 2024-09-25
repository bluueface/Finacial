package com.financial.creditcard;

import com.financial.framework.Account;
import com.financial.framework.AccountType;

public abstract class CreditCard extends Account {
    protected String cardNumber;
    protected String cardHolderName;
    protected double limit;
    public CreditCard(String accountNumber, String cardNumber, String cardHolderName, double limit) {
        super(accountNumber);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.limit = limit;
    }

    protected abstract void charge(double amount);

    public void withdraw(double amount) {
        charge(amount);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public double getLimit() {
        return limit;
    }

    public abstract AccountType getType();
}
