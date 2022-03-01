


### 一、对int类型数据排序

```jshelllanguage
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(3);

        // 升序排序
        list.sort((Integer num1,Integer num2)->(num1-num2)); 
         
        list.forEach(System.out::println);
    }
```

### 二、对集合对象排序，根据年龄排序

```jshelllanguage
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(3);

        // 升序排序
        list.sort((Integer num1,Integer num2)->(num1-num2)); 
        //  list.sort((MyUser u1,MyUser u2)->(u1.getAge()-u2.getAge())); (等同于上面的语句)
        
        // 降序排序
        // list.sort(Comparator.comparingInt(MyUser::getAge).reversed());
        // list.sort((MyUser u1,MyUser u2)->(u2.getAge()-u1.getAge()));

        list.forEach(System.out::println);
    }
```

实体类
```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class MyUser {
    private String name;
    private Integer age;
}
```






















