
### list转double数组

```java
public class Test{
    public void test(){
              // list后需要声明String
              List<String> list = new ArrayList<>();
              list.add("1.00");
              list.add("2.00");
              list.add("3.00");
              list.add("4.00");
        
              // list转double数组(遍历list，将里面的元素转为double类型)
              double[] dArray = list.stream().mapToDouble(Double::parseDouble).toArray(); 
              // 等同于 double[] dArray = list.stream().mapToDouble(num->Double.parseDouble(num)).toArray();
        
              for (double d : dArray) {
                 System.out.println(d);
              }
    }
}
```

### 

### list转int数组

```java
public class Test{
    public void test(){
            List<String> list = new ArrayList<>();
            list.add("1");
            list.add("2");
            list.add("3");
            list.add("4");
      
            // list转int数组
            int[] arr = list.stream().mapToInt(Integer::parseInt).toArray();
            for (int d : arr) {
               System.out.println(d);
            }
    }
}
```



