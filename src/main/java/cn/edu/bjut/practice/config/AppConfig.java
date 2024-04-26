package cn.edu.bjut.practice.config;

import cn.edu.bjut.interceptor.LoginCheckInterceptor;
import cn.edu.bjut.jwt.JWTUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import cn.edu.bjut.oss.AliOSSProperties;
import cn.edu.bjut.oss.AliOSSUtils;


@MapperScan("cn.edu.bjut.managerlogin.mapper")
@MapperScan("cn.edu.bjut.enterpriseregister.mapper")
@MapperScan("cn.edu.bjut.hrregister.mapper")
@MapperScan("cn.edu.bjut.manageridentified.mapper")
@MapperScan("cn.edu.bjut.studentregister.mapper")
@MapperScan("cn.edu.bjut.practice.mapper")
@MapperScan("cn.edu.bjut.hrpostmanagement.mapper")
@MapperScan("cn.edu.bjut.studentsearchpost.mapper")
@MapperScan("cn.edu.bjut.produceresume.mapper")
@MapperScan("cn.edu.bjut.websocket.mapper")
@ComponentScan(basePackages = {"cn.edu.bjut.hrregister", "cn.edu.bjut.websocket",
        "cn.edu.bjut.interceptor", "cn.edu.bjut.result",
        "cn.edu.bjut.managerlogin", "cn.edu.bjut.enterpriseregister",
        "cn.edu.bjut.manageridentified", "cn.edu.bjut.oss", "cn.edu.bjut.jwt",
        "cn.edu.bjut.studentregister", "cn.edu.bjut.hrpostmanagement",
        "cn.edu.bjut.entity","cn.edu.bjut.studentsearchpost","cn.edu.bjut.produceresume"})
@Configuration
public class AppConfig {
    @Bean
    public AliOSSUtils aliOSSUtils() {
        return new AliOSSUtils();
    }

    @Bean
    public AliOSSProperties aliOSSProperties() {
        return new AliOSSProperties();
    }

    @Bean
    public cn.edu.bjut.jwt.JWTUtils jwtUtils() {
        return new JWTUtils();
    }

    @Bean
    public LoginCheckInterceptor loginCheckInterceptor(){
        return new LoginCheckInterceptor();
    }
}

