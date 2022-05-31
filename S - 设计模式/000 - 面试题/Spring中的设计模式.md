### 单例模式

创建bean

@Bean就是单例模式 。Spring依赖注入Bean实例默认是单例的。

### 工厂模式

在BeanFactory和ApplicationContext的创建中

@Autowired的就是工厂模式

### 模板模式

在BeanFactory和ApplicationContext的实现中

JdbcTemplate ，父类定义了骨架（调用哪些方法及顺序），某些特定方法由子类实现。

最大的好处：代码复用，减少重复代码。除了子类要实现的特定方法，其他方法及方法调用顺序都在父类中预先写好了。

### 代理模式


AOP底层，就是动态代理模式的实现。

### 策略模式

加载资源文件的方式，比如ClassPathResource、FileSystemResource、ServletContextResource、UrlResource，它们都有共同的接口Resource


### 观察者模式

Spring中的ApplicationEvent、ApplicationListener、ApplicationEventPublisher

### 适配器模式

MethodBeforeAdviceAdapter、ThrowsAdviceAdapter、AfterReturningAdapter

### 装饰着模式

源码中类型带wrapper、Decorator的都是

