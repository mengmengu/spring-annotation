Spring注解练习
===================
基于尚硅谷视频资料

包含 `组件注册`、`生命周期`、`属性赋值`、`自动装配`

# 组件注册
 - @Configuration&@Bean给容器中注册组件
 - @ComponentScan-自动扫描组件&指定扫描规则
 - 自定义TypeFilter指定过滤规则
 - @Scope-设置组件作用域
 - @Lazy-bean懒加载
 - @Conditional-按照条件注册bean
 - @Import-给容器中快速导入一个组件
 - @Import-使用ImportSelector
 - @Import-使用ImportBeanDefinitionRegistrar
 - 使用FactoryBean注册组件

# 生命周期
 - @Bean指定初始化和销毁方法
 - InitializingBean和DisposableBean
 - @PostConstruct&@PreDestroy
 - BeanPostProcessor-后置处理器
 - BeanPostProcessor原理
 - BeanPostProcessor在Spring底层的使用

# 属性赋值
 - @Value赋值
 - @PropertySource加载外部配置文件

# 自动装配
 - @Autowired&@Qualifier&@Primary
 - @Resource&@Inject
 - 方法、构造器位置的自动装配
 - Aware注入Spring底层组件&原理
 - @Profile环境搭建
 - @Profile根据环境注册bean
