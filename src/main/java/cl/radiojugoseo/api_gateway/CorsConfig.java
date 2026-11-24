
package cl.radiojugoseo.api_gateway;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration cors = new CorsConfiguration();

        // Direcciones permitidas para React en desarrollo
        cors.setAllowedOrigins(List.of(
                "http://localhost:5173",
                "http://127.0.0.1:5173"
        ));

        cors.setAllowedMethods(List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS"
        ));

        cors.setAllowedHeaders(List.of(
                "Authorization",
                "Content-Type"
        ));

        // Cache de las solicitudes de verificación CORS
        cors.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource fuente =
                new UrlBasedCorsConfigurationSource();

        fuente.registerCorsConfiguration("/api/**", cors);

        return new CorsFilter(fuente);
    }
}
