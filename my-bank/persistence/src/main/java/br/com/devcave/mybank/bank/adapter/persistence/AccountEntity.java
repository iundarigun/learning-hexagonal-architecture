package br.com.devcave.mybank.bank.adapter.persistence;

import br.com.devcave.mybank.customer.adapter.persistence.CustomerEntity;
import br.com.devcave.mybank.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Entity(name = "Account")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    private BigDecimal amount = BigDecimal.ZERO;

    @ManyToOne(optional = false)
    private CustomerEntity owner;

    @ManyToOne(optional = false)
    private BankEntity bank;
}
