package com.financial.banking;

public interface InterestStrategy {
    String getStrategyName();
    double calculateInterest(double balance);
}
