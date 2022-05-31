
即使在try代码块中执行了return语句，但是finally语句

```java
public class TestStudent {

  public static void main(String[] args) {
    System.out.println(rrr());
  }
  
  private static String rrr(){
    try{
      System.out.println("1----------");
      return "1";
    }catch (Exception e){
      return e.getMessage();
    }finally{
      System.out.println("2----------");
    }
  }
  
}
```
