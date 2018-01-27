package id.web.sahir.tutorial.springboot.security.javaconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SpringBootSecurityJavaConfigApplication {
	final static private Logger logger = LoggerFactory.getLogger(SpringBootSecurityJavaConfigApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityJavaConfigApplication.class, args);
	}
}
