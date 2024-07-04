package com.tv.docker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tarunvishwakarma81
 * Configures the WebMvcConfigurer for the application.
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * @author tarunvishwakarma81
     * Configures the Cross-Origin Resource Sharing (CORS) mappings for the application.
     * CORS allows the server to specify who can access its resources on a web page.
     *
     * @param registry the CORS registry to configure
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
    }
}
