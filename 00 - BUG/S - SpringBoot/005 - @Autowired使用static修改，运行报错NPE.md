## @Autowired使用static修改，运行报错NPE

### 原因

在Springframework里，我们不能@Autowired一个静态变量，使之成为一个Spring bean。为什么？其实很简单，因为当类加载器加载静态变量时，Spring上下文尚未加载。所以类加载器不会在bean中正确注入静态类，并且会失败。

### 解决方法1

将@Autowired 注解到类的构造函数上。很好理解，Spring扫描到xxx的bean，然后赋给静态变量component。

### 解决方法2

定义一个静态组件，定义一个非静态组件并加上@Autowired注解，再定义一个初始化组件的方法并加上@PostConstruct注解。这个注解是JavaEE引入的，作用于servlet生命周期的注解，你只需要知道，用它注解的方法在构造函数之后就会被调用。

### 解决方法3（不推荐）

直接用Spring框架工具类获取bean，定义成局部变量使用。但有弊端：如果该类中有多个静态方法多次用到这个组件则每次都要这样获取，个人不推荐这种方式
```jshelllanguage
public class TestClass {
    
    // 调用静态组件的方法
   public static void testMethod() {
      AutowiredTypeComponent component = SpringApplicationContextUtil.getBean("component");
      component.xxxMethod();
   }
    
}
```


















