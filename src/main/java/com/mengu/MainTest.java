package com.mengu;

import com.mengu.bean.Person;
import com.mengu.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 描述内容
 *
 * @author mengu
 * @date 2018/11/11
 */
public class MainTest {

    public static void main(String[] args) {
        // XML配置方式
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);

        // 注解配置方式
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] namesForTypes = applicationContext.getBeanNamesForType(Person.class);
        for (String name : namesForTypes) {
            System.out.println(name);
        }
    }

}
