package com.financial.creditcard;

import com.financial.creditcard.facade.CreditCardService;
import com.financial.framework.builder.PersonBuilder;
import com.financial.framework.factory.CreditCardFactory;

public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardFactory factory;

    public CreditCardServiceImpl(CreditCardFactory factory) {
        this.factory = factory;
    }

    @Override
    public CreditCardAccount createCreditCard(CreditCardType type, PersonBuilder builder) {
        CreditCardAccount creditCard = factory.createCreditCard(type, new PersonBuilder());
        System.out.println(creditCard.getCardNumber());
        return creditCard;
    }

    @Override
    public void generateMonthlyBillingReport() {
        System.out.println("Monthly billing report");
    }

    @Override
    public void deposit(double amount) {
        System.out.println("Deposit ");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdraw");
    }

    @Override
    public void addInterest() {
        System.out.println("Add Interest");
    }
}
