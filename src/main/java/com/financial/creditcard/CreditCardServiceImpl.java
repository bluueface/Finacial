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
    public CreditCardAccount createCreditCard(CreditCardType type) {
        return factory.createCreditCard(type, new PersonBuilder());
    }

    @Override
    public void generateMonthlyBillingReport() {

    }

    @Override
    public void deposit(double amount) {

    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void addInterest() {

    }
}
