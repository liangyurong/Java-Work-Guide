
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
    List<Integer> newList1 = list.stream().map(base -> ++base).collect(Collectors.toList());
    newList1.forEach(System.out::println);
  }
}

```
