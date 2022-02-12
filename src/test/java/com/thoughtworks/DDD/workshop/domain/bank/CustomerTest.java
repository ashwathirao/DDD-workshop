package com.thoughtworks.DDD.workshop.domain.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldUpdateAddressForAllAccountsWhenCustomerAddressIsUpdated() {
        Account account = new Account(new Address("Pune"));
        Account account2 = new Account(new Address("Delhi"));
        Customer customer = new Customer(Arrays.asList(account, account2), new Address("Pune"));
        customer.updateAddress(new Address("Mumbai"));
        Assertions.assertEquals(customer.getAddress(), account.getAddress());
        Assertions.assertEquals(customer.getAddress(), account2.getAddress());
    }
}
