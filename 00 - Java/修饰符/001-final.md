### final修饰类时，类里面的属性可以修改吗？

对于int的类型，可以进行修改.

里面的int a是public修饰符吗？还是final 类型？根据结果输出，可以判断不是final类型.

```java
public class Test {
    public static void main(String[] args) {
        TT1 t=new TT1();
        t.show();
        t.show1();
    }
}

final class TT1{
    int a=0;
    public void show(){
        a=1;
        System.out.println(a);
    }


    public void show1(){
        System.out.println(a);
    }
}
```
