package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
//		registry.viewResolver(new InternalResourceViewResolver());
		WebMvcConfigurer.super.configureViewResolvers(registry);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		WebMvcConfigurer.super.addViewControllers(registry);
		registry.addRedirectViewController("/", "index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/", "classpath:/");
	}
		
}
