package com.agroassint.Agroassint.CORS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // permite todas las rutas
                        .allowedOrigins("http://localhost:4200") // origen del frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // métodos permitidos
                        .allowedHeaders("*") // permite todos los headers
                        .allowCredentials(true); // permite el envío de cookies (si usas sesiones o tokens)
            }
        };
    }
}