package com.financial.framework.strategy;

import com.financial.framework.Account;

public class SavingsAccountStrategy implements AccountStrategy {
    @Override
    public String getName() {
        return "Savings";
    }

    @Override
    public double getInterestRate() {
        return 10;
    }

    @Override
    public double computeInterest(Account account) {
        return 0;
    }
}
