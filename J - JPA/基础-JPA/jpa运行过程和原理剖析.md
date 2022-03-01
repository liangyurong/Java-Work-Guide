
### 为什么明明没有实现任何类的方法，只是定义了一个接口，接口继承了两个类,而我们就能够使用这么多的方法去操作数据库？

```java
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> , JpaSpecificationExecutor<Customer> {
    
}
```

