

拿不到数据库的值，首先测试是否能够连接上数据库。

如果能连接到数据库，但是拿不到值，看看是不是查询语句的问题。

使用navicat连接oracle数据库即可

    为什么sql语句要写的这么麻烦，怎么能简化？


```jshelllanguage
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestOraclConnect {

    public static void main(String[] args) {
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String dbURL = "jdbc:oracle:thin:@127.0.0.1:1521:test";
            conn = DriverManager.getConnection(dbURL, "system", "123456");
            String sql = "select * from SYSTEM.PERSONS";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println("TestID:"+rs.getString(1));
                System.out.println("Describe:"+rs.getString(2));
            }
            System.out.println("连接成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


```