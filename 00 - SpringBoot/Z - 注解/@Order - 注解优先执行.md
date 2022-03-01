
### 数值越小，优先级越高，越先执行

```java
@Order(1)
public class xxx{

}
```


### 实际业务场景

在人人框架系统中，写了问卷曲剧异常捕获类SurveyExceptionHandler.java

但是在抛出问卷异常的捕获时，却被RenExceptionHandler.java捕获

于是我在SurveyExceptionHandler.java添加了注解@Order

```java
@RestControllerAdvice
@Slf4j
@Order(1) // 强制首先加载这个类，否则问卷异常会被RenExceptionHandler捕获
public class SurveyExceptionHandler extends Exception {
    
}
```
