package com.mengu.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * 自定义逻辑返回需要导入的组件
 *
 * @author mengu
 * @date 2018/11/19
 */
public class MyImportSelector implements ImportSelector {

    // 返回值，就是要导入到容器中的组件全类名
    // AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    // 此方法不能返回null，可以返回空数组
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[0];
        return new String[]{"com.mengu.bean.Blue", "com.mengu.bean.Yellow"};
    }

}
