package com.financial.banking;


import com.financial.framework.PersonBuilder;

import java.util.Date;

public class Person extends Customer {
    private Date dateOfBirth;

    public Person(PersonBuilder builder) {
        super(builder);
        dateOfBirth = builder.getDateOfBirth();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
