### dependency

只需要引入这一个依赖，其他不需要

```java
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope> 
        </dependency>
```

### 测试代码，.java文件必须写在src/test文件夹内，不可写在src/main文件夹

测试类的名称不要命名为Test

```jshelllanguage
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest  // (classes = TestRun.class) // 如果不行再把注释打开
public class TestRun {

    @Test
    public void run1(){
        System.out.println("he");
    }

}
```
