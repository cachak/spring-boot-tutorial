package id.web.sahir.tutorial.springboot.themes.thymeleaf.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootThemesThymeleafBootstrapApplication {
	final static private Logger logger = LoggerFactory.getLogger(SpringBootThemesThymeleafBootstrapApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootThemesThymeleafBootstrapApplication.class, args);
	}
}
