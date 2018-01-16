package id.web.sahir.framework.themes.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
public class MyThymeleafConfig implements WebMvcConfigurer,ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(MyThymeleafConfig.class);
    @Value("${myindo.thymeleaf.themes:myindo}")
    private String themes;
    @Value("${myindo.thymeleaf.skin:default}")
    private String skin;

    private ApplicationContext applicationContext;

    public MyThymeleafConfig() {
        super();
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean(name ="templateResolver")
    @Description("Thymeleaf Template Resolver")
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        String prefix = "classpath:/templates/" + themes + "/templates/";
        //String prefix = "/WEB-INF/templates/" + themes + "/templates/";
        logger.info("themes : " + themes +  " with skin : " + skin + " with prefix : " + prefix);
        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode("HTML");

        return templateResolver;
    }

    @Bean(name ="templateEngine")
    @Description("Thymeleaf Template Engine")
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new LayoutDialect(new GroupingStrategy()));
        templateEngine.setTemplateEngineMessageSource(messageSource());
        return templateEngine;
    }

    @Bean(name = "viewResolver")
    @Description("Thymeleaf View Resolver")
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Bean(name = "messageSource")
    @Description("Spring Message Resolver")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/messages");
        return messageSource;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/css/**").addResourceLocations("/assets/css/");
        registry.addResourceHandler("/assets/images/**").addResourceLocations("/assets/image/");
        registry.addResourceHandler("/assets/js/**").addResourceLocations("/assets/js/");

        //skin
        registry.addResourceHandler("/assets/"+ themes + "/css/**").addResourceLocations("classpath:/templates/" + themes + "/css/");
        registry.addResourceHandler("/assets/"+ themes + "/images/**").addResourceLocations("classpath:/templates/" + themes + "/image/");
        registry.addResourceHandler("/assets/"+ themes + "/img/**").addResourceLocations("classpath:/templates/" + themes + "/img/");
        registry.addResourceHandler("/assets/"+ themes + "/js/**").addResourceLocations("classpath:/templates/" + themes + "/js/");
        registry.addResourceHandler("/assets/"+ themes + "/components/**").addResourceLocations("classpath:/templates/" + themes + "/components/");

        registry.addResourceHandler("/assets/"+ themes + "/skin/" + skin + "/css/**").addResourceLocations("classpath:/templates/" + themes + "/skin/" + skin + "/css/");
        registry.addResourceHandler("/assets/"+ themes + "/skin/" + skin + "/images/**").addResourceLocations("classpath:/templates/" + themes + "/skin/" + skin + "/image/");
        registry.addResourceHandler("/assets/"+ themes + "/skin/" + skin + "/js/**").addResourceLocations("classpath:/templates/" + themes + "/skin/" + skin + "/js/");

        if (!skin.equals("default")) {
            registry.addResourceHandler("/assets/"+ themes + "/skin/" + "default" + "/css/**").addResourceLocations("classpath:/templates/" + themes + "/skin/" + "default" + "/css/");
            registry.addResourceHandler("/assets/"+ themes + "/skin/" + "default" + "/images/**").addResourceLocations("classpath:/templates/" + themes + "/skin/" + "default" + "/image/");
            registry.addResourceHandler("/assets/"+ themes + "/skin/" + "default" + "/js/**").addResourceLocations("classpath:/templates/" + themes + "/skin/" + "default" + "/js/");

        }

    }

}
