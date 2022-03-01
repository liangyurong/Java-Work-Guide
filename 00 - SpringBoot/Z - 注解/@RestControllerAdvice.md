
### @RestControllerAdvice

@RestControllerAdvice常常结合@Slfj使用，因为拦截到异常，需要将异常信息输出到日志当中进行排查。

作用：拦截异常并进行统一处理

示例
```text
@RestControllerAdvice
@Slf4j
public class GlobalExceptionController {

}
```


### 可以写多个@RestControllerAdvice吗？

可以

但是可能每个加载的顺序不一致，需要先加载的就加@Order注解







