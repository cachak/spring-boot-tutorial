package id.web.sahir.tutorial.springboot.data.jpa.multiple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication
public class SpringBootDataMultipleApplication {
	final static private Logger logger = LoggerFactory.getLogger(SpringBootDataMultipleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataMultipleApplication.class, args);
	}
}
