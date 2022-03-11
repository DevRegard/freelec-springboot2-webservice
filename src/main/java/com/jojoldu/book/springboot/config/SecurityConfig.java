package com.jojoldu.book.springboot.config;

import com.jojoldu.book.springboot.config.auth.CustomOAuth2UserService;
import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Mk | Spring Security 설정들 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .csrf().disable()
            .headers().frameOptions().disable()
                // Mk | h2-console 화면 사용 위해 해당 옵션 disable [ csrf() ~ disable() ]
            .and()
            .authorizeRequests()
                // Mk | URL 권한 관리 설정 옵션 시작점, authorizeRequests() 선언 후, antMatchers() 사용 가능
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() // Mk < anyRequest > : 설정된 값들 이외 나머지 URL
                // Mk | 권한 관리 대상 지정하는 옵션 | URL, HTTP 메소드별 관리 가능
                // Mk | "/" 등 지정된 URL 들을 permitAll() 옵션 -> 전체 열람 권한
                // Mk | "api/v1/**" 주소 가진 API -> USER 권한 가진 사람만 가능 설정
            .and()
               .logout()
                    .logoutSuccessUrl("/")
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                        .userService(customOAuth2UserService);
    }
}
