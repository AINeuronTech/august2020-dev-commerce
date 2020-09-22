package com.aint.commerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Person {

    @Id
    int personId;
    String personName;
    String personPhoneNumber;
    @OneToMany(mappedBy = "person")
    public List<Product> products;

    public Person(){}
    public Person(int personId, String personName, String personPhoneNumber) {
        this.personId = personId;
        this.personName = personName;
        this.personPhoneNumber = personPhoneNumber;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }



}
