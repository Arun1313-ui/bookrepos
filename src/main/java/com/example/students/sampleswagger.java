package com.example.students;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@SuppressWarnings("deprecation")
@EnableSwagger2
@Configuration
@EnableWebMvc
public class sampleswagger extends WebMvcConfigurerAdapter {
	@Bean
	public Docket api()    //docket-->interface of swagger and spring mvc
	{
		return new Docket (DocumentationType.SWAGGER_2)
       .select()
       .apis(RequestHandlerSelectors.any())
       .paths(PathSelectors.any())
       .build();
		
	}
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
}
