

### @FeignClient是什么


### 应用场景

向另外的项目发送请求，然后获取到返回的数据。

### 能发送什么请求

get，post，delete，

## 1、使用@FeignClient的工程

说明：只是简单测试。有数据库驱动的时候会报错，因此暂时没有加上数据库，能跑通就行。

### 依赖

```java
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
            <version>2.0.1.RELEASE</version>
        </dependency>
```

运行类
```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//必须添加这个注解
public class RunApp {
    public static void main(String[] args) {
        try {
            SpringApplication.run(RunApp.class,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

TestFeignClient类
```java
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// url：将要跳转的链接
@FeignClient(name = "testFeignClient", url = "localhost:8009")
public interface TestFeignClient {

    @RequestMapping(value = "/testPost", method = { RequestMethod.POST}, consumes = {"application/json;charset=UTF-8"})
    String testPost();

    @RequestMapping(value = "/testGet", method = { RequestMethod.GET}, consumes = {"application/json;charset=UTF-8"})
    String testGet();

}
```

TestController
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TestController {

    @Autowired
    private TestFeignClient feignClient;

    @PostMapping("/testPost")
    public String testPost(){
        String test = feignClient.testPost();
        System.out.println(test);
        return test;
    }

    @GetMapping("/testGet")
    public String testGet(){
        String test = feignClient.testGet();
        System.out.println(test);
        return test;
    }

}

```

## 2、被调用的工程

端口是8009

controller
```java
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class SurveyController {

  @PostMapping("/testPost")
  public String test() {
    return "localhost:8009/testPost";
  }

  @GetMapping("/testGet")
  public String testGet() {
    return "localhost:8009/testGet";
  }
}
```



















