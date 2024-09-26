package com.financial.framework.factory;

import com.financial.creditcard.*;
import com.financial.creditcard.strategy.BronzeCCStrategy;
import com.financial.creditcard.strategy.GoldCCStrategy;
import com.financial.creditcard.strategy.SilverCCStrategy;
import com.financial.framework.strategy.CreditCardStrategy;
import com.financial.framework.Person;
import com.financial.framework.builder.PersonBuilder;

public class CreditCardFactory {
    public CreditCardAccount createCreditCard(CreditCardType cardType, PersonBuilder builder) {
        Person person = new Person(builder);
        CreditCardStrategy strategy;
        if (cardType == CreditCardType.SILVER) {
            strategy = new SilverCCStrategy();
        } else if (cardType == CreditCardType.BRONZE) {
            strategy = new BronzeCCStrategy();
        } else {
            strategy = new GoldCCStrategy();
        }
        CreditCardAccount account = new CreditCardAccount(person, strategy);
        account.getCustomer().addCreditCard(account);
        return account;
    }
}
