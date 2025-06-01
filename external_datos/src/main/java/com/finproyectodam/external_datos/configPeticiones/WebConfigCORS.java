package com.finproyectodam.external_datos.configPeticiones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Clase de configuración que permite peticiones HTTP externas (CORS) al backend.
 * Necesaria para permitir que el frontend JS/React se comunique con la API REST.
 * @author cristian && Joel
 * version 1.0
 */

@Configuration
public class WebConfigCORS {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Aplica a todos los endpoints
                        .allowedOrigins("*") // Permite todas las URLs externas. Puedes especificar: "http://localhost:3000"
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
