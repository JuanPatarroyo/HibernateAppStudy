/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jpatarroyo
 */
@Entity
public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer id;
    private String street;
    @Column(name = "number_street")
    private String numberStreet;
    private String country;

    public Address() {
    }

    public Address(Integer id, String street, String numberStreet, String country) {
        this.id = id;
        this.street = street;
        this.numberStreet = numberStreet;
        this.country = country;
    }

    public Address(String street, String numberStreet, String country) {
        this.street = street;
        this.numberStreet = numberStreet;
        this.country = country;
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(String numberStreet) {
        this.numberStreet = numberStreet;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street=" + street + ", numberStreet=" + numberStreet + ", country=" + country + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
