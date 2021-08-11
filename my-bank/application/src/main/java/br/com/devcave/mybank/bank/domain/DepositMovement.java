package br.com.devcave.mybank.bank.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DepositMovement implements Movement {
    private final Long accountOriginId;
    private final Double amount;
}
