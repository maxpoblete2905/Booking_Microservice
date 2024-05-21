package com.aleal.reservations.config;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Configuration
@ConfigurationProperties(prefix = "reservations")
public class ReservationsConfigurations {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
}
