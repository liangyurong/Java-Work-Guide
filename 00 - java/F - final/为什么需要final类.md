### 为什么需要final类

用final修饰一个类时，表明这个类不能被继承。final类中的成员变量可以根据需要设为final，但是要注意final类中的所有成员方法都会被隐式地指定为final方法。

除非这个类真的在以后不会用来继承或者出于安全的考虑，尽量不要将类设计为final类。

### 什么时候用到final类？