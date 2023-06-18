package com.twa.flights.api.reservation.enums

import org.springframework.http.HttpStatus

enum class APIError(
    val httpStatus: HttpStatus,
    val code: Int,
    val message: String
) {
    VALIDATION_ERROR(HttpStatus.BAD_REQUEST, 400_07_01, "The are attributes with wrong values"),
    BAD_FORMAT(HttpStatus.BAD_REQUEST, 400_07_02, "The message not have a correct form"),
    COUNTRY_NOT_FOUND(HttpStatus.BAD_REQUEST, 400_07_03, "Country not found"),
    CLUSTER_NOT_FOUND(HttpStatus.BAD_REQUEST, 400_07_04, "Cluster not found")
}
