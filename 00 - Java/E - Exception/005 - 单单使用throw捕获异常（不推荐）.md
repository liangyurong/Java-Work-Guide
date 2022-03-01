


### 遇到3的时候，会抛出异常，并且for循环会直接停止，不会再执行 i=4,5,6,7,8,9

```jshelllanguage
  public static void main(String[] args) throws Exception {
     int size = 10;
     for (int i = 1; i < size; i++) {
       System.out.println("此时的数值："+i+"\n");
        if(i%3==0){
          throw new Exception(i+"被3整除啦");
        }
    }
  }
```

### 执行结果

```text
此时的数值：1

Exception in thread "main" java.lang.Exception: 3被3整除啦
at com.sdyb.mp.controller.StuController.main(StuController.java:82)

此时的数值：2

此时的数值：3
```


### 更改后的源码能够捕获异常，并继续执行for循环

```jshelllanguage
  public static void main(String[] args) {
     int size = 10;
     for (int i = 1; i < size; i++) {
       try{
         if(i%3==0){
           throw new Exception(i+"被3整除啦");
         }
       }catch (Exception e){
          System.out.println(e.toString());
       }
    }
  }
```

结果
```text
java.lang.Exception: 3被3整除啦
java.lang.Exception: 6被3整除啦
java.lang.Exception: 9被3整除啦
```
