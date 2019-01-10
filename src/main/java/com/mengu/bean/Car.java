package com.mengu.bean;

import org.springframework.stereotype.Component;

/**
 * 描述内容
 *
 * @author mengu
 * @date 2018/11/20
 */
@Component
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car...init...");
    }

    public void destroy() {
        System.out.println("car...destroy...");
    }

}
