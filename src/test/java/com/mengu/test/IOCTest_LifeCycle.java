package com.mengu.test;

import com.mengu.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 生命周期测试
 *
 * @author mengu
 * @date 2018/11/20
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01() {
        // 1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成...");

//        applicationContext.getBean("car");

        // 关闭容器
        applicationContext.close();
    }

}
