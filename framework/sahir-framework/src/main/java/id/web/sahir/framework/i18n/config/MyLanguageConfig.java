package id.web.sahir.framework.i18n.config;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MyLanguageConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(MyLanguageConfig.class);
    @Value("${myindo.i18n.language:id-ID}")
    private String language;

    @Bean(name = "localeResolver")
    @Description("Language LocalResolver")
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        logger.trace("set default language to : " + this.language);
        Locale locale =  new Locale.Builder().setLanguageTag(this.language).build();
        localeResolver.setDefaultLocale(locale);
        return localeResolver;
        //return new SessionLocaleResolver();
    }

    @Bean(name = "localeChangeInterceptor")
    @Description("Language localeChangeInterceptor")
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new
                LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}
