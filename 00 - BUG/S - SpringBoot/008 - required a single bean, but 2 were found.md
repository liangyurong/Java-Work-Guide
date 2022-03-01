
### bug

required a single bean, but 2 were found

### 原因

一般在开发中为了方便都是直接使用@Autowired注解注入bean,但是这样可能会带来一个问题,就是当有一个B类继承了A类,并且两者都写上了@Service注解让spring可以扫描到.

那么在原先使用@Autowired注入A类的地方,spring就会发现有两个bean可以注入,分别是A和B,这个时候就会报required a single bean, but 2 were found的错误了


### 解决方法1（亲测可用）

把其中一个bean加上@Primary注解，就可以作为默认使用

### 解决方法2

在注入的属性添加@Qualifier指定beanName，以明确使用哪一个bean





















