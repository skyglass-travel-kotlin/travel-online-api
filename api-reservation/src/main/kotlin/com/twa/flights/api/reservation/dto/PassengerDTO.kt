package com.twa.flights.api.reservation.dto

import com.twa.flights.api.reservation.enums.Gender
import com.twa.flights.api.reservation.enums.PassengerType
import org.springframework.validation.annotation.Validated
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@Validated
data class PassengerDTO(
    val id: Long? = null,

    @field:NotNull(message = "The gender must be defined")
    val gender: Gender?,

    @field:NotNull(message = "The passenger type must be defined")
    val type: PassengerType?,

    @field:Past(message = "The birth need to be in the past")
    @field:NotNull(message = "The birth must be defined")
    val birth: LocalDate?,

    @field:NotBlank(message = "The nationality must be defined")
    @field:Size(min = 2, max = 3, message = "The nationality not have the correct size")
    val nationality: String?,

    @field:NotBlank(message = "The firstname must be defined")
    @field:Size(min = 2, max = 20, message = "The firstname not have the correct size")
    val firstName: String?,

    @field:NotBlank(message = "The lastname must be defined")
    @field:Size(min = 2, max = 20, message = "The lastName not have the correct size")
    val lastName: String?,

    @field:Valid
    @field:NotNull(message = "The document must be defined")
    val document: DocumentDTO?
)
