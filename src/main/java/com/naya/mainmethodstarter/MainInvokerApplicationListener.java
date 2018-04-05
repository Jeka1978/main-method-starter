package com.naya.mainmethodstarter;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class MainInvokerApplicationListener implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = factory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName == null) {
                continue;
            }
            Class<?> beanClass = Class.forName(beanClassName);
            Method[] methods = beanClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Main.class)) {
                    Object bean = context.getBean(name);
                    Method methodOfBean = bean.getClass().getMethod(method.getName());
                    methodOfBean.invoke(bean);
                }
            }


        }
    }
}








