package com.aldekain.basicuserservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.aldekain.basicuserservice.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserService userService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userService).passwordEncoder(passwordEncoder);
		 //auth.inMemoryAuthentication()
         //.withUser("stanislav").password(passwordEncoder().encode("1234")).roles("USER");
      //  auth.authenticationProvider(authProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http
	.authorizeRequests()
	.antMatchers("/", "/user/register", "/bootstrap/**", "/jquery/**").permitAll()
   // .antMatchers("/users/**").hasRole("USER")
	.anyRequest().authenticated()
	
	.and()
	
	.formLogin().loginPage("/user/login").permitAll()
	.usernameParameter("username")
	.passwordParameter("password")
	
	.defaultSuccessUrl("/user/profile")
	
	//.failureUrl("/login?error")
	
	.failureUrl("/user/login?hasError=true")
	//.defaultSuccessUrl("")

	.and()
	.logout().logoutUrl("/user/logout").logoutSuccessUrl("/user/login?logout")

	/*.and()
	.rememberMe().rememberMeParameter("remember").key("remember Me Encryption Key")
	.rememberMeCookieName("rememberMeCookieName").tokenValiditySeconds(10000)*/
	
//	.and()
//	.exceptionHandling().accessDeniedPage("/unauthorized")
//	.requestMatcher(EndpointRequest.toAnyEndpoint()).authorizeRequests()
//	.anyRequest().hasRole("ENDPOINT_ADMIN")
//	.and()
//	.httpBasic()
	
	.and()
	.csrf().disable();
	}
	
//	   @Bean
//	    @Override
//	    public UserDetailsService userDetailsService() {
//	        UserDetails user =
//	             User.withDefaultPasswordEncoder()
//	                .username("user")
//	                .password("password")
//	                .roles("USER")
//	                .build();
//
//	        return new InMemoryUserDetailsManager(user);
//	    }

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public DaoAuthenticationProvider authProvider() {
//	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//	    authProvider.setUserDetailsService(userService);
//	    authProvider.setPasswordEncoder(passwordEncoder());
//	    return authProvider;
//	}
}
