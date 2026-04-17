package com.example.my_project_system.config;

import org.springframework.web.filter.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
//    @Bean
//    public CorsFilter corsFilter(){
//        CorsConfiguration config=new CorsConfiguration();
//        config.addAllowedOrigin("http://localhost:8080");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source=
//                new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**",config);
//        return new CorsFilter(source);
//    }
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
