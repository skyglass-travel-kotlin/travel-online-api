package com.twa.flights.api.reservation.service

import com.twa.flights.api.reservation.connector.CatalogHttpConnector
import com.twa.flights.api.reservation.dto.CountryDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CatalogService(private val catalogHttpConnector: CatalogHttpConnector) {
    private val logger: Logger = LoggerFactory.getLogger(CatalogService::class.java)

    fun getCountry(nationality: String): CountryDTO? {
        logger.debug("Obtain information from the catalog")
        return catalogHttpConnector.getCountry(nationality)
    }
}
