package net.ddns.eeitdemo.eeit106team01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("controller")
public class SpringMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.viewResolver(thymeleafViewResolver());
		registry.viewResolver(new InternalResourceViewResolver());
//		registry.viewResolver(new BeanNameViewResolver());
//		WebMvcConfigurer.super.configureViewResolvers(registry);
	}



	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/test").setViewName("test");
		registry.addViewController("/index").setViewName("index");
		registry.addRedirectViewController("/", "index");
//		registry.addRedirectViewController("/test","/test.html");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/", "classpath:/");
	}
	
//	@Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
//        return templateEngine;
//    }
//	
//	@Bean
//    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
//        SpringResourceTemplateResolver templateResolver 
//          = new SpringResourceTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        return templateResolver;
//    }
//	
//	@Bean
//	public ThymeleafViewResolver thymeleafViewResolver() {
//	    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	    viewResolver.setTemplateEngine(templateEngine());
//	    return viewResolver;
//	}
	
}
