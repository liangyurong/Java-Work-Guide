

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestConnectMySQL {
    public static void main(String[] args) {
        // 1、创建一个数据库连接
        Connection con = null;
        // 2、创建预编译语句对象，一般都是用这个而不用Statement
        PreparedStatement pre = null;
        // 3、创建一个结果集对象
        ResultSet result = null;
        // 4、数据库信息
        String url = "jdbc:mysql://localhost:3306/lyr?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8";
        String user = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
