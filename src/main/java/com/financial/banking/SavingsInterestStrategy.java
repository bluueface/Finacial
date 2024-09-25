package com.financial.banking;

public class SavingsInterestStrategy implements InterestStrategy {

    @Override
    public String getStrategyName() {
        return "Saving";
    }

    @Override
    public double calculateInterest(double balance) {
        return balance * 0.03;
    }
}
