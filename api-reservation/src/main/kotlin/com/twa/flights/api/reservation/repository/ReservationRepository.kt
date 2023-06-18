package com.twa.flights.api.reservation.repository

import com.twa.flights.api.reservation.model.Reservation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReservationRepository : CrudRepository<Reservation, Long>
