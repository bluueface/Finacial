package com.financial.banking;

public class SavingsInterestStrategy implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        double year = 1;
        return balance * (3 / 100) * year;
    }
}
