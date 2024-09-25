package com.financial.banking;

public class PersonalAccountInterestStrategy implements InterestStrategy {
    @Override
    public String getStrategyName() {
        return "Personal";
    }

    @Override
    public double calculateInterest(double balance) {
        return balance * 0.03;
    }
}
