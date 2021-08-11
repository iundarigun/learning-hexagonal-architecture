package br.com.devcave.mybank.bank.adapter.persistence;

import br.com.devcave.mybank.bank.domain.Movement;
import br.com.devcave.mybank.bank.port.out.CreateMovementPort;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovementPersistence implements CreateMovementPort {

    private final ConversionService conversionService;
    private final MovementRepository movementRepository;

    @Override
    public String createMovement(Movement movement) {
        final MovementEntity movementEntity = conversionService.convert(movement, MovementEntity.class);
        if (movementEntity == null) {
            throw new UnsupportedOperationException();
        }
        return movementRepository.save(movementEntity).getIdentifier().toString();
    }

}

