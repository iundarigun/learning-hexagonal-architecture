package br.com.devcave.mybank.entity;

import br.com.devcave.mybank.bank.domain.LockedEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LockedEntityImpl<T> implements LockedEntity<T> {
    private final T entity;
    private final Long version;
}
