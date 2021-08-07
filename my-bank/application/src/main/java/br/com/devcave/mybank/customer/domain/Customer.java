package br.com.devcave.mybank.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Customer {
    private final Long id;
    private final String name;
    private final String document;

    public static Customer newCustomer(final String name, final String document) {
        return new Customer(null, name, document);
    }

    public static Customer getCustomer(final Long id, final String name, final String document){
        return new Customer(id, name, document);
    }
}
