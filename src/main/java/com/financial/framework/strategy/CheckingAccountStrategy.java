package com.financial.framework.strategy;

public class CheckingAccountStrategy implements AccountStrategy {
    @Override
    public String getName() {
        return "Checking";
    }

    @Override
    public double getInterestRate() {
        return 2;
    }
}
