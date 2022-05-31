## 为什么需要final方法

把方法锁定，以防任何继承类修改它的含义

类的private方法会隐式地被指定为final方法


### code

```jshelllanguage
final class A{}
```