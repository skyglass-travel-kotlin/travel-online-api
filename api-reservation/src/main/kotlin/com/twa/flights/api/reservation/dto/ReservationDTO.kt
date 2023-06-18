package com.twa.flights.api.reservation.dto

import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class ReservationDTO(
    val id: Long?,

    @field:NotBlank(message = "The itinerary id must be defined")
    val itineraryId: String? = null,

    @field:NotBlank(message = "The search id must be defined")
    val searchId: String? = null,

    @field:Valid
    @field:NotEmpty(message = "The passengers must be defined")
    val passengers: List<PassengerDTO>?,

    @field:Valid
    @field:NotNull(message = "The contact must be defined")
    val contact: ContactDTO?
)
