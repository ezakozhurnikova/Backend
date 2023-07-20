package de.ait.products.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:application.properties")
@ComponentScan(basePackages = "de.aittr.springproducts")
public class ApplicationConfig {

}