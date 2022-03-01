### 在键盘连续输入一个数字和字符串，容易出现的错误

```java
import java.util.Scanner;
/**
* 读取一个数字之后，就读取不到下一个输入的字符串
* 原因：nextLine吸收了\n
* 解决：在之后添加代码s.nextLine()即可
*/
public class Test{
    public static void main(String[] args)  {
        Scanner s = new Scanner(System.in);
        int age = s.nextInt();//以enter为结束
        s.nextLine();
        String str = s.nextLine();
        System.out.println(age+" "+str);
    }
}
```

### readLine()方法详解

其实本质是在硬盘上一个字符一个字符进行读取
    
windows下的换行符是’\r\n’

























