package com.thoughtworks.DDD.workshop.domain.bank;

import java.util.UUID;

public class Account {
    private final UUID accountNumber;
    private Address address;

    public Account(Address address) {
        this.accountNumber = UUID.randomUUID();
        this.address = address;
    }

    public void updateAddress(Address newAddress){
        this.address = newAddress;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
