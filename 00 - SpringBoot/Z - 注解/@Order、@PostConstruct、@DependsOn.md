怎么使用代码看出bean加载的顺序呢？ 待解决

### @Order

定义Bean执行顺序的优先级

### @PostConstruct

### @DependsOn

控制bean初始化顺序

有个场景需要bean B应该被先于bean A被初始化，我们可以在bean A上使用@DependsOn注解，告诉容器bean B应该先被初始化。

```jshelllanguage
@Bean
@DependsOn("B")
public class A(){
    
}

@Bean
public class B(){
    
}
```