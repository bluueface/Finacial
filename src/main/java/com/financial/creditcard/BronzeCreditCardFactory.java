package com.financial.creditcard;

public class BronzeCreditCardFactory implements CreditCardFactory {
    @Override
    public CreditCard createCreditCard(String cardHolderName, String accountNumber) {
        return new BronzeCCAccount(accountNumber, generateCardNumber(), cardHolderName, 10000.0);  // Example limit
    }

    private String generateCardNumber() {
        return "BRONZE" + Math.random();
    }
}