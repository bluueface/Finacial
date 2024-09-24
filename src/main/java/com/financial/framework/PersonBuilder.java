package com.financial.framework;

import java.util.Date;

public class PersonBuilder extends Builder {
    private Date dateOfBirth;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public PersonBuilder setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }
}
