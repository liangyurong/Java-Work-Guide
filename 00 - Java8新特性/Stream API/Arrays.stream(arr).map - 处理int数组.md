### 将int数组的元素进行平方操作,之后转为List集合，进行输出

```jshelllanguage
import java.util.Arrays;
import java.util.stream.Collectors;

    public static void main(String[] args) {
        // 这里是int数组
        int[] arr = new int[]{1,1,2,3,5,8};
        Arrays.stream(arr).map(n -> n * n)
                .boxed()                       // 将一个IntStream转换为一个Stream<Integer>
                .collect(Collectors.toList())  // 打包成集合
                .forEach(System.out::println); // 输出
    }
```

结果

    1 1 4 9 25 64

### 将int数组的元素进行平方操作,之后转为List集合，排序，进行输出

```jshelllanguage
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

    public static void main(String[] args) {
        
        // 使用的是Integer数组
        Integer[] arr = new Integer[]{1,1,2,3,5,8};

        List<Integer> list =
                Arrays.stream(arr) // 将数组转换成流
                        .map(n -> n * n)   // n = n * n
                        .collect(Collectors.toList());// 打包成集合

        list.sort((num1,num2)->(num1-num2));; // 升序排序
        // 等同于 list.sort(Comparator.comparingInt((Integer num) -> num));

        list.forEach(System.out::println);
        
    }
```

结果

    1 1 4 9 25 64

等同于

```jshelllanguage
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,1,2,3,5,8};

        List<Integer> list =
                Stream.of(arr)             // 将数组转换成流
                        .map(n -> n * n)   // n = n * n
                        .collect(Collectors.toList());// 打包成集合

        // 升序排序
        list.sort((num1,num2)->(num1-num2));; 

        list.forEach(System.out::println);
        
    }
}
```