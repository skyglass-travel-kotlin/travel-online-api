package com.twa.flights.api.reservation.controller

import com.twa.flights.api.reservation.dto.ReservationDTO
import com.twa.flights.api.reservation.service.ReservationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class ReservationController(private val reservationService: ReservationService) {

    private val logger: Logger = LoggerFactory.getLogger(ReservationController::class.java)

    @GetMapping("/{id}")
    fun getReservationById(@PathVariable("id") id: Long):
        ResponseEntity<ReservationDTO> {
        logger.info("Obtain the reservation information")
        return ResponseEntity<ReservationDTO>(
            reservationService.getReservationById(id), HttpStatus.OK
        )
    }

    @PostMapping("/")
    fun saveReservation(@Valid @RequestBody reservation: ReservationDTO):
        ResponseEntity<ReservationDTO> {
        logger.info("Saving the reservation information")
        return ResponseEntity<ReservationDTO>(
            reservationService.saveReservation(reservation), HttpStatus.OK
        )
    }
}
