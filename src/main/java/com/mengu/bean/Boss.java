package com.mengu.bean;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述内容
 *
 * @author mengu
 * @date 2018/12/10
 */
//默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值操作
@ToString
@Component
public class Boss {

    //第一种方式
//    @Autowired
    private Car car;

    //第三种方式
    //构造器要用的组件，都是从容器中获取
//    @Autowired
    public Boss(/*@Autowired*/ Car car) {
        this.car = car;
        System.out.println("Boss...有参构造器");
    }

    public Car getCar() {
        return car;
    }

    //第二种方式
//    @Autowired
    //标注在方法上，Spring容器创建当前对象，就会调用这个方法，完成赋值
    //方法使用的参数，自定义类型的值从ioc容器中获取
    public void setCar(/*@Autowired*/ Car car) {
        this.car = car;
    }
}
