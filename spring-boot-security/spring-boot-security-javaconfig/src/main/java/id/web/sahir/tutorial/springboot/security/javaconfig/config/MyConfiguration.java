package id.web.sahir.tutorial.springboot.security.javaconfig.config;

import id.web.sahir.framework.i18n.config.MyLanguageConfig;
import id.web.sahir.framework.security.config.MyWebSecurityConfig;
import id.web.sahir.framework.security.config.MyWebSecurityConfiguration;
import id.web.sahir.framework.session.config.MySessionRedisConfig;
import id.web.sahir.framework.themes.config.MyThymeleafConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(
        {
                MyThymeleafConfig.class,
                MyLanguageConfig.class,
                MySessionRedisConfig.class,
                MyWebSecurityConfig.class,
                MyWebSecurityConfiguration.class
        }
)
public class MyConfiguration {
}
