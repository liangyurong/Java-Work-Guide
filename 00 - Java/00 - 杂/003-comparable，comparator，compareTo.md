
### 一、comparable

排序接口 

Collections.sort() 和 Arrays.sort()方法可以对Object数组进行排序，但是这种方法排序要求对象所在的类必须实现Comparable接口，此接口用于指定排序规则

使用Collections.sort()方法的时候，需要对象所在的类实现Comparable接口

String、Integer已经实现了Comparable接口，自己就可以完成比较大小操作

Comparable是在集合内部定义的方法实现的排序，位于java.util下。

Arrays集合类实现了comparable接口
```text
import java.util.*;
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,4,1};
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
```

comparable接口源码
```text
public interface Comparable<T> {
    public int compareTo(T o);
}
```

comparable示例代码
```java
import java.util.*;
public class Test {
    public static void main(String[] args) {
        List<Student> list= new ArrayList<>();
        list.add(new Student("S1",22));
        list.add(new Student("S2",44));
        list.add(new Student("S3",33));
        list.add(new Student("S4",11));
        System.out.println("排序前："+list);
        Collections.sort(list);
        System.out.println("排序后："+list);
    }
}
// 实体类继承了Comparable接口，重写compareTo方法
class Student implements Comparable<Student>{
    private String name;
    private Integer age;
    
    @Override
    public int compareTo(Student otherStudent) {
         // 根据年龄比较
     if(this.age.equals(otherStudent.age)){
       return 0;
     }else{
       return this.age-otherStudent.age; //升序排序
     }
    }
    
    Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString(){
        return name+" "+age;
    }
}
```

### 二、comparator

比较器接口

Comparator是在集合外部实现的排序，位于java.lang下

使用Comparator的优点
- 与实体类分离
- 方便应对多变的排序规则

用 Comparator 是策略模式（strategy design pattern），就是不改变对象自身，而用一个策略对象（strategy object）来改变它的行为

源码
```java
package java.util;
public interface Comparator<T> {
    int compare(T o1, T o2);
    boolean equals(Object obj);
}
```

// Comparator示例代码
```java
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Person> l2=new ArrayList<>();
        l2.add(new Person("P1",22));
        l2.add(new Person("P2",44));
        l2.add(new Person("P3",33));
        l2.add(new Person("P4",11));
        System.out.println("排序前："+l2);
        Collections.sort(l2,new PersonComparator());
        System.out.println("排序后："+l2);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private String name;
    private Integer age;

    @Override
    public String toString(){
        return name+" "+age;
    }
}
class PersonComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }
}
```


