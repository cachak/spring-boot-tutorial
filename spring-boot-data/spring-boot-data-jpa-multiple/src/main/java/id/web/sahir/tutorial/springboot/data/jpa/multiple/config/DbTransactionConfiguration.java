package id.web.sahir.tutorial.springboot.data.jpa.multiple.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="transactionEntityManagerFactory",
        transactionManagerRef = "transactionTransactionManager",
        basePackages = {"id.web.sahir.tutorial.springboot.data.jpa.multiple.repository"}
)
public class DbTransactionConfiguration {
    final static private Logger logger = LoggerFactory.getLogger(DbTransactionConfiguration.class);

    @Autowired
    Environment environment;

    @Bean(name = "transactionDataSource")
    @ConfigurationProperties(prefix = "database.transaction.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "transactionEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean transactionEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("transactionDataSource") DataSource dataSource) {
        logger.info("start load entityManagerFactory");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =  builder.dataSource(dataSource)
                .packages("id.web.sahir.tutorial.springboot.data.jpa.multiple.transaction.domain")
                .persistenceUnit("transactionDataSource")
                .build();
        entityManagerFactoryBean.setPackagesToScan(
                new String[] {
                        "id.web.sahir.tutorial.springboot.data.jpa.multiple.transaction.domain"
                }
        );
        //entityManagerFactoryBean.setPackagesToScan({"id.web.sahir.tutorial.springboot.data.jpa.multiple.domain"});
        Properties jpaProperties = new Properties();

        //Configures the used database dialect. This allows Hibernate to create SQL
        //that is optimized for the used database.
        String prefixHibernate = "database.transaction.";
        if (environment.containsProperty(prefixHibernate + "hibernate.dialect")) {
            logger.info("dialect : " + environment.getProperty(prefixHibernate + "hibernate.dialect"));
            jpaProperties.put("hibernate.dialect", environment.getProperty(prefixHibernate + "hibernate.dialect"));
        }

        //Specifies the action that is invoked to the database when the Hibernate
        //SessionFactory is created or closed.
        if (environment.containsProperty(prefixHibernate + "hibernate.hbm2ddl.auto")) {
            logger.info("hbm2ddl.auto : " + environment.getProperty(prefixHibernate + "hibernate.hbm2ddl.auto"));
            jpaProperties.put("hibernate.hbm2ddl.auto", environment.getProperty(prefixHibernate + "hibernate.hbm2ddl.auto"));
        }

        //Configures the naming strategy that is used when Hibernate creates
        //new database objects and schema elements
        if (environment.containsProperty(prefixHibernate + "hibernate.ejb.naming_strategy")) {
            logger.info("ejb.naming_strategy : " + environment.getProperty(prefixHibernate + "hibernate.ejb.naming_strategy"));
            jpaProperties.put("hibernate.ejb.naming_strategy", environment.getProperty(prefixHibernate + "hibernate.ejb.naming_strategy"));
        }

        //If the value of this property is true, Hibernate writes all SQL
        //statements to the console.
        if (environment.containsProperty(prefixHibernate + "hibernate.show_sql")) {
            logger.info("show_sql : " + environment.getProperty(prefixHibernate + "hibernate.show_sql"));
            jpaProperties.put("hibernate.show_sql", environment.getProperty(prefixHibernate + "hibernate.show_sql"));
        }


        //If the value of this property is true, Hibernate will format the SQL
        //that is written to the console.
        if (environment.containsProperty(prefixHibernate + "hibernate.format_sql")) {
            logger.info("format sql : " + environment.getProperty(prefixHibernate + "hibernate.format_sql"));
            jpaProperties.put("hibernate.format_sql", environment.getProperty(prefixHibernate + "hibernate.format_sql"));
        }
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
        logger.info("finished load entityManagerFactory");

        return entityManagerFactoryBean;
    }

    @Bean(name = "transactionTransactionManager")
    public PlatformTransactionManager transactionTransactionManager(@Qualifier("transactionEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
