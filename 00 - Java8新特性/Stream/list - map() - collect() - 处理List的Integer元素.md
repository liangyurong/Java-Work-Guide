
Stream.map()是Stream最常用的一个转换方法，它把一个Stream转换为另一个Stream。

```java
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStudent {

  public static void main(String[] args) {

    List<Integer> list = new LinkedList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    // 管道：对每个进行处理
    List<Integer> newList1 = 
            list.stream()                          // 集合转换成流
                    .map(base -> base*2)           // 对流中的元素进行计算或转换
                    .collect(Collectors.toList());
   
    newList1.forEach(System.out::println);
  
  }
}
```

### 结果

    2
    4
    6
    8
