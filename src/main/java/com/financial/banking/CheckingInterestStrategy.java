package com.financial.banking;

public class CheckingInterestStrategy implements InterestStrategy {

    @Override
    public String getStrategyName() {
        return "Checking";
    }
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.03;
    }
}
