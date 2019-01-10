package com.mengu.config;

import com.mengu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 属性赋值
 *
 * @author mengu
 * @date 2018/11/25
 */
// 使用 @PropertySource 读取外部配置文件中的 k/v 保存到运行的环境变量中；加载完外部的配置文件以后使用${}取出配置文件的值
/**
 * 使用@Value读取properties的文件时，如果properties的值写的是中文，则会出现乱码，
 * 所以在@PropertySource增加encoding = "UTF-8"设置编码格式解决问题
 * 如果中文转换成unicode(\u5c0f\u5f20\u4e09)编码则不会出现此问题
 */
@PropertySource(value = {"classpath:/person.properties"}, encoding = "UTF-8")
@Component
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }

}
