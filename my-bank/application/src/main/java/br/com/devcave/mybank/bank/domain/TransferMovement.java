package br.com.devcave.mybank.bank.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TransferMovement implements Movement {
    private final Long accountOriginId;
    private final Long accountDestinationId;
    private final Double amount;
}
