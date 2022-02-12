package com.thoughtworks.DDD.workshop.domain.bank;

import java.util.List;
import java.util.UUID;

public class Customer {
    private final List<Account> accounts;
    private final UUID customerID;
    private Address address;

    public Customer(List<Account> accounts, Address address) {
        this.customerID = UUID.randomUUID();
        this.accounts = accounts;
        this.address = address;
    }

    public void addAccount(Account newAccount)
    {
        accounts.add(newAccount);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void updateAddress(Address newAddress){
        accounts.forEach(account -> account.updateAddress(newAddress));
        this.address = newAddress;
    }

    public Address getAddress() {
        return address;
    }
}
