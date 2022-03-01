## 避免用Apache Beanutils进行属性的copy

速度慢。CommonsBeanUtils 主要有以下几个耗时的地方：
```text
输出了大量的日志调试信息
重复的对象类型检查
类型转换
```

### 在使用 CommonsBeanUtils 时还有其他的坑需要特别小心！

在进行属性拷贝时，虽然 CommonsBeanUtils 默认不会给原始包装类赋默认值的，但是在使用低版本(1.8.0及以下)的时候，如果你的类有 Date 类型属性，而且来源对象中该属性值为 null 的话，就会发生异常：

org.apache.commons.beanutils.ConversionException: No value specified for 'Date'

解决这个问题的办法是注册一个 DateConverter：

ConvertUtils.register(new DateConverter(null), java.util.Date.class);

然而这个语句，会导致包装类型会被赋予原始类型的默认值，如 Integer 属性默认赋值为 0，尽管你的来源对象该字段的值为 null。

在高版本(1.9.3)中，日期 null 值的问题和包装类赋默认值的问题都被修复了。

这个在我们的包装类属性为 null 值时有特殊含义的场景，非常容易踩坑！例如搜索条件对象，一般 null 值表示该字段不做限制，而 0 表示该字段的值必须为0。
