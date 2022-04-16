### 使用forEach输出 - 数组

对于数组，不能直接使用stream()方法。需要使用Arrays.stream()转换。

```jshelllanguage
    public static void main(String[] args) {

        String[] arr = new String[]{"A","B","c","D"};
        Arrays.stream(arr).forEach(System.out::println);

        int[] arr = new int[]{1,1,2,3,5,8};
        Arrays.stream(arr).forEach(System.out::println);
    }
```
