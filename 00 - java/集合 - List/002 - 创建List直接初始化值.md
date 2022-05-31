### 创建List直接初始化值

方法1
```java
    List<String> list = Arrays.asList("aa","ss","dd");
```

方法2
```java
    String[] arr = {"aa","ss","dd"};
    List<String> list = Arrays.asList(arr);
```


方法3 : java8使用Stream来创建
```java
    List<String> list = Stream.of("aa", "ss", "dd").collect(Collectors.toList());
```

方法4 : JDK9 为集合引入了几种方便的工厂方法.一个重要的细节是返回的实例是不可变的。除此之外，工厂方法在空间效率和线程安全方面有几个优势
```java
List<String> list = List.of("foo", "bar", "baz");
```

方法5：
```java
    List<String> list = new ArrayList(){
        {
            add("a");
            add("d");
            add("f");
        }
    };
```
