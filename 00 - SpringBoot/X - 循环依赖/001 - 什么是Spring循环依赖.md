### 什么是循环依赖

bean之间相互依赖

### 源码

```jshelllanguage
public class A {
    @Autowired
    B b;

    public A() {
    } 
}

class B{
    @Autowired
    A a;

    public B() {
    }
}
```

### 流程

创建A对象

    实例化A对象，此时b=null

    给A的属性b赋值，判断容器中是否有B对象

        有：直接返回

        没有： 创建B对象

创建B对象

    实例化B对象，此时a=null

    给B的属性a赋值，判断容器中是否有A对象

        有：直接返回

        没有： 创建A对象，此时，陷入循环依赖



    
