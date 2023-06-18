package com.twa.flights.api.reservation.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Contact(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    @Column(name = "telephone", nullable = false, length = 50)
    val telephone: String? = null,

    @Column(name = "email", nullable = false, length = 50)
    val email: String? = null
)
