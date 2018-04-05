package com.naya.mainmethodstarter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.lang.Nullable;

/**
 * @author Evgeny Borisov
 */
public class BeanDefinitionsFixerBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        BeanDefinition beanDefinition = null;
        try {
            beanDefinition = factory.getBeanDefinition(beanName);
        } catch (NoSuchBeanDefinitionException e) {

            return bean;
        }
        if (beanDefinition.getBeanClassName() == null) {
            beanDefinition.setBeanClassName(bean.getClass().getName());
        }
        return bean;

    }
}
