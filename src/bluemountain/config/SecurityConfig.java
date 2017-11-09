package bluemountain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

/**
 * Created by MainasuK on 2017-3-5.
 */
@Configuration
@EnableWebMvcSecurity
    public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "SELECT username, password, enabled FROM users WHERE username = ?"
                ).authoritiesByUsernameQuery(
                        "SELECT username, role FROM user_roles WHERE username = ?"
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true);

        http.addFilterBefore(characterEncodingFilter, CsrfFilter.class)
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                .and()
                    .exceptionHandling().accessDeniedPage("/403")
                .and()
                    .authorizeRequests()
                    .antMatchers("/root/**").hasRole("ROOT")
                    .antMatchers("/doctor/**").hasRole("DOCTOR")
                    .antMatchers("/patient/**").hasRole("USER")
                    .antMatchers(HttpMethod.POST, "/").authenticated()
                    .anyRequest().permitAll();
    }

}
