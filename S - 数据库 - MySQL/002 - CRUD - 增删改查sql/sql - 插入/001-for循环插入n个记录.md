
### for循环插入n个记录

```sql
drop procedure if exists insert_while; -- 如果存在函数insertwhile先删除它

delimiter // -- 将结束符定义为//在begin和end中会使用;如果不换程序会错误
create procedure insert_while() -- 创建存储过程
begin
    declare i int default 1;
    while i<=1000  -- 创建1000条记录
    do
        insert into people(id,name,my_email,address) values(substring(md5(rand()),1,10),concat('name',i),concat('my_email',i),concat('address',i));
        set i=i+1;
    end while;
    commit;
end //
delimiter ; -- 结束符换回;号

call insert_while(); -- 调用插入方法,否则无法插入
```

### 实体类

```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "people") //对应mysql的表名
public class People {
    @Id // 主键，id是uuid形式，不是自增
    @GenericGenerator(name = "idGenerator", strategy = "uuid") // id采用uuid生成
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="my_email")
    private String myEmail;

    @Column(name="address")
    private String address;
}
```
