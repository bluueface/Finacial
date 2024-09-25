package com.financial.creditcard;

import com.financial.banking.Person;
import com.financial.framework.Account;
import com.financial.framework.PersonBuilder;

public class CreditCardFactory {
    public Account createBronzeCCAccount(String accountNumber, PersonBuilder builder) {
        Person person = new Person(builder);
        return new BronzeCCAccount(accountNumber, person);
    }

    public Account createSilverCCAccount(String accountNumber, PersonBuilder builder) {
        Person person = new Person(builder);
        return new SilverCCAccount(accountNumber, person);
    }

    public Account createGoldCCAccount(String accountNumber, PersonBuilder builder) {
        Person person = new Person(builder);
        return new GoldCCAccount(accountNumber, person);
    }

}
