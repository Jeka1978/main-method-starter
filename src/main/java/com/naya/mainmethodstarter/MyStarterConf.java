package com.naya.mainmethodstarter;

import com.naya.mainmethodstarter.aop.StandardControllerAdvice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
public class MyStarterConf {
    @Bean
    public MainInvokerApplicationListener mainInvokerApplicationListener(){
        return new MainInvokerApplicationListener();
    }
//    @Bean
    public BeanDefinitionsFixerBeanPostProcessor beanDefinitionsFixerBeanPostProcessor(){
        return new BeanDefinitionsFixerBeanPostProcessor();
    }

    @Bean
    public StandardControllerAdvice standardControllerAdvice(){
        return new StandardControllerAdvice();
    }
}
