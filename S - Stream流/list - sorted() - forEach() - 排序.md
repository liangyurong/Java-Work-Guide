### list.stream().sort - List元素排序

```jshelllanguage
import java.util.*;

public class Test {
public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(4);

        // 升序排序
       // list.stream().sorted().forEach(System.out::println);

        // 降序排序
        list.stream().sorted(Comparator.comparingInt(num -> -num)).forEach(System.out::println);

    }
}
```