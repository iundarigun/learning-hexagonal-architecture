package br.com.devcave.hexagonal.mybank.adapter.out.persistence.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Version

@Entity(name = "Transfer")
data class TransferEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val transferAt: LocalDateTime,

    @ManyToOne(optional = false)
    val origin: AccountEntity,

    @ManyToOne(optional = false)
    val destination: AccountEntity,

    @Version
    val version: Long,

    @CreationTimestamp
    val createdAt: LocalDateTime,

    @UpdateTimestamp
    val updatedAt: LocalDateTime
)
