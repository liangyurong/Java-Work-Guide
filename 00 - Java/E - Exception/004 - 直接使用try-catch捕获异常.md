## 直接使用try catch捕获异常，但不影响for循环

直接try catch也是不影响for循环

```jshelllanguage
  public static void main(String[] args) {
     int size = 10;
     for (int i = 0; i < size; i++) {
       try{
         int b = i/0;
        System.out.println(b);
       }catch (Exception e){
        System.out.println(e.toString());
       }
    }
  }
```

### 执行结果

```jshelllanguage
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
```
