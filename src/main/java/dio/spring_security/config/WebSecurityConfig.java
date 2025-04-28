package dio.spring_security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


    @Configuration
    @EnableWebSecurity
    @EnableMethodSecurity(prePostEnabled = true)
    public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/", "/h2-console/**", "/error").permitAll() // Adicione /error
                            .requestMatchers("/managers").hasRole("MANAGER") // Pode usar hasRole() simplificado
                            .requestMatchers("/users").hasAnyRole("USER", "MANAGER")
                            .anyRequest().authenticated()
                    )
                    .csrf(csrf -> csrf
                            .ignoringRequestMatchers("/h2-console/**")
                    )
                    .headers(headers -> headers
                            .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                            .httpStrictTransportSecurity(HeadersConfigurer.HstsConfig::disable // Recomendado para desenvolvimento local
                            )
                    )
                    .formLogin(form -> form
                            .defaultSuccessUrl("/")
                            .permitAll()
                    )
                    .logout(logout -> logout
                            .logoutSuccessUrl("/")
                            .invalidateHttpSession(true)
                            .deleteCookies("JSESSIONID")
                            .permitAll()
                    )
                    .sessionManagement(session -> session
                            .sessionFixation().migrateSession()
                    );

            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }
    }


//    @Bean
////    public InMemoryUserDetailsManager userDetailsService() {
////        UserDetails user = User
////                .withUsername("user")
////                .password("{noop}user123")
////                .roles("USER")  // Mudado de "USERS" para "USER" (mais convencional)
////                .build();
////        UserDetails admin = User
////                .withUsername("admin")
////                .password("{noop}master123")
////                .roles("MANAGER")  // Mudado de "MANAGERS" para "MANAGER"
////                .build();
////        return new InMemoryUserDetailsManager(user, admin);
////    }
