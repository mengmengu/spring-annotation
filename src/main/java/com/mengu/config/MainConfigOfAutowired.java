package com.mengu.config;

import com.mengu.bean.Car;
import com.mengu.bean.Color;
import com.mengu.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1）、@Autowired:自动注入:
 *      1）、默认优先按照类型去容器中找对应的组件:applicationContext.getBean(BookDao.class);找到就赋值
 *      2）、如果找到多个相同类型的组件，再将属性的名字作为组件的id去容器中查找
 *                                  applicationContext.getBean("bookDao")
 *      3）、@Qualifier("bookDao"): 使用 @Qualifier 指定需要装配的组件的id，而不是使用属性名
 *      4）、自动装配默认一定要将属性赋值好，没有就会报错。
 *          可以使用@Autowired(required = false)，非必须
 *      5）、@Primary: 让Spring进行自动装配的时候，默认使用首选的bean。
 *              也可以继续使用@Qualifier指定需要装配的bean名字。
 *              如果使用@Qualifier明确指定了一个bean，@Primary默认首选就会失效。
 *
 *      BookService{
 *          @Autowired
 *          BookDao bookDao;
 *      }
 *
 * 2）、Spring还支持使用@Resource(JSR250)和@Inject(JSR330)【都是java规范的注解】
 *      @Resource:
 *          可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的；
 *          没有能支持@Primary功能，也没有支持@Autowired（required = false）的功能
 *      @Inject:
 *          需要导入javax.inject的包，和Autowired的功能一样。没有required=false的功能
 *  @Autowired: Spring定义的；@Resource、@Inject都是java规范。
 *
 *  AutowiredAnnotationBeanPostProcessor: 解析完成自动装配功能
 *
 * 3）、@Autowired: 可以用在构造器、参数、方法、属性；都是从容器中获取参数组件的值
 *      1）、[标注在方法位置]: @Bean+方法参数；参数从容器中获取；默认不写@Autowired效果是一样的，都能自动装配
 *      2）、[标在构造器上]: 如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以自动从容器中获取
 *      3）、放在参数位置
 *
 * @author mengu
 * @date 2018/12/8
 */
@Configuration
@ComponentScan({"com.mengu.service", "com.mengu.dao", "com.mengu.bean", "com.mengu.controller"})
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

    /**
     * @Bean 标注的方法创建对象的时候，方法参数的值从容器中获取
     * @param car
     * @return
     */
    @Bean
    public Color color(/*@Autowired*/ Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }

}
