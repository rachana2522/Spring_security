package com.cozentus.SpringSecurityDBApp.config;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@EnableMethodSecurity()

public class SecurityConfig {



	@Bean
public BCryptPasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

 

	@Bean
public UserDetailsService getDetailsService() {
		return new CustomStudentDetailsService();

	}

 

	@Bean
    public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setUserDetailsService(getDetailsService());

		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

		return daoAuthenticationProvider;

	}



	 @Bean

	 public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
http.csrf((csrf)->{csrf.disable();});
http.authorizeHttpRequests((authz) -> authz
		.requestMatchers("/admin").hasRole("ADMIN")
		.requestMatchers("/user").hasRole("USER")
          .anyRequest().authenticated()
);	
 http.httpBasic(withDefaults());
         return http.build();

	 }

 

 

}