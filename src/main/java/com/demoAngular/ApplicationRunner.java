package com.demoAngular;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.demoAngular.Filter.CORSFilter;
import com.demoAngular.Model.User;
import com.demoAngular.Repository.UserRepository;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {

	public static void main(String[] args) {		
		SpringApplication.run(ApplicationRunner.class, args);
		
	}
	
	@Bean
	public FilterRegistrationBean corsFilterRegistration()	{
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		userRepository.save(
				Arrays.asList(
						new User("11", "Mr. Nice"),
						new User("12", "Narco"),
						new User("13", "Bombasto"),
						new User("14", "Celeritas"),
						new User("15", "Magneta"),
						new User("16", "RubberMan"),
						new User("17", "Dynama"),
						new User("18", "Dr IQ"),
						new User("19", "Magma"),
						new User("20", "Tornado")
						)
				);
	}

}
