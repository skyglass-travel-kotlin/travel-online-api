package com.twa.flights.api.reservation.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class ContactDTO(
    val id: Long? = null,

    @field:NotBlank(message = "The telephone must be defined")
    val telephone: String?,

    @field:NotBlank(message = "The email must be defined")
    @field:Email(message = "The value must be a valid email")
    val email: String?
)
