### 将int数组的元素进行平方操作,之后转为List集合，进行输出

```jshelllanguage
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3,5,8};
        Arrays.stream(arr).map(n -> n * n)
                .boxed()                       // 将一个IntStream转换为一个Stream<Integer>
                .collect(Collectors.toList())  // 打包成集合
                .forEach(System.out::println); // 输出
    }
```

### 将int数组的元素进行平方操作,之后转为List集合，排序，进行输出
```jshelllanguage
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,5,6,2};
        List<Integer> list = Arrays.stream(arr)
                .map(n -> n * n)   // n = n * n
                .boxed()           // 将一个IntStream转换为一个Stream<Integer>
                .collect(Collectors.toList());// 打包成集合
        list.sort((Integer num1,Integer num2)->(num1-num2));
        list.forEach(System.out::println);
    }
```
