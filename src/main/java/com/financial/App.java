package com.financial;

import com.financial.banking.InterestStrategy;
import com.financial.banking.PersonalAccount;
import com.financial.banking.PersonalAccountInterestStrategy;
import com.financial.creditcard.*;
import com.financial.framework.Account;
import com.financial.framework.Company;
import com.financial.framework.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Customer creations
        Person person_1 = new Person("Tume");
        Person person_2 = new Person("Tumejka");

        // Accounts for each customer
        Account account_1 = new PersonalAccount("1605155756");
        Account account_2 = new PersonalAccount("8010040803");
        Account account_3 = new PersonalAccount("2010040803");
        person_1.addAccount(account_1);
        person_2.addAccount(account_2);
        person_2.addAccount(account_3);

        // Company creations
        Company company = new Company("TechCorp", "TAX56789");
        company.addPerson(person_1);

        //Credit card integration with customers
        CreditCardFactory goldFactory = new GoldCreditCardFactory();
        CreditCardFactory silverFactory = new SilverCreditCardFactory();
        CreditCardFactory bronzeFactory = new BronzeCreditCardFactory();

        List<Account> accs = person_1.getAccounts();
        List<Account> accs_2 = person_2.getAccounts();

        CreditCard tumeGoldCard = goldFactory.createCreditCard(person_1.getName(), accs.get(0).getAccountNumber());
        CreditCard tumeSilverCard = silverFactory.createCreditCard(person_2.getName(), accs_2.get(0).getAccountNumber());
        CreditCard tumeBronzeCard = bronzeFactory.createCreditCard(person_2.getName(), accs_2.get(1).getAccountNumber());

        person_1.addCreditCard(tumeGoldCard);
        person_2.addCreditCard(tumeSilverCard);
        person_2.addCreditCard(tumeBronzeCard);

        for (CreditCard card : person_1.getCreditCards()) {
            System.out.println("Person: " + person_1.getName() + ", Card Type: " + card.getType() + ", Card Number: " + card.getCardNumber() + ", Limit: " + card.getLimit());
        }

        for (CreditCard card : person_2.getCreditCards()) {
            System.out.println("Person: " + person_2.getName() + ", Card Type: " + card.getType() + ", Card Number: " + card.getCardNumber() + ", Limit: " + card.getLimit());
        }

        // Adding interest to everyAccount;
        InterestStrategy initialInterest = new PersonalAccountInterestStrategy();
        List<Person> people = new ArrayList<>();
        people.add(person_2);
        people.add(person_1);

        for (Person p : people) {
            for (Account a : p.getAccounts()) {
                if (p.getName() != "Tume") {
                    a.addInterest(initialInterest);
                    a.calculateInterest();
                }
            }
        }

        for (Person p : people) {
            for (Account a : p.getAccounts()) {
                System.out.println("Person: " + p.getName() + ", Balance after: " + a.getBalance());
            }
        }



    }
}
