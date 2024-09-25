package com.financial.creditcard;

import com.financial.framework.AccountType;

public class GoldCCAccount extends CreditCard {

    public GoldCCAccount(String accountNumber, String cardNumber, String cardHolderName, double limit) {
        super(accountNumber, cardNumber, cardHolderName, limit);
    }

    @Override
    protected void charge(double amount) {

    }
    @Override
    public AccountType getType() {
        return AccountType.GOLD;
    }
}
