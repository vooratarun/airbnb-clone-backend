//package fr.codecake.airbnbclone.infrastructure.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
//
//@Configuration
//@EnableMethodSecurity
//public class SecurityConfiguration {
//
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
//        requestHandler.setCsrfRequestAttributeName(null);
//        http.authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(HttpMethod.GET, "api/tenant-listing/get-all-by-category").permitAll()
//                        .requestMatchers(HttpMethod.GET, "api/tenant-listing/get-one").permitAll()
//                        .requestMatchers(HttpMethod.POST, "api/tenant-listing/search").permitAll()
//                        .requestMatchers(HttpMethod.GET, "api/booking/check-availability").permitAll()
//                        .requestMatchers(HttpMethod.GET, "assets/*").permitAll()
//                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
//                        .anyRequest()
//                        .authenticated())
//                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                        .csrfTokenRequestHandler(requestHandler));
//
//        return http.build();
//    }
//}


package fr.codecake.airbnbclone.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http

                .csrf(csrf -> csrf.disable())   // disable csrf for testing / public APIs
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()   // allow every request
                );

        return http.build();
    }
}