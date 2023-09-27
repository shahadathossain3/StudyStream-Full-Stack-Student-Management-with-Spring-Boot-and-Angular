package com.example.springbootstudentmanagement.config;


import com.example.springbootstudentmanagement.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .cors().configurationSource(new CorsConfigurationSource() {
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setExposedHeaders(Arrays.asList("Authorization"));
                    config.setMaxAge(3600L);
                    return config;
                }
            }).and().csrf().disable()
            .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
            .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
            .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
            .authorizeHttpRequests((auth) -> auth
                .antMatchers("/classroom/addClassroom").hasRole("ADMIN")
                .antMatchers("/classroom/getClassroomList").hasRole("ADMIN")
                .antMatchers("/subjects/addSubjects").hasRole("ADMIN")
                .antMatchers("/sections/addSection").hasRole("ADMIN")
                .antMatchers("/sections/getAllSectionsList").hasRole("ADMIN")
                .antMatchers("/students/addStudents").hasRole("ADMIN")
                .antMatchers("/students/getAllStudentsList").hasRole("ADMIN")
                .antMatchers("/teachers/addTeachers").hasRole("ADMIN")
                .antMatchers("/teachers/getTeachersList").hasRole("ADMIN")
                .antMatchers("/enrollment/addEnrollment").hasRole("ADMIN")
                .antMatchers("/examination/addExamination").hasRole("ADMIN")
                .antMatchers("/result/addResult").hasRole("TEACHER")
                .antMatchers("/result/studentListWithSubject/**").hasAnyRole("ADMIN","TEACHER")
                .antMatchers("/user/login").authenticated()
                .antMatchers("/students/getSectionWithClassroomSubject/**","/students/getExamination/**","/sections/dayOfWeek","subjects/getAllSubjectList").permitAll()
            ).httpBasic(Customizer.withDefaults());
        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
