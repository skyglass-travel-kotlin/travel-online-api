package com.twa.flights.api.reservation.connector

import com.twa.flights.api.reservation.connector.configuration.HttpConnectorConfiguration
import com.twa.flights.api.reservation.connector.request.ClusterRequest
import com.twa.flights.api.reservation.dto.ClusterDTO
import com.twa.flights.api.reservation.dto.ErrorDTO
import com.twa.flights.api.reservation.enums.APIError
import com.twa.flights.api.reservation.exception.ApiException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.codec.DecodingException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ClustersHttpConnector @Autowired constructor(
    httpConnectorConfiguration: HttpConnectorConfiguration,
) : TWAHttpConnector("api-clusters", httpConnectorConfiguration) {

    private val logger: Logger = LoggerFactory.getLogger(ClustersHttpConnector::class.java)

    fun getCluster(request: ClusterRequest): ClusterDTO? {
        logger.info("Calling clusters...")
        try {
            return webClients["clusters-by-id"]?.let {
                it.get()
                    .uri { uriBuilder ->
                        uriBuilder.build(request.id, request.itineraryId)
                    }
                    .retrieve()
                    .onStatus(HttpStatus::is4xxClientError) { _ ->
                        Mono.error(ApiException(APIError.CLUSTER_NOT_FOUND.httpStatus, ErrorDTO(APIError.CLUSTER_NOT_FOUND.code, APIError.CLUSTER_NOT_FOUND.message, emptyList())))
                    }
                    .bodyToMono(ClusterDTO::class.java)
                    .share()
                    .block()
            }
        } catch (ex: DecodingException) {
            logger.error("Error mapping. ${ex.message}")
            throw ApiException(APIError.BAD_FORMAT.httpStatus, ErrorDTO(APIError.BAD_FORMAT.code, APIError.BAD_FORMAT.message, emptyList()))
        }
    }
}
