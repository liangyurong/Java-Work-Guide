## 支持 ActiveRecord 模式

支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作

## ActiveRecord 模式

简称AR模式 ，它是活动记录，是一种领域模型模式。

特点：一个模型类对应关系型数据库中的一个表，而模型类的一个实例对应表中的一条记录。属于动态模型，简单讲就是直接用实体类对数据库进行Crud 操作

而Java是准静态语言不能支持AR 形式 ，MP作者对此进行探索才有现在的功能


### @EqualsAndHashCode(callSuper = false)

lombok自动生成的equals和hashcode没有调用父类，在类上添加该注解@EqualsAndHashCode(callSuper = false)， false 表示不调用

### 实体类（一般在生产项目不推荐这么做）

写完之后，就可以直接跳过所谓的Mapper和Service啥的，直接对数据库进行增删改查了。

```jshelllanguage

@Data
@TableName("user")
@EqualsAndHashCode(callSuper = false)
public class User  extends Model<User> {
   private static final Long SeriaVersionUID=1L;
   
   // 不需要添加字段???
   
}

```

### insert方法示例

```jshelllanguage
import com.example.boot.bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ARTest {
    @Test
    public void testInsert(){
        Student student = new Student();
        student.setName("李白");
        student.setEmail("libai@qq.com");
        student.setAge(23);
        //自己插自己即可将自己这条数据作为一条记录插入数据库
        student.insert();
    }
}
```
