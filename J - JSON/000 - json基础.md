


### Json是什么？

把一串JSON转换成Java的对象模型，以及把Java的对象模型转换成一串JSON。

使用key-value形式存储。key必须是String，value可以是其他形式。

### 为什么我们要使用Json？

方便前后端交互。

## FastJson

FastJson为什么这么快？
- 自行编写类似StringBuilder的工具类SerializeWriter。
- 使用ThreadLocal来缓存buf。
- 使用asm避免反射
- 集成jdk实现的一些优化算法




