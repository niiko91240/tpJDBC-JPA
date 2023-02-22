package org.epsic1.tpJPA;

import javax.persistence.*;
import java.util.Set;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "number", length = 50, nullable = false, unique = false)
    private String number;

    @Column(name = "street", length = 50, nullable = false, unique = false)
    private String street;

    @Column(name = "zipCode", length = 50, nullable = false, unique = false)
    private String zipCode;

    @Column(name = "city", length = 50, nullable = false, unique = false)
    private String city;






    public Address(){

    }

    public String getNumber() {
        return number;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
