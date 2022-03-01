### @SuppressWarnings("unchecked")

作用：用于抑制编译器产生警告信息。

注解目标：类、字段、方法、方法入参、构造函数和函数的局部变量。建议注解应声明在最接近警告发生的位置。


### @SuppressWarnings("serial")

J2SE 提供的一个批注或者注解。

该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默，即忽略这些警告信息。

### 总结

关键字 -- 用途

deprecation，使用了已过时或者不推荐使用的类或方法时的警告

unchecked，执行了未检查的转换时的警告，例如当使用集合时没有用泛型 (Generics) 来指定集合保存的类型

fallthrough，当 Switch 程序块直接通往下一种情况而没有 Break 时的警告

path，在类路径、源文件路径等中有不存在的路径时的警告

serial，当在可序列化的类上缺少 serialVersionUID 定义时的警告

all，关于以上所有情况的警告
















