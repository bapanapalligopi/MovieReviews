package com.greviews.MovieReviews.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/search")
                .allowedOrigins("https://bapanapalligopi.github.io/MovieReviewsFrontEnd/")
                .allowedOrigins("http://192.168.1.4:8081")// Allow requests from this origin
                .allowedMethods("GET", "POST");  // Allow GET and POST requests

    }
}
