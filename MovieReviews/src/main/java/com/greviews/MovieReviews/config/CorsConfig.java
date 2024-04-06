package com.greviews.MovieReviews.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/search")
                .allowedOrigins("http://localhost:5173")  // Allow requests from this origin
                .allowedMethods("GET", "POST");  // Allow GET and POST requests

    }
}
