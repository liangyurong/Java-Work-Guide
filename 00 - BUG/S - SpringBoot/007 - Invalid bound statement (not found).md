
## bug

org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.sdyb.official.service.BasicService.getList

## bug说明

绑定不了某个方法

## 原因

一般都是注解有问题，或者扫描注解的问题

如果controller,service,dao层的注解都没有问题，那可能是xml的路径问题或者是启动类扫描bean问题



## 解决

### 启动类不用写一下两个注解

```jshelllanguage
@ComponentScan(basePackages = {"com.sdyb.official.*"})
@MapperScan("com.sdyb.official.*")
```

### dao类写@Mapper和@Component两个注解























