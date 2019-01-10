package com.mengu.condition;

import com.mengu.bean.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 描述内容
 *
 * @author mengu
 * @date 2018/11/19
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition注册类；
     *                 把所有需要添加到容器中的bean；调用
     *                 BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.mengu.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.mengu.bean.Blue");
        if(red && blue) {
            // 指定Bean定义信息，包括（Bean的类型，Bean的作用域）
            BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            // 注册一个Bean，指定Bean名
            registry.registerBeanDefinition("rainbow", beanDefinition);
        }
    }
}
