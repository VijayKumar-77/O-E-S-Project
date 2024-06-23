//package com.vijay.online_examination_system.SecurityConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpEntity;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.ws.config.annotation.WsConfigurerAdapter;
//
//
//@Configuration
//@EnableWebMvc
//public class SecurityConfig extends WsConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpEntity http) throws Exception {
//        http
//            .csrf().disable()
//            .authorizeRequests()
//                .antMatchers("/api/user/login", "/api/user/register").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .logout()
//                .logoutUrl("/api/user/logout")
//                .addLogoutHandler(customLogoutHandler())
//                .logoutSuccessHandler(customLogoutSuccessHandler());
//    }
//
//    @Bean
//    public LogoutHandler customLogoutHandler() {
//        return new SecurityContextLogoutHandler();
//    }
//
//    @Bean
//    public LogoutSuccessHandler customLogoutSuccessHandler() {
//        return (request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK);
//    }
//}
//
