## spring事务失效的12种场景

### 1、事务方法的访问权限不是定义为public

spring被要求代理方法必须是public

### 2、用final修饰方法

spring事务底层用的aop，也就是通过jdk动态代理或者cglib，帮我们生成了代理类，在代理类仲实现事务功能。

当方法是final，则代理类无法重写该方法来添加事务功能。

### 3、用static修饰方法

无法通过动态代理生成代理类

### 4、对象没有被spring管理。

归类：低级错误

如果类没有添加@Component，@Service等注解，说明该类没有交给spring管理，那么它的方法也不会生成事务。

举例子：该类没有写@Service注解，因此不被spring管理。

```java
public class xxxServiceImpl{
    
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void updateStatus(User user){
        userMapper.insertUser(user);
    }
    
}
```



### 5、表不支持事务

mysql5之前的默认引擎是myisam

如果数据库引擎是myisam，该引擎是不支持事务的。

### 6、开发者自己手动捕获异常但是不抛出或者抛错了异常

此时事务不会回滚

spring事务默认情况只会回滚runtime异常和error异常，对于非运行时异常不会回滚。

### 7、方法内部调用：普通方法调用事务方法

```java
@Service
public class xxxServiceImpl{
    
    @Autowired
    private UserMapper userMapper;
    
    public void add(User user){
        userMapper.insertUser(user);
    	updateStatus(user); // 相当于this调用了方法，不会用到代理，因此不会用事务
    }
    
    @Transactional
    public void updateStatus(User user){
        doSameThing(user);
    }
    
}
```

解决：将自己注入spring容器

```java
@Service
public class xxxServiceImpl{
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private  xxxServiceImpl service;
    
    public void add(User user){
        userMapper.insertUser(user);
    	service.updateStatus(user); 
    }
    
    @Transactional
    public void updateStatus(User user){
        doSameThing(user);
    }
    
}
```

### 8、多线程调用

多个线程去调用同一个事务方法，会产生多个数据库连接。

只有同一个数据库连接才能同时提交和回滚。因此多线程情况下也会失效。



那么应该怎么保证多线程下事务不会失效？



### 9、使用了错误的事务传播特性

比如使用了never