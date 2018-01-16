package id.web.sahir.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootFrameworkSahirFrameworkApplication {
	final static private Logger logger = LoggerFactory.getLogger(SpringBootFrameworkSahirFrameworkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFrameworkSahirFrameworkApplication.class, args);
	}
}
