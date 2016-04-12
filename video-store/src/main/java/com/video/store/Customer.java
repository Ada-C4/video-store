package com.video.store;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name, registeredAt, address, city, state, postalCode, phone;
    private Float accountCredit;
    
    protected Customer() {}

    public Customer(String name, String registeredAt, String address, String city, String state, String postalCode, String phone, Float accountCredit) {
        this.name = name;
        this.registeredAt = registeredAt;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.phone = phone;
        this.accountCredit = accountCredit;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', accountCredit='%s']",
                id, name, accountCredit);
    }

    public String getName() {
        return name;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public String getCity() {
    	return city;
    }
    
    public String getState() {
    	return state;
    }
    
    public String getPostalCode() {
    	return postalCode;
    }
    
    public String getPhone() {
    	return phone;
    }
    
    public Float getAccountCredit() {
    	return accountCredit;
    }

}
