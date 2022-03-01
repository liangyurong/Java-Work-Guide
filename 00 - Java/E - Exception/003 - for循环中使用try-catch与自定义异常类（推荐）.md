### try-catch与自定义异常捕捉时候冲突


### try catch中捕获异常：捕捉自定义异常，但不能影响下一次的循环

```jshelllanguage
class Test{
      public static void main(String[] args) {
         int size = 10;
         for (int i = 0; i < size; i++) {
           // 捕捉自定义异常，但不影响下一次的循环
           try{
             zhengchu(i);
           }catch (Exception e){
            // 这里能够输出自定义抛出的异常   
            System.out.println(e.toString());
           }
        }
      }
    
      //  自定义异常
      public static void zhengchu(int i ){
        if(i%2==0){
          throw new MpException(i+"能被2整除");
        }
      }
}
```

### 执行结果

MpException(code=0, msg=0能被2整除)
MpException(code=0, msg=2能被2整除)
MpException(code=0, msg=4能被2整除)
MpException(code=0, msg=6能被2整除)
MpException(code=0, msg=8能被2整除)

### 自定义异常类

```jshelllanguage
import lombok.Data;

@Data
public class MpException extends RuntimeException {

  private int code;
  private String msg;

    public MpException(){

    }

  public MpException(int code){
      this.code=code;
  }

  public MpException(String msg) {
    this.msg = msg;
  }

    public MpException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
}
```
