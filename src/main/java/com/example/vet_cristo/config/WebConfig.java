package com.example.vet_cristo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
       //Redirige cualquier ruta que no contenga un punto a `index.html`
        registry.addViewController("/{spring:[\\w\\-]+}")
                .setViewName("forward:/");*/
       //registry.addViewController("/**/{spring:[\\w\\-]+}")
         //      .setViewName("forward:/");
    //}
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/{spring:[\\w\\-]+}")
                .setViewName("forward:/");
        registry.addViewController("/**/{spring:[\\w\\-]+}")
                .setViewName("forward:/");
    }
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://6b9d-181-115-214-197.ngrok-free.app")  //("http://localhost:3000") // Permite solicitudes desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
