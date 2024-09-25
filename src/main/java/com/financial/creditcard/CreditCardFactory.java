package com.financial.creditcard;

public interface CreditCardFactory {
    CreditCard createCreditCard(String cardHolderName, String accountNumber);
}