package com.twa.flights.api.reservation.connector.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.NestedConfigurationProperty

@ConstructorBinding
@ConfigurationProperties(prefix = "http-connector")
data class HttpConnectorConfiguration(
    @NestedConfigurationProperty
    val defaultConfig: DefaultConnectionConfiguration?,
    val hosts: Map<String, HostConfiguration>?,
)

data class HostConfiguration(
    val host: String,
    val port: Int,
    @NestedConfigurationProperty
    val defaultConfig: DefaultConnectionConfiguration?,
    val endpoints: Map<String, EndpointConnectionConfiguration>,
)

data class DefaultConnectionConfiguration(
    override val connectionTimeout: Long,
    override val readTimeout: Long,
    override val responseTimeout: Long,
) : ConnectionConfiguration

data class EndpointConnectionConfiguration(
    val path: String,
    override val connectionTimeout: Long,
    override val readTimeout: Long,
    override val responseTimeout: Long,
) : ConnectionConfiguration

interface ConnectionConfiguration {
    val connectionTimeout: Long
    val readTimeout: Long
    val responseTimeout: Long
}
