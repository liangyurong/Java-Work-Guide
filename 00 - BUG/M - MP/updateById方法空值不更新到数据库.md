## updateById方法空值不更新到数据库的解决方法


### 在application.properties中设置

MyBatis-Plus 全局策略中的 DB 策略配置MyBatis-Plus 全局策略中的 DB 策略配置

```txt
mybatis-plus:
  global-config: 
    db:config: 
      update-strategy: ignored #字段验证策略之 update,在 update 的时候的字段验证策略
      insert-strategy: ignored
```

### 错误的写法

```jshelllanguage
/**
* 这种写法，会导致user的其他属性都是null
* 
* 如果不声明上面的全局配置文件，则数据库会把原来的值复制给user对象，因此user中其他的属性还是原来的值
* 
* 如果声明了，则user中只有id和name是有值的，其他值为null
* 
*/
@Test
public void testUpdateById(){
    User user = new User();
    user.setId(1l);
    user.setName("更改后的名字");
    int update = userMapper.updateById(user);
}
```

### 正确的写法

```jshelllanguage
@Test
public void testUpdateByI111d(){
    
    User user = userMapper.selectById(1L);
    
    user.setName("hhhhhh");

    int update = userMapper.updateById(user);

    System.out.println(user.getName());

    System.out.println(user.getEmail());

}
```
