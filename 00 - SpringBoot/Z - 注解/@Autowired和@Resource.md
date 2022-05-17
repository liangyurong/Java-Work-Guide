## @Autowired

是通过类型注入的，也就是byType方法


只是看User，不管后面叫uu还是user，这就是类型注入
```jshelllanguage
@Autowired
private User uu;
```

### 如果@Autowired需要通过byName方式注入

```jshelllanguage
public class Test {
    @Autowired
    @Qualifier("config")
    private DataConfig dataConfig;
}


@Data
@Component("config") // 对应@Qualifier里的值
public class DataConfig {
     @Value("localhost:3306/lyr")
     private String url;
}
```

## @Resource

@Resource默认按照ByName自动注入