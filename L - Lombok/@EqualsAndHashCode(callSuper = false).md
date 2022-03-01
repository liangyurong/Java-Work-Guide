
### 在类是继承父类的情况下

EqualsAndHashCode实则就是在比较两个对象的属性

1、当@EqualsAndHashCode(callSuper = false)时不会比较其继承的父类的属性可能会导致错误判断；

2、当@EqualsAndHashCode(callSuper = true)时会比较其继承的父类的属性；























