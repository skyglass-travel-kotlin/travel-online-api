package com.twa.flights.api.reservation.dto

class ErrorDTO(
    val code: Int,
    val shortDescription: String,
    val reasons: List<String?>
)
