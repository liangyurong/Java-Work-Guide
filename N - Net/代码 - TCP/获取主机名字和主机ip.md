

```jshelllanguage
import java.net.*;
public class ZZ {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());//返回主机名字和IP地址，yurong333333.local/192.168.31.142

        InetAddress i=InetAddress.getLocalHost();
        System.out.println("主机ip： "+i.getHostAddress());//返回主机ip
        System.out.println("主机名字： "+i.getHostName());//返回主机名字

        InetAddress ia=InetAddress.getByName("192.168.31.142");//如果这个ip不在网络上，那么输出的都是ip
        System.out.println("ia的主机名字："+ia.getHostName());
        System.out.println("ia的主机IP"+ia.getHostAddress());

        //获取百度主机地址
        InetAddress ia1=InetAddress.getByName("www.baidu.com");//
        System.out.println("百度主机名字："+ia1.getHostName());
        System.out.println("百度主机IP："+ia1.getHostAddress());

    }
}
```
