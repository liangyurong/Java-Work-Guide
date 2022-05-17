### SpringBoot启动过程

### @Autowired注入方式

@Autowired默认按byType自动装配，而@Resource默认byName自动装配。

Autowired 属于 Spring 内置的注解，默认的注入方式为byType（根据类型进行匹配），也就是说会优先根据接口类型去匹配并注入 Bean （接口的实现类）

这会有什么问题呢？ 当一个接口存在多个实现类的话，byType这种方式就无法正确注入对象了，因为这个时候 Spring 会同时找到多个满足条件的选择，默认情况下它自己不知道选择哪一个。这种情况下，注入方式会变为 byName（根据名称进行匹配），这个名称通常就是类名（首字母小写）。就比如说下面代码中的 smsService 就是我这里所说的名称
```jshelllanguage
@Autowired
private AaService aaService;
```

### 参数

@Autowired只包含一个参数：required，表示是否开启自动准入，默认是true。

@Resource包含七个参数，其中最重要的两个参数是：name 和 type。

@Autowired如果要使用byName，需要使用@Qualifier一起配合。

@Resource如果指定了name，则用byName自动装配，如果指定了type，则用byType自动装配。

### 用在哪

@Autowired能够用在：构造器、方法、参数、成员变量和注解上，

@Resource能用在：类、成员变量和方法上。@Autowired是spring定义的注解，而@Resource是JSR-250定义的注解。此外，它们的装配顺序不同。










