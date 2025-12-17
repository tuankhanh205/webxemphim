package org.example.bephim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true); // Cho phép gửi cookie/token
        config.setAllowedOrigins(List.of("http://localhost:5173")); // FE
        config.setAllowedHeaders(List.of("*")); // Cho phép mọi header
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Cho phép các phương thức
        config.setExposedHeaders(List.of("Authorization")); // Nếu muốn FE đọc được

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Áp dụng cho mọi URL

        return new CorsFilter(source);
    }
}
