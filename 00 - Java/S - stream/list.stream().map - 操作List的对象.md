### 使用stream操作集合中的对象

```java
import com.lyr.demo.entity.People;
import com.lyr.demo.entity.PeopleData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<People> list = new LinkedList<>();
        list.add(new People("1", "1","1","1"));
        list.add(new People("2", "2","2","2"));
        list.add(new People("3", "3","3","3"));
        list.add(new People("4", "4","4","4"));
        list.add(new People("5", "5","5","5"));

        list.stream().map(entity -> new People(
                                entity.getId() + "heihie",
                                entity.getName() + "name",
                                entity.getMyEmail() + "email",
                                entity.getAddress()+"address"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

}
```

输出
```text
People(id=1heihie, name=1name, myEmail=1email, address=1address)
People(id=2heihie, name=2name, myEmail=2email, address=2address)
People(id=3heihie, name=3name, myEmail=3email, address=3address)
People(id=4heihie, name=4name, myEmail=4email, address=4address)
People(id=5heihie, name=5name, myEmail=5email, address=5address)
```
