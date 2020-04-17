package com.luv2code.springdemo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
//ref: https://howtodoinjava.com/swagger2/swagger-spring-mvc-rest-example/

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration extends WebMvcConfigurerAdapter 
{
	/**
    @Bean
    public Docket api() {
        // @formatter:off
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2).select()
                // .apis(RequestHandlerSelectors.any())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.luv2code.springdemo")))
                //.paths(regex("/api.*"))
                .paths(PathSelectors.any())
                .paths(PathSelectors.ant("/spring-rest-demo"))
                .build();
        // @formatter:on
    }**/
	
	   @Bean
	   public Docket customImplementation(){
	      return new Docket(DocumentationType.SWAGGER_2)
	    	  .apiInfo(getApiInfo())	  
	    	  .select()
	          .apis(RequestHandlerSelectors.basePackage("com.luv2code.springdemo"))
	          .paths(PathSelectors.any())
	          .build();
	   }
	   
	   private ApiInfo getApiInfo() {
		   return new ApiInfo("REST Api Documentation",
		      "REST Api Documentation", 
		      "1.0", 
		      "urn:tos",
		       new Contact("", "", ""), 
	              "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
	              new ArrayList<VendorExtension>());
	   }
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        //enabling swagger-ui part for visual documentation
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}