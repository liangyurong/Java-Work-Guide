## @Transient

引入的依赖是：import javax.persistence.Transient;

### 作用

在实体类中加一个数据库中没有的字段

### 如果不添加该字段，就会报错

 Unknown column ‘xxx’ in 'xxx’


### 如果加 @Transient 注解无效的话，不妨试试 @TableField(exist = false) ，或者在属性前面加 transient

```jshelllanguage
  @Transient
  private List<Dept> children;
```

```jshelllanguage
  @TableField(exist = false)
  private List<Dept> children;
```

```jshelllanguage
  //或者
  private transient  List<Dept> children;
```
















