

### 步骤

前提：IDEA，在project structure中引入ojdbc8.jar包

说明：连接本地和远程oracle都可以。

1、IDEA通过project structure添加一个jar包。名称为ojdbc8.jar

2、编写代码。（pom.xml文件中不需要引入其他的依赖）

下面的依赖是不需要的
```xml
<!--oracle驱动-->
<dependency>
    <groupId>com.oracle</groupId>
    <artifactId>ojdbc6</artifactId>
</dependency>
```

代码
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectOracle {
    public static void main(String[] args) {
        // 1、创建一个数据库连接
        Connection con = null;
        // 2、创建预编译语句对象，一般都是用这个而不用Statement
        PreparedStatement pre = null;
        // 3、创建一个结果集对象
        ResultSet result = null;
        // 4、数据库信息
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
        String user = "c##med_res";
        String password = "zteict2017";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("开始尝试连接数据库！");

            con = DriverManager.getConnection(url, user, password);
            System.out.println("连接成功！");
        }
        catch (Exception e) {
            System.out.println("连接失败,"+e.toString());
        }
        finally {
            try {
                //关闭的顺序，最后使用的最先关闭
                if (null!=con) {
                    con.close();
                }
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```
