package kls.auth.server.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Slf4j
public class DefaultServerConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.
                    authorizeRequests().
                    anyRequest().
                    authenticated().
                and().
                    formLogin(Customizer.withDefaults()).
                logout().
                    logoutUrl("/logout").
                    logoutSuccessUrl("/login")
        ;

        return http.build();
    }

    @Bean
    UserDetailsService users() {
        UserDetails user = User.
                withDefaultPasswordEncoder().
                username("admin").
                password("password").
                authorities("user").
                build();
        return new InMemoryUserDetailsManager(user);
    }

}
