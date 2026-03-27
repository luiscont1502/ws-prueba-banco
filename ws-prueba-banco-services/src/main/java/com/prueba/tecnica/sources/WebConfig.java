package com.prueba.tecnica.sources;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

@Log4j2
public class WebConfig implements WebMvcConfigurer {
}
