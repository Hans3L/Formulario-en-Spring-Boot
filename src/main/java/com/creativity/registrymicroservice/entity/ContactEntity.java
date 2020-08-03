package com.creativity.registrymicroservice.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_CONTACT")
public class ContactEntity implements Serializable {

    private static final long serialVersionUID = -1604275592411471876L;

    @Id
    @GeneratedValue
    @Column(name = "ContactId")
    private int id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Telephone")
    private String telephone;

    @Column(name = "City")
    private String city;

    public ContactEntity() {
    }

    public ContactEntity(int id,String firstName,String lastName,String telephone,String city) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.telephone=telephone;
        this.city=city;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
