### 源码

```java

import java.io.File;
import java.util.List;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.Test;

public class TestHutool {

  @Test
  public void testExcel() {
        // excel文件路径
        String filePath = "C:/Users/lyr/Desktop/basic_ino.xlsx";

        // 建立File对象
        File file = FileUtil.file(filePath);

        // 从文件中读取Excel为ExcelReader
        ExcelReader reader = ExcelUtil.getReader(file);

        // 读取Excel中所有行和列，都用列表表示(一行数据是一个list，然后这个list被当做一个元素存在大List中)
        List<List<Object>> read = reader.read();

        // 循环取出list中的每个元素
        read.forEach(base -> {
              System.out.println(base);
        });
        
    }
}

```

### 结果

说明：第一个元素是标题，从第二个元素开始才是对应的值

```text
[id, name, age]
[1, 1, 1]
[2, 2, 2]
[3, 3, 3]
```













