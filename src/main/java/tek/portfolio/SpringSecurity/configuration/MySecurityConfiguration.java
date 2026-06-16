package tek.portfolio.SpringSecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/admin/deleteService/**", "/admin/deleteContactById/**").hasRole("ADMIN")
		.antMatchers("/admin/**").hasAnyRole("ADMIN","MEMBER")
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/client/mylogin")
		.loginProcessingUrl("/doLogin")
		.usernameParameter("user")
		.passwordParameter("pass")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/client/unauthorized")
		;
		return http.build();
	}
	
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//	    http
//	    .authorizeRequests()
//	    .antMatchers("/admin/deleteService/**", "/admin/deleteContactById/**").hasRole("ADMIN")
//	    .antMatchers("/admin/**").hasAnyRole("ADMIN","MEMBER")
//	    .anyRequest().permitAll()
//
//	    .and()
//
//	    .formLogin()
//	    .loginPage("/client/mylogin")
//	    .loginProcessingUrl("/doLogin")
//	    .usernameParameter("user")
//	    .passwordParameter("pass")
//
//	    .successHandler((request, response, authentication) -> {
//
//	        boolean isAdminOrMember = authentication.getAuthorities()
//	                .stream()
//	                .anyMatch(a ->
//	                        a.getAuthority().equals("ROLE_ADMIN") ||
//	                        a.getAuthority().equals("ROLE_MEMBER"));
//
//	        if (isAdminOrMember) {
//
//	            response.sendRedirect(request.getContextPath() + "/admin/home");
//
//	        } else {
//
//	            response.sendRedirect(request.getContextPath() + "/client/home");
//	        }
//
//	    })
//
//	    .and()
//
//	    .exceptionHandling()
//	    .accessDeniedPage("/client/unauthorized");
//
//	    return http.build();
//	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
