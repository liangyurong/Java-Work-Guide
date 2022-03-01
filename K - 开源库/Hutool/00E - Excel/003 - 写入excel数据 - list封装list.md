
### 源码

```java
import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.junit.Test;
import java.util.List;

public class TestHutool {

  @Test
  public void testExcel() {

    // 构建写入的数据
    List row1 = CollUtil.newArrayList(1, "11", 1);
    List row2 = CollUtil.newArrayList(2, "22", 2);
    List row3 = CollUtil.newArrayList(3, "33", 3);
    List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3);

    // excel文件路径
    String filePath = "C:/Users/lyr/Desktop/basic_info.xlsx";

    // 通过工具类创建writer
    ExcelWriter writer = ExcelUtil.getWriter(filePath);

    // 定位到最后一行的后边，用于追加数据(从hutool的版本5.5.0开始支持)
    writer.setCurrentRowToEnd();

    // 一次性写出内容，使用默认样式，强制输出标题
    writer.write(rows, true);

    // 关闭writer，释放内存
    // write（写出数据）方法后只是将数据写入到Workbook，并不写出文件，只有调用flush或者close方法后才会真正写出文件
    writer.close();
  }
}

```
### 依赖

```xml
        <!-- hutool -->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.5.0</version>
        </dependency>
        <!--Hutool工具ExcelUtil依赖这个 https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>3.17</version>
        </dependency>
```
