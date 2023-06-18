package com.twa.flights.api.reservation.connector

import com.twa.flights.api.reservation.connector.configuration.EndpointConnectionConfiguration
import com.twa.flights.api.reservation.connector.configuration.HostConfiguration
import com.twa.flights.api.reservation.connector.configuration.HttpConnectorConfiguration
import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.http.client.HttpClient
import java.time.Duration
import java.util.concurrent.TimeUnit

abstract class TWAHttpConnector(
    private val hostName: String,
    private val httpConnectorConfiguration: HttpConnectorConfiguration,
) {

    protected val webClients: Map<String, WebClient> = httpConnectorConfiguration.hosts?.get(hostName)
        ?.let { generateWebClientsMap(it) }
        ?: throw RuntimeException("Couldn't find connector properties for $hostName")

    private fun generateWebClientsMap(hostConfiguration: HostConfiguration): Map<String, WebClient> =
        hostConfiguration.endpoints.entries
            .associate { Pair(it.key, generateWebClient(hostConfiguration, it.value)) }

    private fun generateWebClient(
        hostConfiguration: HostConfiguration,
        endpointConnectionConfig: EndpointConnectionConfiguration
    ): WebClient =
        buildWebClient(ReactorClientHttpConnector(buildHttpClient(endpointConnectionConfig)), hostConfiguration, endpointConnectionConfig)

    private fun buildHttpClient(
        endpointConnectionConfig: EndpointConnectionConfiguration
    ) =
        HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Math.toIntExact(endpointConnectionConfig.connectionTimeout))
            .responseTimeout(Duration.ofMillis(endpointConnectionConfig.responseTimeout))
            .doOnConnected { conn ->
                conn.addHandlerLast(
                    ReadTimeoutHandler(
                        endpointConnectionConfig.readTimeout,
                        TimeUnit.MILLISECONDS
                    )
                )
            }

    private fun buildWebClient(
        reactorClientHttpConnector: ReactorClientHttpConnector,
        hostConfiguration: HostConfiguration,
        endpointConnectionConfig: EndpointConnectionConfiguration
    ) =
        WebClient.builder()
            .baseUrl(
                hostConfiguration.host + ":" + hostConfiguration.port +
                    endpointConnectionConfig.path
            )
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .clientConnector(reactorClientHttpConnector)
            .build()
}
