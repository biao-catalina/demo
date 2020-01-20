package com.biao.mvc.service;

import com.biao.mvc.controller.HelloController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

@Component
public class DemoService implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        HelloController helloController = configurableListableBeanFactory.getBean(HelloController.class);
        System.out.println(1);
    }

    public static void main(String[] args) {
        DemoService demo = new DemoService();
        System.out.println(Arrays.toString(demo.getClass().getGenericInterfaces()));
        Type type = ((ParameterizedType)demo.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }
}
