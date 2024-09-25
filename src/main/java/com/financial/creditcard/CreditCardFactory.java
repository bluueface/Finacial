package com.financial.creditcard;

import com.financial.banking.Person;
import com.financial.framework.Account;
import com.financial.framework.AccountType;
import com.financial.framework.PersonBuilder;

/*
 FIXME: make one class for creating all types of account
 */
public class CreditCardFactory {

    public Account createCreditCardAccount(String accountNumber, PersonBuilder builder, AccountType type) {
        switch (type) {
            case BRONZE:
                return createBronzeCCAccount(accountNumber, builder);
            case SILVER:
                return createSilverCCAccount(accountNumber, builder);
            case GOLD:
                return createGoldCCAccount(accountNumber, builder);
            default:
                return null;
        }
    }

    private Account createBronzeCCAccount(String accountNumber, PersonBuilder builder) {
        Person person = new Person(builder);
        return new BronzeCCAccount(accountNumber, person);
    }

    private Account createSilverCCAccount(String accountNumber, PersonBuilder builder) {
        Person person = new Person(builder);
        return new SilverCCAccount(accountNumber, person);
    }

    private Account createGoldCCAccount(String accountNumber, PersonBuilder builder) {
        Person person = new Person(builder);
        return new GoldCCAccount(accountNumber, person);
    }

}
