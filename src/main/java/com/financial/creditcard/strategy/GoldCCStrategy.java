package com.financial.creditcard.strategy;

import com.financial.framework.strategy.CreditCardStrategy;

public class GoldCCStrategy implements CreditCardStrategy {
    @Override
    public double getMonthlyPayment() {
        return 10;
    }

    @Override
    public String getName() {
        return "Gold Credit Card";
    }

    @Override
    public double getInterestRate() {
        return 6;
    }
}
