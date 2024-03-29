package com.spring.userdept.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	  registry.addRedirectViewController("/configuration/ui", "/swagger-resources/configuration/ui");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	    registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket userDptApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
		        .apis(RequestHandlerSelectors.any())
		        .paths(PathSelectors.any())
		        .build()
		        .apiInfo(metaInfo())
		        .useDefaultResponseMessages(false)
		        .globalResponseMessage(RequestMethod.GET, responseMessageForGET());
				
	}
//	@Bean
//    public LinkDiscoverers discoverers() {
//        List<LinkDiscoverer> plugins = new ArrayList<>();
//        plugins.add(new CollectionJsonLinkDiscoverer());
//        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
//
//    }
	
	private ApiInfo metaInfo() {
		return new ApiInfoBuilder() 
				.title("UserDpt API REST")
				.description("API REST de cadastro de usuários e departamentos.")
				.version("1.0")
				.contact(new Contact("Mauro Lúcio", "https://www.linkedin.com/in/mauro-l%C3%BAcio-pereira", "mauroslucios@gmail.com"))
				.license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
	}
	
	private List<ResponseMessage> responseMessageForGET()
	{
	    return new ArrayList<ResponseMessage>() {
	    	
			private static final long serialVersionUID = 1L;

			{
		        add(new ResponseMessageBuilder()
		            .code(500)
		            .message("500 message")
		            .responseModel(new ModelRef("Error"))
		            .build());
		        add(new ResponseMessageBuilder()
		            .code(403)
		            .message("Forbidden!")
		            .build());
	    	}
		};
	}

	
}
	