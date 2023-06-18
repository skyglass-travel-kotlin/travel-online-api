package com.twa.flights.api.reservation.connector.configuration

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(HttpConnectorConfiguration::class)
class TWAHttpConnectorConfiguration
