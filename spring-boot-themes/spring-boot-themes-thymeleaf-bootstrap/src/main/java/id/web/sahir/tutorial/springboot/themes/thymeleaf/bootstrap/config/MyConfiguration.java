package id.web.sahir.tutorial.springboot.themes.thymeleaf.bootstrap.config;

import id.web.sahir.framework.i18n.config.MyLanguageConfig;
import id.web.sahir.framework.session.config.MySessionRedisConfig;
import id.web.sahir.framework.themes.config.MyThymeleafConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                MyThymeleafConfig.class,
                MyLanguageConfig.class,
                MySessionRedisConfig.class
        }
)
public class MyConfiguration {
}
