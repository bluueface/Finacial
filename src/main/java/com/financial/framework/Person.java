package com.financial.framework;

import com.financial.framework.builder.PersonBuilder;

import java.util.Date;
import java.util.Objects;

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

    @Override
    public String getType() {
        return "Person";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return super.equals(o) && Objects.equals(dateOfBirth, person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth, getName());
    }
}
