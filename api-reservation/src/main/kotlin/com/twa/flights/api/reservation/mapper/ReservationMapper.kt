package com.twa.flights.api.reservation.mapper

import com.twa.flights.api.reservation.dto.ContactDTO
import com.twa.flights.api.reservation.dto.DocumentDTO
import com.twa.flights.api.reservation.dto.PassengerDTO
import com.twa.flights.api.reservation.dto.ReservationDTO
import com.twa.flights.api.reservation.model.Contact
import com.twa.flights.api.reservation.model.Document
import com.twa.flights.api.reservation.model.Passenger
import com.twa.flights.api.reservation.model.Reservation

fun Reservation.toDTO(): ReservationDTO =
    ReservationDTO(id, itineraryId, "", passengers?.map { it.toDTO() }, contact?.toDTO())

fun Contact.toDTO(): ContactDTO =
    ContactDTO(id, telephone, email)

fun Passenger.toDTO(): PassengerDTO =
    PassengerDTO(id, gender, type, birth, nationality, firstName, lastName, document?.toDTO())

fun Document.toDTO(): DocumentDTO =
    DocumentDTO(id, number, type, expiration)

fun ReservationDTO.toModel(): Reservation =
    Reservation(id, itineraryId, passengers?.map { it.toModel() }, contact?.toModel())

fun ContactDTO.toModel(): Contact =
    Contact(id, telephone, email)

fun PassengerDTO.toModel(): Passenger =
    Passenger(id, gender, type, birth, nationality, firstName, lastName, document?.toModel())

fun DocumentDTO.toModel(): Document =
    Document(id, number, type, expiration)
