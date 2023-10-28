package com.javaproject.emsbackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.applyPermitDefaultValues(); // This allows credentials by default

        configuration.addAllowedOrigin("http://localhost:4200"); // Replace with the origins you want to allow

        source.registerCorsConfiguration("/**", configuration);
        return new CorsFilter(source);
    }
}
