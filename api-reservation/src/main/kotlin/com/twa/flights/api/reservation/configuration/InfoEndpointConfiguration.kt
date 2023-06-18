package com.twa.flights.api.reservation.configuration

import org.springframework.boot.actuate.info.InfoContributor
import org.springframework.boot.actuate.info.InfoEndpoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.yaml.snakeyaml.Yaml

@Configuration
class InfoEndpointConfiguration {

    private val APP_INFO_FILE = "app-info.yml"

    @Bean
    @SuppressWarnings("unchecked")
    @Suppress("unchecked_cast")
    fun infoEndpoint(): InfoEndpoint {
        val appInfo: Map<String, Any> = getInfoFromFile() as Map<String, Any>
        val ic = InfoContributor { it.withDetails(appInfo) }
        return InfoEndpoint(listOf(ic))
    }

    private fun getInfoFromFile() = Yaml().loadAs(
        this.javaClass.classLoader.getResourceAsStream(
            APP_INFO_FILE
        ),
        Map::class.java
    )
}
