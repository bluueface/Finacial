package com.financial.creditcard;

public class GoldCreditCardFactory implements CreditCardFactory {
    @Override
    public CreditCard createCreditCard(String cardHolderName, String accountNumber) {
        return new GoldCCAccount(accountNumber, generateCardNumber(), cardHolderName, 10000.0);  // Example limit
    }

    private String generateCardNumber() {
        return "GOLD" + Math.random();
    }

}