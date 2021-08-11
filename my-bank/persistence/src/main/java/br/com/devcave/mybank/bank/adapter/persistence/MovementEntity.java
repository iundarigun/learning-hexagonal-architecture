package br.com.devcave.mybank.bank.adapter.persistence;

import br.com.devcave.mybank.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity(name = "Movement")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MovementEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Column(unique = true)
    private UUID identifier = UUID.randomUUID();

    @ManyToOne(optional = false)
    private AccountEntity origin;

    @ManyToOne(optional = true)
    private AccountEntity destination;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private MovementType movementType;
}

enum MovementType {
    TRANSFER,
    WITHDRAW,
    DEPOSIT
}
