package com.qa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.qa.util.Constants;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	public WebConfig() {
        super();
    }

	
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.js/**").addResourceLocations("/ui/static/");
        registry.addResourceHandler("/*.css/**").addResourceLocations("/ui/static/");
    }
    
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        
        registry.addViewController(Constants.LOGIN_URL);
        registry.addViewController(Constants.REGISTER_URL);
        registry.addViewController(Constants.HOMEPAGE_URL);
       
        registry.addViewController(Constants.TRAININGMANAGER_ADMINPAGE_URL);
        registry.addViewController(Constants.TRAININGMANAGER_CV_URL);
        registry.addViewController(Constants.TRAININGMANAGER_TRAINEES_EDITTRAINEES_URL);
        registry.addViewController(Constants.TRAININGMANAGER_TRAINEES_ADDTRAINEES_URL);
        registry.addViewController(Constants.TRAININGMANAGER_TRAINEES_VIEWTRAINEES_URL);
        registry.addViewController(Constants.TRAININGMANAGER_TRAINERS_EDITTRAINERS_URL);
        registry.addViewController(Constants.TRAININGMANAGER_TRAINERS_ADDTRAINERS_URL);
        registry.addViewController(Constants.TRAININGMANAGER_TRAINERS_VIEWTRAINERS_URL);
        
        registry.addViewController(Constants.TRAINER_CV_URL);
        registry.addViewController(Constants.TRAINER_VIEWTRAINEES_URL);
        registry.addViewController(Constants.TRAINER_TRAINERPAGE_URL);
        
        registry.addViewController(Constants.TRAINEE_ACCOUNT_URL);
        registry.addViewController(Constants.TRAINEE_CV_ADDCVS_URL);  
        registry.addViewController(Constants.TRAINEE_CV_VIEWCVS_URL);  
        
        registry.addViewController(Constants.ACCESS_DENIED_URL);
    }
    
    @Bean
    public InternalResourceViewResolver setupViewResolver()  {
        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
        resolver.setPrefix ("/ui/jsp/");
        resolver.setSuffix (".jsp");
        resolver.setViewClass (JstlView.class);
        return resolver;
    }
    
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(Constants.JDBC_DRIVER_NAME);
        driverManagerDataSource.setUrl(Constants.JDBC_URL);
        driverManagerDataSource.setUsername(Constants.JDBC_USERNAME);
        driverManagerDataSource.setPassword(Constants.JDBC_PASSWORD);
        return driverManagerDataSource;
    }
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
