

### 通过forEach来去到list的每一个值

```jshelllanguage
  public static void main(String[] args) {

    List<String> list = new ArrayList<>();
    list.add("cc");
    list.add("aa");
    list.add("bb");
    
    // str就代表list里面的一个元素
    list.forEach( str -> {
          System.out.println(str);
    });
    
  }
```
