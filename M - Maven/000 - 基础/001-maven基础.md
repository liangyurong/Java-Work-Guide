


### 001 -  maven不是版本管理工具吗？为什么添加依赖还是需要填写version？

```text
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.6.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

添加上述代码的<parent>后，会为开发者提供常用的jar管理版本。如果我们自己在<dependency></ dependency>的<version>中提供了版本号，则会覆盖默认版本。

如果项目的复杂度高，又依赖了很多开源项目，开源项目又依赖了其他的jar，那么内部依赖jar极有可能会出现版本冲突。

### 002 - 什么是maven依赖冲突？

1. 举个例子，现在你的项目中，使用了两个Jar包，分别是A和B。
2. 现在A需要依赖另一个Jar包C，B也需要依赖C。
3. 但是A依赖的C的版本是1.0，B依赖的C的版本是2.0。这时候，Maven会将这1.0的C和2.0的C都下载到你的项目中，这样你的项目中就存在了不同版本的C，这时Maven会依据依赖路径最短优先原则，来决定使用哪个版本的Jar包，而另一个无用的Jar包则未被使用，这就是所谓的依赖冲突。







