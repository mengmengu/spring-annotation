package com.mengu.config;

import com.mengu.bean.Color;
import com.mengu.bean.ColorFactoryBean;
import com.mengu.bean.Person;
import com.mengu.bean.Red;
import com.mengu.condition.*;
import org.springframework.context.annotation.*;

/**
 * 配置类
 *
 * @author mengu
 * @date 2018/11/14
 */
// 类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional({MacOsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
//@Import导入组件，id默认是组件的全类名
public class MainConfig2 {

    // 默认是单实例的 singleton
    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
     * ConfigurableBeanFactory#SCOPE_SINGLETON singleton
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session
     * @return
     *
     *
     * @Scope : 调整作用域
     * prototype : 多实例 : ioc容器启动不会去调用方法创建对象放在容器中，
     *                     每次获取的时候才会调用方法创建对象
     * singleton : 单实例（默认值）: ioc容器启动会调用方法创建对象放到ioc容器中，
     *                            以后每次获取就是直接从容器（map.get()）中拿
     * request   : 同一次请求创建一个实例，需要web环境
     * session   : 同一个session创建一个实例，需要web环境
     *
     *
     * 懒加载；
     *      单实例bean : 默认在容器启动的时候创建对象
     *      懒加载 : 容器启动不创建对象。第一次使用（获取）Bean创建对象，并初始化
     *
     * @return
     */
//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person......");
        return new Person("张三", 25, null);
    }

    /**
     * @Conditional({Condition}) : 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows，给容器注册("bill")
     * 如果系统是linux，给容器注册("linus")
     * 如果系统是mac os，给容器注册("jobs")
     *
     * @return
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62, null);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("linus", 48, null);
    }

    @Conditional(MacOsCondition.class)
    @Bean("jobs")
    public Person person03() {
        return new Person("Jobs", 56, null);
    }

    /**
     * 给容器中注册组件
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     *     1）、@Import(要导入到容器中的组件)；容器中就会自动注册这个组件，id默认是全类名
     *     2）、ImportSelector : 返回需要导入的组件的全类名数组
     *     3）、ImportBeanDefinitionRegistrar : 手动注册bean到容器中
     * 4）、使用Spring提供的FactoryBean（工厂Bean）
     *      1）、默认获取到的是工厂bean调用getObject创建的对象
     *      2）、要获取工厂Bean的本身，我们需要给id前面加一个&
     *          即: &colorFactoryBean
     */
    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
