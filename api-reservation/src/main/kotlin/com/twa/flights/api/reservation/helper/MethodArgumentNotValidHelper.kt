package com.twa.flights.api.reservation.helper

import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import kotlin.reflect.full.superclasses

object MethodArgumentNotValidHelper {

    fun generateMessage(error: ObjectError): String {
        val isFieldError = error::class.superclasses.contains(FieldError::class)
        return if (isFieldError) {
            val fieldError = (error as FieldError)
            fieldError.defaultMessage?.format(fieldError.field) ?: "Field error"
        } else {
            error.defaultMessage ?: "Object error"
        }
    }
}
