package br.com.devcave.mybank.bank.port.out;

import br.com.devcave.mybank.bank.domain.Movement;

public interface CreateMovementPort {
    String createMovement(Movement movement);
}
