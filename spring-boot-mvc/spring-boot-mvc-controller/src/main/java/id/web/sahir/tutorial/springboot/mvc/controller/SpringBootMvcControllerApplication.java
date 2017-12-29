package id.web.sahir.tutorial.springboot.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class SpringBootMvcControllerApplication {
	final static private Logger logger = LoggerFactory.getLogger(SpringBootMvcControllerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcControllerApplication.class, args);
	}
}
