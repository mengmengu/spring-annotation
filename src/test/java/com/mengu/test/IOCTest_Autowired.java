package com.mengu.test;

import com.mengu.bean.Boss;
import com.mengu.bean.Car;
import com.mengu.bean.Color;
import com.mengu.config.MainConfigOfAutowired;
import com.mengu.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 自动装配测试
 *
 * @author mengu
 * @date 2018/11/20
 */
public class IOCTest_Autowired {

    @Test
    public void test01() {
        // 1、创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        System.out.println("容器创建完成...");

        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println(bookDao);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);

        // 关闭容器
        applicationContext.close();
    }

}
