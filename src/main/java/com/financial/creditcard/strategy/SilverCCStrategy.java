package com.financial.creditcard.strategy;

import com.financial.framework.strategy.CreditCardStrategy;

public class SilverCCStrategy implements CreditCardStrategy {
    @Override
    public double getMonthlyPayment() {
        return 12;
    }

    @Override
    public String getName() {
        return "Silver Credit Card";
    }

    @Override
    public double getInterestRate() {
        return 8;
    }
}
