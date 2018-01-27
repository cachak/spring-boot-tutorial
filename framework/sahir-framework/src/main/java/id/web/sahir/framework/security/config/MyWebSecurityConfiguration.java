package id.web.sahir.framework.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
/*
        http
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/")
                //.logoutSuccessHandler(logoutSuccessHandler)
                .invalidateHttpSession(true)
                //.addLogoutHandler(logoutHandler)
                //.deleteCookies(cookieNamesToClear);
        ;
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
*/
        //super.configure(http);
        /*
        http
                .formLogin()
                .loginPage("/user/login")
                .usernameParameter("username")
                .passwordParameter("password").permitAll();
        //http.logout().logoutUrl("/user/logout");
        http.authorizeRequests()
                .antMatchers("/assets/**", "/user/login","/login","/user/logout","/logout", "/about").permitAll();
        super.configure(http);
        */
        /**
         * success
         */
/*
        http

                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/", true)
                .loginProcessingUrl("/user/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/user/login?logout")
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/webjars/**", "/assets/**", "/login","/signin/**","/signup").permitAll()
                .antMatchers("/user/login", "/logout").permitAll()
                .antMatchers("/agent/**", "/device/**","/user/**","/pension/**").hasRole("ADMIN")
                .anyRequest().authenticated();
*/
        http

                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/", true)
                .loginProcessingUrl("/user/login")
                .usernameParameter("username")
                .passwordParameter("password");
        http
                .logout()
                .logoutSuccessUrl("/user/login?logout");
        http
                .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/webjars/**", "/assets/**", "/login","/signin/**","/signup").permitAll()
                .antMatchers("/user/login", "/logout").permitAll()
                .antMatchers("/agent/**", "/device/**","/user/**","/pension/**").hasRole("ADMIN")
                .anyRequest().authenticated();






    }

}
