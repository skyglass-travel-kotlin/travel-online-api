package com.twa.flights.api.reservation.service

import com.twa.flights.api.reservation.connector.ClustersHttpConnector
import com.twa.flights.api.reservation.connector.request.ClusterRequest
import com.twa.flights.api.reservation.dto.ClusterDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class ClustersService(private val clustersHttpConnector: ClustersHttpConnector) {
    private val logger: Logger = LoggerFactory.getLogger(ClustersService::class.java)

    fun getCluster(request: ClusterRequest): ClusterDTO? {
        logger.debug("Obtain information of the clusters")
        return clustersHttpConnector.getCluster(request)
    }
}
