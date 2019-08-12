package com.tm.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tm.interceptor.ServiceInterceptor;

/**
 * サービスインターセプターのBean定義クラス
 */
@Configuration
public class InterceptorConfig {

    @Bean
    public Advisor advisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public * com.tm.service..*Service.*(..)) || execution(public * com.tm.dao..*Repository.*(..))");
        return new DefaultPointcutAdvisor(pointcut, new ServiceInterceptor());
    }
}
