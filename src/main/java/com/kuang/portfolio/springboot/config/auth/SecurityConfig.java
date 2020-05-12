package com.kuang.portfolio.springboot.config.auth;

import com.kuang.portfolio.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //Cross Site Request Forgery 기능 비활성화
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    // .anMatchers = 권한 부여
                    .antMatchers("/",
                    "/css/**",
                    "/images/**",
                    "/js/**",
                    "/h2-console/**")
                    // 전체 접근 가능
                    .permitAll()
                        .antMatchers("/api/v1/**")
                        // USER 권한을 가진 계정만 접근
                        .hasRole(Role.USER.name())
                        .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
    }
}
