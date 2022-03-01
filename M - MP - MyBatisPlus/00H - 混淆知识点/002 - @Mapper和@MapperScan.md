
## 一、@Mapper

注解在类

### 我现在喜欢在每个dao类加上@Mapper，不喜欢写@MapperScan

```jshelllanguage
@Mapper
public interface ManMapper extends BaseMapper<Man> {

}
```

## 二、@MapperScan

@MapperScan是放在启动类上的注解，去根据路径扫描所有














