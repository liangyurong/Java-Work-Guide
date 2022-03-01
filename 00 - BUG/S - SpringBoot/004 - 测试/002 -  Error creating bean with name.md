##  Error creating bean with name

背景：在编写测试时，出错

解决: @SpringBootTest注解后面不要带东西

```java
import com.sdyb.aiyimei.entity.VToken;
import com.sdyb.aiyimei.mapper.VTokenMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest // (classes = TestRun.class) // .class对应.java文件名
public class TestRun {

  @Autowired
   VTokenMapper mp;

  @Test
  public void testInsertVToken() {
    VToken v = new VToken();
    v.setToken("this-is-my-token");
    mp.insert(v);
  }
}
```
