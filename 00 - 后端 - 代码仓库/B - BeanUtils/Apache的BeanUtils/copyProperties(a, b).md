### BeanUtils.copyProperties(a, b);

b拷贝到a

### 说明

1、限制较多

2、添加了很多的检验，包括类型的转换，甚至于还会检验对象所属的类的可访问性。

4、除了支持基本类型以及基本类型的数组之外，还支持java.sql.Date, java.sql.Time, java.sql.TimeStamp, java.io.File, javaio.URL这些类的对象，其余一概不支持。

5、不过你可以自定义你的类的Converter。然后注册进去。所以在使用时
  
6、感觉commons-beanutils包中的这个BeanUtils类的copyProperties方法，太过复杂，约束太多，而且使用不便，虽然可扩展性好了，但是易用性不高。

### 限制

commons-beanutils中的装换是不支持java.util.Date的

对于内部静态类的对象复制也会出现问题，检验太复杂了，常会出现一些诡异的问题。毕竟我们bean复制一般就是简单的属性copy而已


















