## 判空

是否为null，是null的话，抛出异常。

对于空字符串，不会抛出异常

### 判断

```jshelllanguage
    @GetMapping("test")
    public void forTest(){
        String str1 = null;
        Preconditions.checkNotNull(str1,"报错：参数为null"); // 可以自定义抛出异常信息
    }
```

### 测试结果

不能直接在psvm中执行。（在psvm中只是直接抛出错误，不能封装成Result）

链接：localhost:8888/test

结果
```text
{"msg":"报错：参数为null","code":1}
```

### 全局捕获异常

```jshelllanguage
import com.sdyb.mp.exception.MpException;
import com.sdyb.mp.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.concurrent.TimeoutException;

/**
 * 全局捕获异常
 * @author lyr
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends Exception{

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(MpException.class)
    public Result handleMpException(MpException e) {
        Result result = new Result();
        result.putCode(1);
        result.putMsg(e.getMsg());
        return result;
    }

    /**
     * 这个是为了抓取意想不到的异常，因为我们是无法抓取到全部的异常的
     * @param e 异常
     * @return result
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        Result result = new Result();
        result.putCode(1);
        result.putMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(RuntimeException.class)
    public Result runtimeException(RuntimeException e) {
        Result result = new Result();
        result.putCode(1);
        result.putMsg(e.getMessage());
        return result;
    }

    @ExceptionHandler(TimeoutException.class)
    public Result timeoutException(TimeoutException e) {
        Result result = new Result();
        result.putCode(1);
        result.putMsg(e.getMessage());
        return result;
    }

}

```
