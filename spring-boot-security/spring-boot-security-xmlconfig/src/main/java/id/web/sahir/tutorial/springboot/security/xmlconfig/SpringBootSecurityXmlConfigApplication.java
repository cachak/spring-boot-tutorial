package id.web.sahir.tutorial.springboot.security.xmlconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class SpringBootSecurityXmlConfigApplication {
	final static private Logger logger = LoggerFactory.getLogger(SpringBootSecurityXmlConfigApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityXmlConfigApplication.class, args);
	}
}
