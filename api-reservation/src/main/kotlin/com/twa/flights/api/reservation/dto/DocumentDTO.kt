package com.twa.flights.api.reservation.dto

import com.twa.flights.api.reservation.enums.DocumentType
import java.time.LocalDate
import javax.validation.constraints.Future
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class DocumentDTO(
    val id: Long? = null,

    @field:NotBlank(message = "The number must be defined")
    val number: String?,

    @field:NotNull(message = "The type must be defined")
    val type: DocumentType?,

    @field:Future(message = "The expiration must be a future date")
    @field:NotNull(message = "The expiration must be defined")
    val expiration: LocalDate?
)
