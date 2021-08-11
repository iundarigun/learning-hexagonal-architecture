package br.com.devcave.mybank.bank.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Bank {
    private final Long id;
    private final String name;
    private final String iban;

    public static Bank newBank(final String name, final String iban) {
        return new Bank(null, name, iban);
    }

    public static Bank getBank(final Long id, final String name, final String iban) {
        return new Bank(id, name, iban);
    }
}
