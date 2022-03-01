## No beans of xxx type found 

```jshelllanguage
import com.sdyb.aiyimei.entity.VToken;
import com.sdyb.aiyimei.mapper.VTokenMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRun.class) // .class对应.java文件名
public class TestRun {

    @Autowired
    private VTokenMapper mp; // 显示错误，但是VTokenMapper命名是有注解的

    @Test
    public void testInsertVToken(){
        VToken v = new VToken();
        v.setToken("this-is-my-token");
        mp.insert(v);
    }
}
```


解决：测试的java文件层级必须main的文件层级一样
```txt
比如xxxMapper的层级是:com.sdyb.aiyimei，在mapper的文件里面定义xxxMapper.java

则test目录中也必须定义层级com.sdyb.aiyimei，然后定义文件Test.java
```










