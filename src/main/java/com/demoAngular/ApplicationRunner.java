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
		
		User user11 = new User();
		user11.setId("11");
		user11.setName("Mr. Nice");
		
		User user12 =  new User();
		user12.setId("12");
		user12.setName("Narco");
		
		User user13 =  new User();
		user13.setId("13");
		user13.setName("Bombasto");
		
		User user14 =  new User();
		user14.setId("14");
		user14.setName("Celeritas");
		
		User user15 =  new User();
		user15.setId("15");
		user15.setName("Magneta");
		
		User user16 =  new User();
		user16.setId("16");
		user16.setName("RubberMan");
		
		User user17 =  new User();
		user17.setId("17");
		user17.setName("Dynama");
		
		User user18 =  new User();
		user18.setId("18");
		user18.setName("Dr IQ");
		
		User user19 =  new User();
		user19.setId("19");
		user19.setName("Magma");
		
		User user20 =  new User();
		user20.setId("20");
		user20.setName("Tornado");
		
		userRepository.deleteAll();
		userRepository.save(
				Arrays.asList(
						user11, user12, user13, user14, user15,
						user16, user17, user18, user19, user20
						)
				);
	}

}
