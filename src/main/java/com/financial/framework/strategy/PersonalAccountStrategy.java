package com.financial.framework.strategy;

public class PersonalAccountStrategy implements AccountStrategy {
    @Override
    public String getName() {
        return "Personal";
    }

    @Override
    public double getInterestRate() {
        return 4.2;
    }
}
