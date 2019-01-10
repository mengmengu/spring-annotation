package com.mengu.config;

import com.mengu.bean.Person;
import com.mengu.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 配置类
 *
 * @author mengu
 * @date 2018/11/11
 */
// 配置类==配置文件
@Configuration  // 告诉Spring这是一个配置类

//@ComponentScan(value = "com.mengu", excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//})
//@ComponentScan(value = "com.mengu", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
//}, useDefaultFilters = false)
@ComponentScans(value = {
        @ComponentScan(value = "com.mengu", includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookService.class)
                @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
        }, useDefaultFilters = false)
})
// @ComponentScan value:指定要扫描的包
// excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除哪些组件
// includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
// FilterType.ANNOTATION ：按照注解
// FilterType.ASSIGNABLE_TYPE : 按照给定的类型
// FilterType.ASPECTJ : 使用 ASPECTJ
// FilterType.REGEX : 使用正则
// FilterType.CUSTOM : 使用自定义规则
public class MainConfig {

    // 给容器注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
//    @Bean("person")
    public Person person01() {
        return new Person("lisi", 20, null);
    }

}
