### map.stream - 操作map

```jshelllanguage
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>();
        map.put("小4",24);
        map.put("小1",21);
        map.put("小2",22);
        map.put("小5",25);
        map.put("小3",23);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        entrySet.stream()
                .filter(entry -> entry.getValue()>23)
                .forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));
    }
}
```

结果

    小5 : 25
    小4 : 24