package com.sahariar.spmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan("com.sahariar.spmvc.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}
	
	@Bean
	public ViewResolver viewResolver()
	{
		System.out.println("Here on Resolver");
		InternalResourceViewResolver iv=new InternalResourceViewResolver();
		iv.setPrefix("/WEB-INF/views/");
		iv.setSuffix(".jsp");
		iv.setExposeContextBeansAsAttributes(true);
		return iv;
	}

	
	
}
