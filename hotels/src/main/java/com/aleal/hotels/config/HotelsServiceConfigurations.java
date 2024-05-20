package com.aleal.hotels.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Configuration
@ConfigurationProperties(prefix = "hotels")
public class HotelsServiceConfigurations {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}
