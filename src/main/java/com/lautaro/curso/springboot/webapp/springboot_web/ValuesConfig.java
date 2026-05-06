package com.lautaro.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:values.properties"),
	//@PropertySource("classpath:values2.properties")
})
public class ValuesConfig {

}
