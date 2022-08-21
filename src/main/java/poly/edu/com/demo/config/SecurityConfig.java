package poly.edu.com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import poly.edu.com.demo.entity.Users;
import poly.edu.com.demo.service.UserService;

import java.util.NoSuchElementException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptConfig bCryptPasswordEncoder;

//    Cung cap nguon du lieu dang nhap
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try{
                Users user = this.userService.getUsersByUsername(username);
                String password = bCryptPasswordEncoder.passwordEncoder().encode(user.getPassword());
                return User.withUsername(username).password(password).roles(String.valueOf(user.getTypeRole().getValue())).build();
            }catch (NoSuchElementException e){
                throw new UsernameNotFoundException(username + "not found!");
            }
        });
    }

//    Phan quyen su dung
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/order/**", "/history", "/assets/**").authenticated()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "0")
                .antMatchers("/rest/authorities").hasRole("USER")
                .anyRequest().permitAll();

        http.formLogin() // Cho phép người dùng xác thực bằng form login
                .loginPage("/earPhone/logInForm")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/security/login/success", false)// login thành công thì vào request này
                .failureUrl("/security/login/error");

        http.logout() // Cho phép logout
                .logoutUrl("/security/logoff")
                .logoutSuccessUrl("/security/logoff/success");

        http.rememberMe()
                .tokenValiditySeconds(86400);

        http.exceptionHandling()
                .accessDeniedPage("/security/unauthoried");
    }

    // Cho phép truy xuất REST API từ bên ngoài (domain khác)

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
