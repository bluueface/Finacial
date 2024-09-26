package com.financial.creditcard.strategy;

import com.financial.framework.strategy.CreditCardStrategy;

public class BronzeCCStrategy implements CreditCardStrategy {
    @Override
    public String getName() {
        return "Bronze Credit Card";
    }

    @Override
    public double getInterestRate() {
        return 10;
    }

    @Override
    public double getMonthlyPayment() {
        return 14;
    }
}
