package br.com.devcave.mybank.bank.adapter.persistence;

import br.com.devcave.mybank.bank.domain.DepositMovement;
import br.com.devcave.mybank.bank.domain.TransferMovement;
import br.com.devcave.mybank.bank.domain.WithdrawMovement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
class DepositMovementConverter implements Converter<DepositMovement, MovementEntity> {
    @Override
    public MovementEntity convert(final DepositMovement depositMovement) {
        log.info("convert DepositMovement");
        return MovementEntity.builder()
                .origin(AccountEntity.builder().id(depositMovement.getAccountOriginId()).build())
                .movementType(MovementType.DEPOSIT)
                .amount(BigDecimal.valueOf(depositMovement.getAmount()))
                .build();
    }
}

@Slf4j
@Component
class WithdrawMovementConverter implements Converter<WithdrawMovement, MovementEntity> {
    @Override
    public MovementEntity convert(final WithdrawMovement withdrawMovement) {
        log.info("convert WithdrawMovement");
        return MovementEntity.builder()
                .origin(AccountEntity.builder().id(withdrawMovement.getAccountOriginId()).build())
                .amount(BigDecimal.valueOf(withdrawMovement.getAmount()))
                .movementType(MovementType.WITHDRAW)
                .build();
    }
}

@Slf4j
@Component
class TransferMovementConverter implements Converter<TransferMovement, MovementEntity> {
    @Override
    public MovementEntity convert(final TransferMovement transferMovement) {
        log.info("convert TransferMovement");
        return MovementEntity.builder()
                .origin(AccountEntity.builder().id(transferMovement.getAccountOriginId()).build())
                .destination(AccountEntity.builder().id(transferMovement.getAccountDestinationId()).build())
                .amount(BigDecimal.valueOf(transferMovement.getAmount()))
                .movementType(MovementType.TRANSFER)
                .build();
    }
}
