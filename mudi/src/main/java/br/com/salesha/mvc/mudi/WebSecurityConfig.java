package br.com.salesha.mvc.mudi;

import javax.sql.DataSource;

import org.apache.catalina.startup.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl("/usuario/pedido", true) //redireciona após o login com sucesso
					.permitAll()
					)
			.logout(logout -> logout.logoutUrl("/logout")); // determina a funcionalidade logout
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // método de criptografia de senha
		/*
		//Adicionar usuário
		UserDetails user = User
				.builder()
				.username("")
				.password(encoder.encode(""))
				.roles("")
				.build();
		*/
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder); 
		//.whithUsers(user); //para adicionar o usuário criado anteriormente;
		
	}
	
 }
