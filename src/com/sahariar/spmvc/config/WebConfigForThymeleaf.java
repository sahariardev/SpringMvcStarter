package com.sahariar.spmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;



@Configuration
@EnableWebMvc
@ComponentScan("com.sahariar.spmvc.config")
public class WebConfigForThymeleaf extends WebMvcConfigurerAdapter {
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		super.configureDefaultServletHandling(configurer);
		configurer.enable();
	}
	//there beans needed for the configuration
	//1.ViewResolver
	
	//Here the parameter was  TemplateEngine but it gives erros and SpringTemplateEngine works
	//fine.
	
	@Bean
	public ViewResolver viewResolver(SpringTemplateEngine templateEngine)
	{
		ThymeleafViewResolver viewResolver= new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		return viewResolver;
	}
	
	
	//2. TemplateEngine to set the template Resolver
	@Bean
	public SpringTemplateEngine springTemplateEngine(TemplateResolver templateResolver)
	{
		SpringTemplateEngine templateEngine=new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		return templateEngine;
	}
    
	//3 TemplateResolver to set the prefix and suffix
	@Bean
	public TemplateResolver templateResolver()
	{
		TemplateResolver templateResolver=new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		
		return templateResolver;
	}
	
	
}
