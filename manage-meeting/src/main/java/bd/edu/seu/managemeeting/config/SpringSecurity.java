
package bd.edu.seu.managemeeting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       /* http.cors();
        http.csrf().disable().
                authorizeRequests()
                .antMatchers("/**").
                fullyAuthenticated()
                .and().httpBasic();*/
       http.csrf().disable().
                authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").
                permitAll().anyRequest()
                .authenticated()
                .and().httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set your configuration on the auth object
        auth.inMemoryAuthentication()
                .withUser("shakur")
                .password("{noop}1234")
                .roles("ADMIN");
    }




}
