package com.twa.flights.api.reservation.model

import com.twa.flights.api.reservation.enums.DocumentType
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Document(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    @Column(name = "number", nullable = false, length = 20)
    val number: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    val type: DocumentType? = null,

    @Column(name = "expiration", nullable = false)
    val expiration: LocalDate? = null
)
