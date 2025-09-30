package com.finance.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        // Allow credentials (e.g., cookies, authorization headers)
        config.setAllowCredentials(true);

        // Specify allowed origins (configurable for flexibility)
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:3000", // Development
                "https://your-production-domain.com" // Add production domain
        ));

        // Allow specific headers or use wildcard for simplicity
        config.setAllowedHeaders(Arrays.asList(
                "Authorization",
                "Content-Type",
                "Accept",
                "X-Requested-With",
                "Cache-Control"
        ));

        // Explicitly specify allowed HTTP methods
        config.setAllowedMethods(Arrays.asList(
                "GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"
        ));

        // Set max age for CORS preflight cache (e.g., 1 hour)
        config.setMaxAge(3600L);

        // Apply CORS configuration to all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

//        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//        bean.setFilter(-110);
        return  source;
    }
}