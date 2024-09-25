package com.financial.creditcard;

public class SilverCreditCardFactory implements CreditCardFactory {
    @Override
    public CreditCard createCreditCard(String cardHolderName, String accountNumber) {
        return new SilverCCAccount(accountNumber, generateCardNumber(), cardHolderName, 10000.0);  // Example limit
    }

    private String generateCardNumber() {
        return "SILVER" + Math.random();
    }
}