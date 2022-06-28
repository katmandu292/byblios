package ro.dcatalin.byblios.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	// add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/resources/**").permitAll()
			.antMatchers("/customer/showForm*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/customer/save*").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers("/customer/delete").hasRole("ADMIN")
			.antMatchers("/lib/newEditor*").hasRole("ADMIN")
			.antMatchers("/lib/delEditor*").hasRole("ADMIN")
			.antMatchers("/lib/delAuthor*").hasRole("ADMIN")
			.antMatchers("/book/listCollections*").hasRole("ADMIN")
			.antMatchers("/book/delBook*").hasRole("ADMIN")
			.antMatchers("/book/delBookCollection*").hasRole("ADMIN")
			.antMatchers("/lib/delNovelType*").hasRole("ADMIN")
			.antMatchers("/lib/updateNovelType*").hasRole("ADMIN")
			.antMatchers("/lib/savNovelType*").hasRole("ADMIN")
			.antMatchers("/lib/savEditor*").hasRole("ADMIN")
			.antMatchers("/customer/**").hasRole("EMPLOYEE")
			.antMatchers("/lib/listEditors*").hasRole("EMPLOYEE")
			.antMatchers("/book/somebooks*").hasRole("EMPLOYEE")
			.antMatchers("/book/listCollections*").hasRole("EMPLOYEE")
			.antMatchers("/book/newBook*").hasRole("EMPLOYEE")
			.antMatchers("/lib/listAuthors*").hasRole("EMPLOYEE")
			.antMatchers("/lib/updateEditor*").hasRole("EMPLOYEE")
			.antMatchers("/book/updateBook*").hasRole("EMPLOYEE")
			.antMatchers("/lib/newAuthor*").hasRole("EMPLOYEE")
			.antMatchers("/lib/updateAuthor*").hasRole("EMPLOYEE")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
	
	@Bean
	public UserDetailsManager userDetailsManager() {

		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		return jdbcUserDetailsManager; 
	}
		
}
